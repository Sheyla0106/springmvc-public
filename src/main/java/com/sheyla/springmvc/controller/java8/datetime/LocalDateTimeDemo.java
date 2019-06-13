package com.sheyla.springmvc.controller.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/14 0:24
 * @Modified By：
 * 在旧版的 Java 中，日期时间 API 存在诸多问题，其中有：
 * <p>
 * 非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
 * <p>
 * 设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
 * <p>
 * 时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
 * <p>
 * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
 * <p>
 * Local(本地) − 简化了日期时间的处理，没有时区的问题。
 * <p>
 * Zoned(时区) − 通过制定的时区处理日期时间。
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        //日期格式化
        String str = "1986-04-08 12:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        System.out.println(dateTime);
        // 获取当前的日期时间
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);

        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);

        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);

        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);

        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);
        System.out.println("==========================================================");
        // 时间互转
        System.out.println(LocalDateTimeUtil.str2LocalDateTime("2018-04-05 12:21:21"));
        System.out.println(LocalDateTimeUtil.localDateTime2Str(LocalDateTime.now()));

        System.out.println(LocalDateTimeUtil.getTodayByFormat("yyyy-MM-dd"));
        System.out.println(LocalDateTimeUtil.date2LocalDateTime(new Date()));
        System.out.println(LocalDateTimeUtil.localDateTime2Date(LocalDateTime.now()));
    }

}
