package com.vinci.code.base;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LocalDateTimeDemo {


    /**
     * 文中都使用的时区都是东8区，也就是北京时间。
     * 这是为了防止服务器设置时区错误时导致时间不对，如果您是其他时区，请自行修改
     * @param args
     */
    public static void main(String[] args) {


    }

    //1.LocalDateTime获取毫秒数
    public static void getMilliSecond() {
        //获取秒数
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        //获取毫秒数
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(second);
        System.out.println(milliSecond);
    }

    //2.LocalDateTime与String互转
    public static void localDateTime2String() {
        //时间转字符串格式化
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        String dateTimeStr1 = LocalDateTime.now(ZoneOffset.of("+8")).format(formatter);

        //字符串转时间
        String dateTimeStr = "2018-07-28 14:11:15";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, df);
    }

    //3.Date与LocalDateTime互转

    //将java.util.Date 转换为java8 的java.time.LocalDateTime,默认时区为东8区
    public static LocalDateTime dateConvertToLocalDateTime(Date date) {
        return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
    }

    //将java8 的 java.time.LocalDateTime 转换为 java.util.Date，默认时区为东8区
    public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
    }


    /**
     * 测试转换是否正确
     */
    @Test
    public void testDateConvertToLocalDateTime() {
        Date date = new Date();//DateUtils.parseDate("2018-08-01 21:22:22", DateUtils.DATE_YMDHMS);
        LocalDateTime localDateTime = dateConvertToLocalDateTime(date);
        Long localDateTimeSecond = localDateTime.toEpochSecond(ZoneOffset.of("+8"));
        Long dateSecond = date.toInstant().atOffset(ZoneOffset.of("+8")).toEpochSecond();
        Assert.assertTrue(dateSecond.equals(localDateTimeSecond));
    }

}
