package net.fly.order.core.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类. <br>
 * 更多时间操作见父类 {@link org.apache.commons.lang3.time.DateUtils}
 * 或者使用 Joda Time ${@link DateTime}
 * <p>
 * Copyright: Copyright (c) 2019/2/13 20:47
 * <p>
 * Company: 飞越
 * <p>
 *
 * @author fly
 * @version 1.0.0
 **/
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    /**
     * 时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    /**
     * 时间格式 yyyy-MM-dd
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 时间格式 yyyyMMdd
     */
    public static final String YYYYMMDD = "yyyyMMdd";

    public static String format(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    /**
     * 当天的开始时间
     *
     * @return
     */
    public static Date startOfToday() {
        return startOfDay(new Date());
    }

    /**
     * 当天的结束时间（凌晨前1毫秒）
     *
     * @return
     */
    public static Date endOfToday() {
        return endOfDay(new Date());
    }

    /**
     * 当天的开始时间
     *
     * @return
     */
    public static Date startOfDay(Date date) {
        return new DateTime(date).withTimeAtStartOfDay().toDate();
    }

    /**
     * 当天的结束时间（凌晨前1毫秒）
     *
     * @return
     */
    public static Date endOfDay(Date date) {
        return new DateTime(date).withTimeAtStartOfDay().plusDays(1).plusMillis(-1).toDate();
    }

    /**
     * 第二天的开始时间
     *
     * @return
     */
    public static Date startOfNextDay() {
        return startOfNextDay(new Date(), 1);
    }

    /**
     * 第二天的开始时间
     *
     * @return
     */
    public static Date startOfNextDay(Date date) {
        return startOfNextDay(date, 1);
    }

    /**
     * 第N天的开始时间
     *
     * @return
     */
    public static Date startOfNextDay(Date date, int days) {
        return new DateTime(date).withTimeAtStartOfDay().plusDays(days).toDate();
    }

    /**
     * 第N天的结束时间（凌晨前1毫秒）
     *
     * @return
     */
    public static Date endOfNextDay(Date date, int days) {
        return new DateTime(date).withTimeAtStartOfDay().plusDays(days + 1).plusMillis(-1).toDate();
    }

    /**
     * 获取距离当天天数的指定格式的日期
     * @param days
     * @param pattern
     * @return
     */
    public static String getDay(int days, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, days);
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(cal.getTime());
    }

    /**
     * 字符串转换成日期
     * @param strDate
     * @param format
     * @return
     */
    public static Date stringToDate(String strDate,String format){
        //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        //必须捕获异常
        try {
            Date date=simpleDateFormat.parse(strDate);
            return date;
        } catch(Exception px) {
            px.printStackTrace();
        }
        return  null;
    }

}
