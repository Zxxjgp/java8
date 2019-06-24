package com.example.demo.test.perf;

import cfca.org.slf4j.Logger;
import cfca.org.slf4j.LoggerFactory;
import cfca.sadk.control.sip.DecryptionException;
import cfca.sadk.control.sip.api.SIPDecryptor;
import demo.cfca.sadk.control.sip.api.TestParams;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author qazhang
 * @Description 性能测试
 * @CodeReviewer liujiancheng
 *
 */
public final class TestPerf {

    static final Logger LOG = LoggerFactory.getLogger(TestPerf.class);

    public static void main(String[] args) throws Exception {
        System.out
                .println("command:[-keyType=<rsa1024|rsa2048:sm2>][-pfxpath=<>][-password=<>][-base64ServerRandom=<>][-base64EncryptedRc=<>][-base64EncryptedData=<>][-thread=<>][-console][-reportTime=] [-reload]");

        System.out.println("command: [-keyType=<rsa1024|rsa2048:sm2>]");
        System.out.println("command: [-thread=<number>]");
        System.out.println("command: [-pfxpath=<certPath>]");
        System.out.println("command: [-password=<password>]");
        System.out.println("command: [-base64ServerRandom=<base64ServerRandom>]");
        System.out.println("command: [-base64EncryptedRc=<base64EncryptedRc>]");
        System.out.println("command: [-base64EncryptedData=<base64EncryptedData>]");
        System.out.println("command: [-console]");
        System.out.println("command: [-reportTime=<milliseconds>]");
        System.out.println("command:[-reload]");

        boolean console = true;
        boolean reload = false;
        int reportTime = 5000;
        int thread = 64;
        String command = null;
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-console")) {
                console = true;
                continue;
            }
            if (args[i].startsWith("-reload")) {
                reload = true;
                continue;
            }
            command = "-reportTime=";
            if (args[i].startsWith(command)) {
                reportTime = Integer.parseInt(args[i].substring(command.length()).trim());
                continue;
            }

