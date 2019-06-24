package com.example.demo.test.api;

import cfca.sadk.control.sip.ConfigurationException;
import cfca.sadk.control.sip.api.SIPDecryptionBuilder;
import cfca.sadk.control.sip.api.SIPDecryptor;
import cfca.sadk.util.Base64;
import com.example.demo.test.data.RSA1024TestData;
import com.example.demo.test.data.RSA2048TestData;
import com.example.demo.test.data.SIPTestData;
import com.example.demo.test.data.SM2TestData;


/**
 * @Author qazhang
 * @Description 测试参数
 * @CodeReviewer liujiancheng
 *
 */
public final class TestParams {

    private String p12File = null;
    private String p12Pass = null;
    private String base64ServerRandom = null;
    private String base64EncryptedRc = null;
    private String base64EncryptedData = null;

    private String expected = null;

    private P12Type p12Type;

    private TestParams(SIPTestData testData) {
        this.p12File = testData.pfxFile();
        this.p12Pass = testData.pasword();
        this.base64ServerRandom = testData.base64ServerRandom();
        this.base64EncryptedRc = testData.base64EncryptedRc();
        this.base64EncryptedData = testData.base64EncryptedData();
        this.expected = testData.expected();
    }

    static public TestParams parseParams(String[] args) throws Exception {

        String keyType = "";
        String command;
        for (int i = 0; i < args.length; i++) {
            command = "-keyType=";
            if (args[i].startsWith(command)) {
                keyType = args[i].substring(command.length()).trim();
                break;
            }
        }
        keyType = keyType.toUpperCase();

        SIPTestData testData;

        P12Type p12Type;
        if (P12Type.RSA1024.name().equals(keyType)) {
            p12Type = P12Type.RSA1024;
            testData = new RSA1024TestData();
        } else if (P12Type.RSA2048.name().equals(keyType)) {
            p12Type = P12Type.RSA2048;
            testData = new RSA2048TestData();
        } else if (P12Type.SM2.name().equals(keyType)) {
            p12Type = P12Type.SM2;
            testData = new SM2TestData();
        } else {
            p12Type = P12Type.SM2;
            testData = new SM2TestData();
        }

        final TestParams testParams = new TestParams(testData);
        testParams.p12Type = p12Type;

        for (int i = 0; i < args.length; i++) {
            command = "-pfxpath=";
            if (args[i].startsWith(command)) {
                testParams.p12File = args[i].substring(command.length()).trim();
                continue;
            }
            command = "-p12Pass=";
            if (args[i].startsWith(command)) {
                testParams.p12Pass = args[i].substring(command.length()).trim();
                continue;
            }
            command = "-base64ServerRandom=";
            if (args[i].startsWith(command)) {
                testParams.base64ServerRandom = args[i].substring(command.length()).trim();
                continue;
            }
            command = "-base64EncryptedRc=";
            if (args[i].startsWith(command)) {
                testParams.base64EncryptedRc = args[i].substring(command.length()).trim();
                continue;
            }
            command = "-base64EncryptedData=";
            if (args[i].startsWith(command)) {
                testParams.base64EncryptedData = args[i].substring(command.length()).trim();
                continue;
            }
            command = "-expected=";
            if (args[i].startsWith(command)) {
                testParams.expected = args[i].substring(command.length()).trim();
                continue;
            }
        }

        return testParams;

    }

    public SIPDecryptor buildSIPDecryptor() throws ConfigurationException {
        SIPDecryptor decryptor = null;
        switch (p12Type) {
        case SM2:
            decryptor = SIPDecryptionBuilder.sm2().config(p12File, p12Pass);
            break;
        case RSA1024:
        case RSA2048:
            decryptor = SIPDecryptionBuilder.rsa().config(p12File, p12Pass);
            break;
        default:
            decryptor = SIPDecryptionBuilder.sm2().config(p12File, p12Pass);
            break;
        }

        return decryptor;

    }

    public String getP12File() {
        return p12File;
    }

    public String getP12Pass() {
        return p12Pass;
    }

    public String getBase64ServerRandom() {
        return base64ServerRandom;
    }

    public String getBase64EncryptedRc() {
        return base64EncryptedRc;
    }

    public String getBase64EncryptedData() {
        return base64EncryptedData;
    }

    public String getExpected() {
        return expected;
    }

    public P12Type getP12Type() {
        return p12Type;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n TestParams [");
        builder.append("\n   p12Type=");
        builder.append(p12Type);
        builder.append("\n   p12File=");
        builder.append(p12File);
        builder.append("\n   p12Pass=");
        builder.append(p12Pass);
        builder.append("\n   base64ServerRandom=");
        builder.append(base64ServerRandom);
        builder.append("\n   base64EncryptedRc=");
        builder.append(base64EncryptedRc);
        builder.append("\n   base64EncryptedData=");
        builder.append(base64EncryptedData);
        builder.append("\n   expected=");
        builder.append(expected);
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        String base64ServerRandom = "";
        for (int i = 0; i < 16; i++)
        {
            base64ServerRandom += (int) Math.floor(Math.random() * 10);
        }
        base64ServerRandom = new String(Base64.encode(base64ServerRandom.getBytes()));
        System.out.println(base64ServerRandom);
    }

}
