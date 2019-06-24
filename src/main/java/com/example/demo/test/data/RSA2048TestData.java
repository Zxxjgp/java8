package com.example.demo.test.data;

/**
 * @Author qazhang
 * @Description RSA1024测试数据
 * @CodeReviewer liujiancheng
 */
public final class RSA2048TestData implements SIPTestData {

    final String base64ServerRandom = "MTIzNDU2Nzg5MDk4NzY1NA==";
    final String base64EncryptedRc = "MI+aHYKjBGPmIPEh3o97WgVel1MX+CMAlNG8bouNMWLz2jKwqHsr8eo3TangYjEPgMfS+fy10lMYLEMARlJXDCnnUcQBWUQZWBkOjVWZy82vslxlmK4759cvwIGZEw/hyAPwcJTxQXK8VE0bq5wJfxSDDXVsTk3w9e7y9/SRP/x0MviL41VgF8zBjeekIz0EcZtc9xqt+dVzO+NQYvo4aFhUyuNG06sUxGEQPlMHnAC3e6bTJ1Us5afTy0Uvt9ntiaBVYSB7FbyCD1Y8pO5z2aAAaQfjFEApiXwiJQklYSWbf5gmHOUGsiGZP06K7GDeGI4BFYF4uf4lxSY5gyoTiw==";
    final String base64EncryptedData = "mRGInkWT+Wc= ";
    final String rsa2048File = "TestData/timestamp_rsa2048_cfca1234.pfx";
    final String rsa2048Pass = "cfca1234";
    final String expected = "qqq111";

    @Override
    public String pfxFile() {
        return rsa2048File;
    }

    @Override
    public String pasword() {
        return rsa2048Pass;
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
