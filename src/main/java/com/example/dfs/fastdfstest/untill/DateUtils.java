package com.example.dfs.fastdfstest.untill;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * <p><strong>时间工具类</strong></p>
 * <p>
 *     获取时间: 昨天, 今天, 明天。<br>
 * </p>
 * <li>
 * <p>
 *     <strong>示例1: 根据出生日期获取年龄 </strong> <br>
 *     DateUtils.getAge(出生日期); <br>
 *     返回结果: 24 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例2: 当前日期前后的日期 num大于0则日期往后 小于0则日期往前</strong> <br>
 *     DateUtils.getDay(num); <br>
 *     返回结果: 2021-8-11 16:06:31 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例3: 指定日期前后的日期 num大于0则日期往后 小于0则日期往前</strong> <br>
 *     DateUtils.getDay(date, num);<br>
 *     返回结果: 2021-8-11 16:06:31 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例4: 指定日期前后的日期</strong> <br>
 *     DateUtils.getDay(day, minutes);<br>
 *     返回结果: 2021-8-11 16:06:31 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例5: 指定日期前后的日期</strong> <br>
 *     DateUtils.getDay(date, day, minutes);<br>
 *     返回结果: 2021-8-11 16:06:31 <br>
 * </p>
 * </li>
 * <li>
 * <p>
 *     <strong>示例6: 计算两个时间间隔月数</strong> <br>
 *     DateUtils.getMonths(startTime, endTime);<br>
 *     返回结果: 24 <br>
 * </p>
 * </li>
 * @author xp & wzk
 * @see Calendar
 * @see Date
 * @since 16:44 2021/8/6
 **/
public class DateUtils {

    private DateUtils() {}

    /**
     * <p>
     *     <strong>示例2: 当前日期前后的日期</strong> <br>
     *     DateUtils.getDay(day); <br>
     *     返回结果: 2021-8-11 16:06:31 <br>
     * </p>
     * @param day 大于0则日期往后 小于0则日期往前
     * @return date
     * @author wzk
     * @since 15:11 2021/9/17
     **/
    public static Date getDay(int day) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // num 负数 日期往前、 num 正数 日期往后
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static int getEveryMonth(Date day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        int month = calendar.get(Calendar.MONTH);
        return month;

    }

    /**
     * @author : ygy
     * @date    : 2021/10/15 13:13
     * @description 获取某天的凌晨时刻
     */
    public static Date getDayBreak(int day) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        // num 负数 日期往前、 num 正数 日期往后
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

//    public static void main(String[] args) {
//        System.out.println(getDayBreak(-1));
//    }

    /**
     * <p>
     *     <strong>示例3: 指定日期前后的日期</strong> <br>
     *     DateUtils.getDay(date, day);<br>
     *     返回结果: 2021-8-11 16:06:31 <br>
     * </p>
     * @param day 大于0则日期往后 小于0则日期往前
     * @return date
     * @author wzk
     * @since 15:13 2021/9/17
     **/
    public static Date getDay(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // num 负数 日期往前、 num 正数 日期往后
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    /**
     * <p>
     *     <strong>示例3: 有最小年月和最大年月，得到中间的年月list</strong> <br>
     *     DateUtils.getMonthTimeList(start, end);<br>
     *     返回结果: [2021-08, 2021-09, 2021-10, 2021-11, 2021-12]<br>
     * </p>
     * @param start,end 传入最小时间和最大时间
     * @return list
     * @author songxue
     * @since 15:13 2021/12/16
     **/
    //public static List<String> getMonthTimeList(Date start ,Date end) {
    //    Calendar calStart = Calendar.getInstance();
    //    Calendar calEnd = Calendar.getInstance();
    //    // 格式化起始日期 和结束日期
    //    calStart.setTime(start);
    //    calEnd.setTime(end);
    //    // 返回的日期集合容器
    //    List<String> dateList = new ArrayList<>();
    //    // 将第一个月添加进去
    //    dateList.add(DateFormatUtils.formatDate("yyyy-MM",calStart.getTime()));
    //    while (calEnd.getTime().after(calStart.getTime()))  {
    //        // 根据日历的规则，每次加一个月
    //        calStart.add(Calendar.MONTH,1);
    //        if (calStart.getTime().after(calEnd.getTime())){
    //            // 如果最小月份等于最大月份，则跳出
    //            continue;
    //        }else {
    //            dateList.add(DateFormatUtils.formatDate("yyyy-MM",calStart.getTime()));
    //        }
    //    }
    //    return dateList;
    //}

    /**
     * <p>
     *     <strong>示例4: 指定日期前后的日期</strong> <br>
     *     DateUtils.getDay(day, minutes);<br>
     *     返回结果: 2021-8-11 16:06:31 <br>
     * </p>
     * @param day 大于0则日期往后 小于0则日期往前
     * @param minutes 大于0则日期往后 小于0则日期往前
     * @return date
     * @author wzk
     * @since 15:18 2021/9/17
     **/
    public static Date getDay(int day, int minutes) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // num 负数 日期往前、 num 正数 日期往后
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    /**
     * <p>
     *     <strong>示例5: 指定日期前后的日期</strong> <br>
     *     DateUtils.getDay(date, day, minutes);<br>
     *     返回结果: 2021-8-11 16:06:31 <br>
     * </p>
     * @param day 大于0则日期往后 小于0则日期往前
     * @param minutes 大于0则日期往后 小于0则日期往前
     * @return date
     * @author wzk
     * @since 15:18 2021/9/17
     **/
    public static Date getDay(Date date, int day, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // num 负数 日期往前、 num 正数 日期往后
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }


    public static void getDay(Date date) {
    }
}

