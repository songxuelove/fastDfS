package com.example.dfs.fastdfstest.untill;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * <p><strong>日期格式化工具</strong></p>
 * <p>
 *     将JSON string转换为Object <br>
 *     将Null转换为"" <br>
 * </p>
 * <li>
 * <p>
 *     <strong>示例1: 格式化日期Date</strong> <br>
 *     DateFormatUtils.formatDate(new Date()); <br>
 *     返回结果: 2021-8-11 16:06:31 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例2: 格式化日期long</strong> <br>
 *     DateFormatUtils.formatDate(System.currentTimeMillis()); <br>
 *     返回结果: 2021-8-11 16:06:31 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例3: 自定义格式化Date</strong> <br>
 *     DateFormatUtils.formatDate("HH:mm", new Date()); <br>
 *     返回结果: 16:06 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例4: 自定义格式化long</strong> <br>
 *     DateFormatUtils.formatDate("HH:mm", System.currentTimeMillis()); <br>
 *     返回结果: 16:06 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例5: 将日期字符串 转换为 Date</strong> <br>
 *     DateFormatUtils.formatString(stringDate); <br>
 *     返回结果: Date对象 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例6: 将日期字符串 转换为 Date</strong> <br>
 *     DateFormatUtils.formatString("2021-9-17 16:25:00", "yyyy-MM-dd HH:mm:ss"); <br>
 *     返回结果: Date对象 <br>
 * </p>
 * </li>
 * @author wzk
 * @see SimpleDateFormat
 * @see Map
 * @see Date
 * @since 15:25 2021/8/13
 **/
public class DateFormatUtils {

    private DateFormatUtils() {}

    private static final String FORMAT_STRING = "yyyy-MM-dd HH:mm:ss";

    /**
     * <p>
     *     <strong>示例1: 格式化日期Date</strong> <br>
     *     DateFormatUtils.formatDate(new Date()); <br>
     *     返回结果: 2021-8-11 16:06:31 <br>
     * </p>
     * @param date 日期
     * @return String 格式化结果
     * @author wzk
     * @since 16:06 2021/8/11
     **/
    public static String formatDate(Date date) {
        if (CheckParamUtils.isNullOrEmpty(date)) {
            return "";
        }
        return new SimpleDateFormat(FORMAT_STRING).format(date);
    }
    
    /**
     * <p>
     *     <strong>示例2: 格式化日期long</strong> <br>
     *     DateFormatUtils.formatDate(System.currentTimeMillis()); <br>
     *     返回结果: 2021-8-11 16:06:31 <br>
     * </p>
     * @param date 日期
     * @return String 格式化结果
     * @author wzk
     * @since 16:06 2021/8/11
    **/
    public static String formatDate(Long date) {
        if (CheckParamUtils.isNullOrEmpty(date)) {
            return "";
        }
        return new SimpleDateFormat(FORMAT_STRING).format(date);
    }

    /**
     * <p>
     *     <strong>示例3: 自定义格式化Date</strong> <br>
     *     DateFormatUtils.formatDate("HH:mm", new Date()); <br>
     *     返回结果: 16:06 <br>
     * </p>
     * @param date 日期
     * @return String 格式化结果
     * @author wzk
     * @since 16:06 2021/8/11
     **/
    public static String formatDate(String formatString, Date date) {
        if (CheckParamUtils.isNullOrEmpty(date)) {
            return "";
        }
        return new SimpleDateFormat(formatString).format(date);
    }

    /**
     * <p>
     *     <strong>示例4: 自定义格式化long</strong> <br>
     *     DateFormatUtils.formatDate("HH:mm", System.currentTimeMillis()); <br>
     *     返回结果: 16:06 <br>
     * </p>
     * @param date 日期
     * @return String 格式化结果
     * @author wzk
     * @since 16:06 2021/8/11
    **/
    public static String formatDate(String formatString, Long date) {
        if (CheckParamUtils.isNullOrEmpty(date)) {
            return "";
        }
        return new SimpleDateFormat(formatString).format(date);
    }

    /**
     * <p>
     *     <strong>示例5: 将日期字符串 转换为 Date</strong> <br>
     *     DateFormatUtils.formatString(stringDate); <br>
     *     返回结果: Date对象 <br>
     * </p>
     * @param date 日期字符串
     * @return String 格式化结果
     * @author wzk
     * @since 16:06 2021/9/17
     **/
    public static Date formatString(String date) {
        try {
            return new SimpleDateFormat(FORMAT_STRING).parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }

    /**
     * <p>
     *     <strong>示例6: 将日期字符串 转换为 Date</strong> <br>
     *     DateFormatUtils.formatString("2021-9-17 16:25:00", "yyyy-MM-dd HH:mm:ss"); <br>
     *     返回结果: Date对象 <br>
     * </p>
     * @param date 日期字符串
     * @return String 格式化结果
     * @author wzk
     * @since 16:06 2021/9/17
     **/
    public static Date formatString(String date, String format) {
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return new Date();
        }
    }
}
