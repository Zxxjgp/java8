package com.example.demo.test.api;

import cfca.sadk.control.sip.api.SIPDecryptionBuilder;
import cfca.sadk.control.sip.api.SIPDecryptor;

/**
 * @Author qazhang
 * @Description 功能测试
 * @CodeReviewer liujiancheng
 *
 */
public final class TestFunctions {

    public static void main(String[] args) throws Exception {
/*        System.out.println("command:[-keyType=<>][-pfxpath=<>][-password=<>][-base64ServerRandom=<>][-base64EncryptedRc=<>][-base64EncryptedData=<>][-all]");

        System.out.println("command: [-pfxpath=<certPath>]");
        System.out.println("command: [-password=<password>]");
        System.out.println("command: [-base64ServerRandom=<base64ServerRandom>]");
        System.out.println("command: [-base64EncryptedRc=<base64EncryptedRc>]");
        System.out.println("command: [-base64EncryptedData=<base64EncryptedData>]");

        TestParams testParams = TestParams.parseParams(args);

        System.out.println(testParams);

        final SIPDecryptor decryptor = testParams.buildSIPDecryptor();
        final String base64ServerRandom = testParams.getBase64ServerRandom();
        final String base64EncryptedRc = testParams.getBase64EncryptedRc();
        final String base64EncryptedData = testParams.getBase64EncryptedData();
        final String expected = testParams.getExpected();

        final String actual = decryptor.decrypt(base64ServerRandom, base64EncryptedRc, base64EncryptedData);
        System.out.println("expected=" + expected);
        System.out.println("actual=" + actual);
        System.out.println("decryptResult: " + expected.equals(actual));

        boolean testAll = false;
        String command;
        for (int i = 0; i < args.length; i++) {
            command = "-all";
            if (args[i].startsWith(command)) {
                testAll = true;
                break;
            }
        }
        if (testAll) {
            testRSA2048(200);
            testRSA1024(500);
            testSM2(500);
        }*/

    }

    public static void testRSA2048(final int num) throws Exception {
        final String base64ServerRandom = "MTIzNDU2Nzg5MDk4NzY1NA==";
        final String base64EncryptedRc = "MI+aHYKjBGPmIPEh3o97WgVel1MX+CMAlNG8bouNMWLz2jKwqHsr8eo3TangYjEPgMfS+fy10lMYLEMARlJXDCnnUcQBWUQZWBkOjVWZy82vslxlmK4759cvwIGZEw/hyAPwcJTxQXK8VE0bq5wJfxSDDXVsTk3w9e7y9/SRP/x0MviL41VgF8zBjeekIz0EcZtc9xqt+dVzO+NQYvo4aFhUyuNG06sUxGEQPlMHnAC3e6bTJ1Us5afTy0Uvt9ntiaBVYSB7FbyCD1Y8pO5z2aAAaQfjFEApiXwiJQklYSWbf5gmHOUGsiGZP06K7GDeGI4BFYF4uf4lxSY5gyoTiw==";
        final String base64EncryptedData = "mRGInkWT+Wc= ";
        final String rsa2048File = "TestData/timestamp_rsa2048_cfca1234.pfx";
        final String rsa2048Pass = "cfca1234";
        final String expected = "qqq111";
        final SIPDecryptor decryptor = SIPDecryptionBuilder.rsa().config(rsa2048File, rsa2048Pass);

        String actual = null;
        long staTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            actual = decryptor.decrypt(base64ServerRandom, base64EncryptedRc, base64EncryptedData);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - staTime;
        double perf = 1000.0 * num / time;
        System.out.println(String.format("RSA2048:  num=%6s,time=%6s,tps-perf=%8.2f,expected=%12s, actual=%12s ", num, time, perf, expected, actual));
    }

    public static void testRSA1024(final int num) throws Exception {
        final String base64ServerRandom = "MTIzNDU2Nzg5MDk4NzY1NA==";
        final String base64EncryptedRc = "MazJbHfdn09yB4qZu9KMd/0oDyVk7hT/FmOX86QLS3+hAF3B2QkOVtdReOy2hGEesJBnocgvOSdYXI4rImDgzRomTmnMsz8VddOaHoSi39qVyFZgecOKmEb91JdyQZZ8At8VF5+P7pQXOygz7TtFn/tYKqX2/oS9cqd6pXRLhC4=";
        final String base64EncryptedData = "Qj2VYsZ3RgdIrGQNPnmfnQ== ";
        final String rsa1024File = "TestData/rsa1024_11111111.pfx";
        final String rsa1024Pass = "11111111";
        final String expected = "1234qwer";

        final SIPDecryptor decryptor = SIPDecryptionBuilder.rsa().config(rsa1024File, rsa1024Pass);

        String actual = null;

        long staTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            actual = decryptor.decrypt(base64ServerRandom, base64EncryptedRc, base64EncryptedData);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - staTime;
        double perf = 1000.0 * num / time;
        System.out.println(String.format("RSA1024:  num=%6s,time=%6s,tps-perf=%8.2f,expected=%12s, actual=%12s ", num, time, perf, expected, actual));
    }

    public static void testSM2(final int num) throws Exception {
        String pfxFile = "TestData/sm2Encrypt_111111.sm2";
        String password = "111111";
        String base64ServerRandom = "MTIzNDU2Nzg5MDk4NzY1NA==";
        String base64EncryptedRc = "OMef+AwNfui2R6RiLskt+sliZiye1eixykFkKIjqfWNQ+mWtWUfyC0QW3zS4LRZ29MYW309wgYhjxXxsrtnscxOI0N+8uKocI+hSVr8TVwPMdEwabR1CoE6XkyQgiCuDhw9PT9YpK5Tliotq6VeTXA== ";

        String base64EncryptedData = "5dcZK+1vt39e2P6+5ICLOQ==";
        final String expected = "1233qwer";

        final SIPDecryptor decryptor = SIPDecryptionBuilder.sm2().config(pfxFile, password);

        String actual = null;
        long staTime = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            actual = decryptor.decrypt(base64ServerRandom, base64EncryptedRc, base64EncryptedData);
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - staTime;
        double perf = 1000.0 * num / time;
        System.out.println(String.format("SM2-256:  num=%6s,time=%6s,tps-perf=%8.2f,expected=%12s, actual=%12s ", num, time, perf, expected, actual));

    }
}
