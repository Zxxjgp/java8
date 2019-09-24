package com.example.demo.demo.char

import java.text.DateFormat
import java.util.*


/**
 * @ClassName DateTest
 * @author jiaoguanping
 * @date  2019/8/12  9:34
 * @version 1.0.0
 */
fun main(args: Array<String>) {
    val date = Date()
    println(System.currentTimeMillis())
    val df2 = DateFormat.getDateTimeInstance()//可以精确到时分秒
    System.out.println(df2.format(date))
}