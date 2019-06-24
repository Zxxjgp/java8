package com.example.demo.test.data;

import cfca.sadk.util.Base64;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * @Author qazhang
 * @Description SM2测试数据
 * @CodeReviewer liujiancheng
 *
 */
public final class SM2TestData implements SIPTestData {

    final String pfxFile = "TestData/sm2Encrypt_111111.sm2";
    final String pfxPass = "111111";

    final String base64ServerRandom = "MTIzNDU2Nzg5MDk4NzY1NA==";
    final String base64EncryptedRc = "OMef+AwNfui2R6RiLskt+sliZiye1eixykFkKIjqfWNQ+mWtWUfyC0QW3zS4LRZ29MYW309wgYhjxXxsrtnscxOI0N+8uKocI+hSVr8TVwPMdEwabR1CoE6XkyQgiCuDhw9PT9YpK5Tliotq6VeTXA== ";

    final String base64EncryptedData = "5dcZK+1vt39e2P6+5ICLOQ==";

    final String expected = "1233qwer";

    @Override
    public String pfxFile() {
        return pfxFile;
    }

    @Override
    public String pasword() {
        return pfxPass;
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




    public static void main(String[] args) throws UnsupportedEncodingException {
        String base64ServerRandom = "";
        for (int i = 0; i < 16; i++)
        {
            base64ServerRandom += (int) Math.floor(Math.random() * 10);
        }
        base64ServerRandom = new String(Base64.encode(base64ServerRandom.getBytes()));
        System.out.println(base64ServerRandom.length());
        System.out.println(base64ServerRandom);
    }


}