            command = "-thread=";
            if (args[i].startsWith(command)) {
                thread = Integer.parseInt(args[i].substring(command.length()).trim());
                continue;
            }
        }

        final TestParams testParams = TestParams.parseParams(args);
        LOG.info(testParams.toString());

        System.out.println(testParams);

        System.out.println("console=" + console);
        System.out.println("reload=" + reload);
        System.out.println("reportTime=" + reportTime);
        System.out.println("thread=" + thread);

        final boolean reloadFalg = reload;

        final SIPDecryptor decryptor = testParams.buildSIPDecryptor();
        final String base64ServerRandom = testParams.getBase64ServerRandom();
        final String base64EncryptedRc = testParams.getBase64EncryptedRc();
        final String base64EncryptedData = testParams.getBase64EncryptedData();
        final String expected = testParams.getExpected();

        final String actual = decryptor.decrypt(base64ServerRandom, base64EncryptedRc, base64EncryptedData);
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        System.out.println("decryptResult: " + expected.equals(actual));

        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        final NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMinimumFractionDigits(3);

        final Record record = new Record();

        final ThreadPoolExecutor pool = new ThreadPoolExecutor(10, thread, 30, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10),
                new CustomThreadFactory(), new CustomRejectedExecutionHandler());

        for (int i = 0; i < thread; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    long strTime = System.currentTimeMillis();
                    long endTime = System.currentTimeMillis();
                    long rspTime = 0;
                    String actual = null;
                    while (true) {
                        try {

                            strTime = System.currentTimeMillis();

                            if (reloadFalg) {
                                final SIPDecryptor decryptor = testParams.buildSIPDecryptor();
                                actual = decryptor.decrypt(base64ServerRandom, base64EncryptedRc, base64EncryptedData);
                            } else {
                                actual = decryptor.decrypt(base64ServerRandom, base64EncryptedRc, base64EncryptedData);
                            }

                            endTime = System.currentTimeMillis();
                            rspTime = (endTime - strTime);

                            if (expected.equals(actual)) {
                                record.addPassed(rspTime);
                            } else {
                                record.addFailed();
                            }

                        } catch (DecryptionException e) {
                            record.addFailed();
                            LOG.error("timestamp-failed", e);
                        } catch (Exception e) {
                            record.addFailed();
                            LOG.error("timestamp-failed", e);
                        }
                    }
                }
            });
        }

        long rspTime = 0;
        long avgTime = 0;
        double upTime;
        String cliTime;
        String tsaTime = "";
        String percent;

        String message = null;

        long runTime0 = System.currentTimeMillis();
        long runTime1 = System.currentTimeMillis();
        long runTime = 0;
        long exeTime0 = System.nanoTime();
        long exeTime1 = System.nanoTime();
        long exeTime = 0;
        long allTime = 0;
        long num;

        int reportMS = reportTime < 1000 ? 1000 : reportTime;

        long[] timex;
        long[] count;
        long[] countTotal;

        while (true) {
            runTime0 = System.currentTimeMillis();
            exeTime0 = System.nanoTime();
            Thread.sleep(reportMS);
            num = record.numTask.get();
            timex = record.timex.clone();
            count = record.count.clone();
            countTotal = record.countTotal.clone();
            long succT = record.succTime.get();
            long succno = record.succTask.get();
            long allno = record.allTask.get();
            long errno = record.errTask.get();
            long minT = record.minTime.get();
            long maxT = record.maxTime.get();
            record.numTask.set(0);

            runTime1 = System.currentTimeMillis();
            runTime = runTime1 - runTime0;
            runTime0 = runTime1;
            exeTime1 = System.nanoTime();
            exeTime = (exeTime1 - exeTime0) / 1000000L;
            exeTime0 = exeTime1;
            allTime += exeTime;

            avgTime = allno == 0 ? 0 : succT / succno;
            cliTime = dateFormat.format(new Date(runTime1));
            upTime = (System.nanoTime() / 1000000000.0);

            message = String.format("sip: %s@upTime=%8.2f rspTime=%04d [avg=%4d,min=%4d,max=%4d] -->>tsa: %s ", cliTime, upTime, rspTime, avgTime, minT, maxT,
                    tsaTime);
            StringBuilder builder = new StringBuilder(512);
            builder.append(message);
            percent = allno == 0 ? "-" : numberFormat.format((1.0 * succno) / allno);
            builder.append(String.format("\n passed: %8s, %8d, %8s", "", succno, percent));
            int i = 0;
            for (; i < record.timexLength; i++) {
                percent = allno == 0 ? "-" : numberFormat.format((1.0 * countTotal[i]) / allno);
                builder.append(String.format("\n %6d: %8d, %8d, %8s", timex[i], count[i], countTotal[i], percent));
            }
            percent = numberFormat.format((1.0 * countTotal[i]) / allno);
            builder.append(String.format("\n  5000+: %8d, %8d, %8s", count[i], countTotal[i], percent));
            percent = numberFormat.format((1.0 * errno) / allno);
            builder.append(String.format("\n failed: %8s, %8d, %8s", "", errno, percent));

            double runtps = num * 1000.0 / runTime;
            double exetps = num * 1000.0 / exeTime;
            double alltps = succno * 1000.0 / allTime;
            builder.append(String.format("\n  [tps]: %5.2f, %5.2f, %5.2f", runtps, exetps, alltps));

            message = builder.toString();
            if (console) {
                System.out.println(message);
            }
            LOG.info(message);

        }

    }

    static final class Record {
        final int timexLength = 7;
        // 50-100-200-500-1000-2000-5000-5000+
        final long[] timex = new long[] { 50, 100, 200, 500, 1000, 2000, 5000 };
        final long[] countTotal = new long[1 + timexLength];
        final long[] count = new long[1 + timexLength];

        final AtomicLong succTime = new AtomicLong(0L);
        final AtomicLong succTask = new AtomicLong(0L);

        final AtomicLong allTask = new AtomicLong(0L);
        final AtomicLong numTask = new AtomicLong(0L);
        final AtomicLong errTask = new AtomicLong(0L);

        final AtomicLong maxTime = new AtomicLong(0L);
        final AtomicLong minTime = new AtomicLong(5000L);

        Record() {
            Arrays.fill(countTotal, 0L);
            Arrays.fill(count, 0L);
        }

        final void addPassed(long rspTime) {
            numTask.incrementAndGet();
            allTask.incrementAndGet();
            succTask.incrementAndGet();
            succTime.addAndGet(rspTime);

            if (rspTime > maxTime.get()) {
                maxTime.set(rspTime);
            }
            if (rspTime < minTime.get()) {
                minTime.set(rspTime);
            }
            // 50-100-200-500-1000-2000-5000-5000+
            if (rspTime > 5000) {
                countTotal[timexLength]++;
                count[timexLength]++;
            } else {
                if (rspTime <= 50) {
                    countTotal[0]++;
                    count[0]++;
                }
                boolean skipped = false;
                for (int i = 1; i < timexLength; i++) {
                    if (rspTime <= timex[i]) {
                        countTotal[i]++;
                    }
                    if (skipped) {
                        continue;
                    }
                    if (rspTime <= timex[i] && rspTime > timex[i - 1]) {
                        count[i]++;
                        skipped = true;
                    }
                }
            }
        }

        final void addFailed() {
            errTask.incrementAndGet();
            allTask.incrementAndGet();

        }
    }

    static class CustomThreadFactory implements ThreadFactory {

        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            String threadName = "TestPerf" + count.addAndGet(1);
            System.out.println(threadName);
            t.setName(threadName);
            return t;
        }
    }

    static class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

        }
    }

}
