package com.example.demo.test.data;

/**
 * @Author qazhang
 * @Description 测试数据接口
 * @CodeReviewer liujiancheng
 *
 */
public interface SIPTestData {
    String pfxFile();

    String pasword();

    String base64ServerRandom();

    String base64EncryptedRc();

    String base64EncryptedData();

    String expected();

}
