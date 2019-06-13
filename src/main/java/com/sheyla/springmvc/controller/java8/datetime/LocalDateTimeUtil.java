package com.sheyla.springmvc.controller.java8.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author: sheyla
 * @Description:
 * @Date:Create：in 2019/6/14 0:24
 * @Modified By：
 * Instant：表示时刻，不直接对应年月日信息，需要通过时区转换
 * <p>
 * LocalDateTime: 表示与时区无关的日期和时间信息，不直接对应时刻，需要通过时区转换
 * <p>
 * LocalDate：表示与时区无关的日期，与LocalDateTime相比，只有日期信息，没有时间信息
 * <p>
 * LocalTime：表示与时区无关的时间，与LocalDateTime相比，只有时间信息，没有日期信息
 * <p>
 * ZonedDateTime： 表示特定时区的日期和时间
 * <p>
 * ZoneId/ZoneOffset：表示时区
 */
public class LocalDateTimeUtil {
    public static final String YYYY_MM_DD_24HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static LocalDateTime str2LocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);
    }

    public static String localDateTime2Str(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return localDateTime.format(formatter);

    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zoneId);
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        return Date.from(zdt.toInstant());

    }


    public static String getTodayByFormat(String timeFormat) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(timeFormat));
    }
}
