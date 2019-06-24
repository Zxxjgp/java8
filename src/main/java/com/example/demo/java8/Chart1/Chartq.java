package com.example.demo.java8.Chart1;

import com.baomidou.mybatisplus.core.conditions.ISqlSegment;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.example.demo.enums.LoanTradeStatus;
import com.example.demo.utils.EnumUtil;
import com.sun.org.apache.xpath.internal.functions.FuncStringLength;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.plugin2.message.GetAppletMessage;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;


/**
 * @author jiaoguanping
 * @version 1.0.0
 * @ClassName Chartq
 * @date 2019/6/3  0:00
 */
public class Chartq {
    public static void main(String[] args) {
/*        List<Apple> list = Arrays.asList(new Apple(10,"red"),
                new Apple(100,"green")
                , new Apple(200,"red"));

        filterApples(list, Chartq::isGreenApple);
        Collection<Apple> filter = filter(list, (Apple a) -> a.getWeight() > 150);
        list.sort(new Comparator<Apple>(){
            @Override
            public int compare(Apple o1, Apple o2){
                if (o1.getColor().equals(o2.getColor())){
                    return 1;
                }
                return 2;
            }
        });
        list.stream()
                .filter((Apple t) -> t.getWeight() > 1000 || t.getColor().equals("red"))
                .collect(Collectors.toList());*/
     /*   LoanTradeStatus byCode = EnumUtil.getByCode("2", LoanTradeStatus.class);
        System.out.println(byCode.getMsg());*/

/*     String str = "123****5561";
        String front = str.substring(0,3);
        String later = str.substring(str.length()-4);
        System.out.println(front +"qqqqqqqq" + later);
        System.out.println(str);*/

        String str = null;
        System.out.println(str.isEmpty());
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Apple{
        private int weight = 0;
        private String color = "";
        @Override
        public String toString() {
            return "Apple{" +
                    "color='" + color + '\'' +
                    ", weight=" + weight +
                    '}';
        }
    }

    //predicate代表所有符合条件的苹果
    public static List<Apple> filterApples(List<Apple> list, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list ) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;

    }

    public boolean isGreenApple(Apple apple){
        String in =  "qwq";
        System.out.println(this.getClass());
        return "green".equals(apple.getColor());
    }
    public static String getOrderIdByUUId() {
        int first = new Random(10).nextInt(8) + 1;
        System.out.println(first);
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return first + String.format("%015d", hashCodeV);
    }

    public static String getGUID() {
        StringBuilder uid = new StringBuilder();
        //产生16位的强随机数
        Random rd = new SecureRandom();
        for (int i = 0; i < 16; i++) {
            //产生0-2的3位随机数
            int type = rd.nextInt(3);
            switch (type){
                case 0:
                    //0-9的随机数
                    uid.append(rd.nextInt(10));
                    break;
                case 1:
                    //ASCII在65-90之间为大写,获取大写随机
                    uid.append((char)(rd.nextInt(25)+65));
                    break;
                case 2:
                    //ASCII在97-122之间为小写，获取小写随机
                    uid.append((char)(rd.nextInt(25)+97));
                    break;
                default:
                    break;
            }
        }
        return uid.toString();
    }

    public static String getAppId(String platformName) {
        // 创建随机对象
        Random rd = new Random();
        //保存随机数
        String n = "";
        // 取得随机数
        int rdGet;
        do {
            if (rd.nextInt() % 2 == 1) {
                // 产生48到57的随机数(0-9的键位值)
                rdGet = Math.abs(rd.nextInt()) % 10 + 48;
            }else{
                // 产生97到122的随机数(a-z的键位值)
                rdGet = Math.abs(rd.nextInt()) % 26 + 97;
            }
            //int转换char
            char num1 = (char) rdGet;
            String dd = Character.toString(num1);
            n += dd;
            // 设定长度，此处假定长度小于8
        } while (n.length() < 8);
        return sort(n.toUpperCase() + platformName)+(((Math.random() * 9 + 1) * 100000) + "").substring(0, 6);
    }

    public static String sort(String str){
        //利用toCharArray可将字符串转换为char型的数组


        char[] s1 = str.toCharArray();
        for(int i=0;i<s1.length;i++){
            for(int j=0;j<i;j++){
                if(s1[i]<s1[j]){
                    char temp = s1[i];
                    s1[i] = s1[j];
                    s1[j] = temp;
                }
            }
        }
        //再次将字符数组转换为字符串，也可以直接利用String.valueOf(s1)转换
        String st = new String(s1);
        return st;
    }
}
