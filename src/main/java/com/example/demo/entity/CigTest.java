package com.example.demo.entity;

import lombok.Data;

import java.util.Random;

/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName CigTest
 * @date 2019/3/26  17:09
 */
@Data
public class CigTest {

    private String ChannelName;
    private String DidType;
    private String Mode;
    private String Teller;
    private String Pid;
    private String SubAccNo;
    private String Term;
    private String ChannelId;
    private String Did;

    public static void main(String[] args) {
/*        String originalFilename = "ww.ww.png";
        String gg ="1553667922814png";
        String hh ="1553667959645png";
        Random random = new Random();
       for ( int i=1 ; i < 10 ; i++ ) {
           System.out.println(random.nextInt(1000)+System.currentTimeMillis() +originalFilename.substring(originalFilename.lastIndexOf(".")+1,originalFilename.length()));
       }*/
        StringBuilder sb = new StringBuilder("强人！！！");
        sb.append("焦哥");
         sb.insert(0,"我是中國人啊。");
         sb.insert(0,"你是哪里人？");
        System.out.println(sb);


    }
}
