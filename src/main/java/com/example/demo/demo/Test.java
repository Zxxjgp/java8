package com.example.demo.demo;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.IntToDoubleFunction;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Test
 * @date 2019/5/23  22:51
 */
public class Test {
    public String get(String c){
        return null;
    }

    public static void main(String[] args) throws ParseException {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });

        AtomicBoolean result = new AtomicBoolean(false);
        result.set(true);

        if ( result.get() == true ) {
            System.out.println("1111111111111");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2118-08-08 12:10:12");

        System.out.println(idHandle("340826199110142211"));
        Date curr = new Date();
        System.out.println(date.before(curr));

        List<Gt> list = new ArrayList<>(4);
        Gt g = new Gt();
        g.setAge(0);
        g.setName("我是中国人");
        Gt gg = new Gt();
        gg.setName("qinlang0");
        gg.setAge(0);
        list.add(g);
        list.add(gg);
        AtomicReference<Integer> count = new AtomicReference<>(0);
        list.stream().forEach( x -> {
            count.updateAndGet(v -> v + x.getAge());
        });

        System.out.println(count.get());
    }
    public static String idHandle(String idCardNumber) {
        if (StringUtils.isEmpty(idCardNumber) || (idCardNumber.length() < 8)) {
            return idCardNumber;
        }
        return idCardNumber.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
    }
    @Data
    public static class Gt{
        private String name;
        private Integer age;
    }

    public String sout(){
        IntToDoubleFunction intToDoubleFunction = (int x) -> x + 1;
        return "";
    }

}
