package com.example.demo.test.data;

/**
 * @Author qazhang
 * @Description RSA1024测试数据
 * @CodeReviewer liujiancheng
 *
 */
public final class RSA1024TestData implements SIPTestData {

    final String base64ServerRandom = "MTIzNDU2Nzg5MDk4NzY1NA==";
    final String base64EncryptedRc = "MazJbHfdn09yB4qZu9KMd/0oDyVk7hT/FmOX86QLS3+hAF3B2QkOVtdReOy2hGEesJBnocgvOSdYXI4rImDgzRomTmnMsz8VddOaHoSi39qVyFZgecOKmEb91JdyQZZ8At8VF5+P7pQXOygz7TtFn/tYKqX2/oS9cqd6pXRLhC4=";
    final String base64EncryptedData = "Qj2VYsZ3RgdIrGQNPnmfnQ== ";
    final String rsa1024File = "TestData/rsa1024_11111111.pfx";
    final String rsa1024Pass = "11111111";
    final String expected = "1234qwer";

    @Override
    public String pfxFile() {
        return rsa1024File;
    }

    @Override
    public String pasword() {
        return rsa1024Pass;
    }

    @Override
    public String base64ServerRandom() {
        return base64ServerRandom;
    }

    @Override
    public String base64EncryptedRc() {
        return base64EncryptedRc;
    }

    @Override
    public String base64EncryptedData() {
        return base64EncryptedData;
    }

    @Override
    public String expected() {
        return expected;
    }

}
