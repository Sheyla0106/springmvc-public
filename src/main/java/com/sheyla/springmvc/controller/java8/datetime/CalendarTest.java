package com.sheyla.springmvc.controller.java8.datetime;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 * @Author: sheyla
 * @Date:Create：in 2019/10/15 21:31
 * @Modified By：日历测试类
 * @Description:
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        System.out.println(calendar.getTime());

        //获取明天
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.plusDays(1);
        System.out.println(tomorrow);

    }
}
