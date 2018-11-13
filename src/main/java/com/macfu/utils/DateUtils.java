package com.macfu.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Author: liming
 * @Date: 2018/11/13 16:05
 * @Description: 日期时间常用工具类
 */
public class DateUtils {

    /**
     * 获取当前日期以字符串的形式标识
     *
     * @param dataFormat 日期字符串的显示格式
     * @return String
     */
    public static String getCurrentDateString(String dataFormat) {
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(cal.getTime());
    }

    public static String getDateString(Date date, String dataFormat) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);
            return sdf.format(date);
        } else {
            return null;
        }
    }

    public static String getYYYYMMDD(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return sdf.format(date);
        } else {
            return null;
        }
    }

    public static Date getyyyyMMddDate(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return getDate(sdf.format(date), "yyyyMMdd");
        } else {
            return null;
        }
    }

    public static String getYYYYMM(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            return sdf.format(date);
        } else {
            return null;
        }
    }

    public static Date getDate(String sDate, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        ParsePosition pos = new ParsePosition(0);
        return sdf.parse(sDate, pos);
    }

    public static Date addDays(String startDate, String dateFormat, int days) {
        return addDays(getDate(startDate, dateFormat), days);
    }

    public static Date addDays(Date startDate, int days) {
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(startDate);
        gCal.add(Calendar.DATE, days);

        return gCal.getTime();
    }

    public static Date addWeeks(Date startDate, int weeks) {
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(startDate);
        gCal.add(Calendar.WEEK_OF_YEAR, weeks);

        return gCal.getTime();
    }

    public static Date addMonths(Date startDate, int months) {
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(startDate);
        gCal.add(Calendar.MONTH, months);

        return gCal.getTime();
    }

    public static Date addHours(Date startDate, int hours) {
        GregorianCalendar gCal = new GregorianCalendar();
        gCal.setTime(startDate);
        gCal.add(Calendar.HOUR, hours);

        return gCal.getTime();
    }

    public static Date addHours(String startDate, String dateFormat, int hours) {
        return addHours(getDate(startDate, dateFormat), hours);
    }

    public static String addHours(String startDate, String dateFormat1, int hours, String dateFormat2) {
        return getDateString(addHours(getDate(startDate, dateFormat1), hours), dateFormat2);
    }

    public static boolean isDateBetween(Date d, Date d1, Date d2) {
        return ((d1.before(d) || d1.equals(d)) &&
                (d.before(d2) || d.equals(d2)));
    }

    public static String getCurrentTime() {
        return DateFormat.getDateTimeInstance().format(new Date());
    }

    public static String getCurrentDate() {
        return DateFormat.getDateInstance().format(new Date());
    }

    @SuppressWarnings({"finally"})
    public static String formatDate(Date theDate) {
        Locale locale = Locale.CHINA;
        String dateString = "";
        try {
            Calendar cal = Calendar.getInstance(locale);
            cal.setFirstDayOfWeek(Calendar.TUESDAY);
            cal.setTime((Date) theDate);

            //DateFormat dateFormatter = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.MEDIUM,locale);
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
            dateString = dateFormatter.format(cal.getTime());
            //System.out.println(dateString);
            //System.out.println(cal.get(Calendar.YEAR));
            //System.out.println(cal.get(cal.DAY_OF_WEEK));
        } catch (Exception e) {
            System.out.println("test result:" + e.getMessage());
        } finally {
            return dateString;
        }
    }

    public static int getDateDiff(Date date1, Date date2, int sign) {

        long base = 1;
        switch (sign) {
            case Calendar.YEAR:
                base *= 1000 * 60 * 60 * 24 * 365;
                break;
            case Calendar.DATE:
                base *= 1000 * 60 * 60 * 24;
                break;
            case Calendar.HOUR:
                base *= 1000 * 60 * 60;
                break;
            case Calendar.MINUTE:
                base *= 1000 * 60;
                break;
            case Calendar.SECOND:
                base *= 1000;
                break;
            default:
                break;
        }
        return (int) ((date1.getTime() - date2.getTime()) / base);
    }


    public static String getYesterday(String style, int day) {
        SimpleDateFormat formatter = new SimpleDateFormat(style);

        Date curDate = new Date(System.currentTimeMillis());
        String curDateStr = formatter.format(curDate);
        Date nowDayByStyle;
        Calendar c = Calendar.getInstance();
        try {
            nowDayByStyle = formatter.parse(curDateStr);
            c.setTime(nowDayByStyle);
            c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) - day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter.format(c.getTime());
    }

    /**
     * 转换当前时间
     *
     * @param date
     * @return
     */
    public static String getCurrentTime(long date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String str = format.format(new Date(date));
        return str;
    }


    public static int getAge(Date birthDate) {

        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDate);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayNow < dayBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }

        return age;
    }

    /**
     * 根据两个时间戳返回他们之间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getDay(long date1, long date2) {
        date1 = getYYYYMMDD(date1);
        date2 = getYYYYMMDD(date2);

        long time1 = date1 - date2;
        long time2 = 1000 * 60 * 60 * 24;
        long days = time1 / time2;
        if (time1 > 0) {
            if (time1 % time2 != 0) {
                days = days + 1;
            }
        } else {
            if (time1 % time2 != 0) {
                days = days - 1;
            }
        }
        return days;
    }

    /**
     * 根据两个时间戳返回他们之间的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long getGapDay(long date1, long date2) {
        long time1 = date1 - date2;
        long time2 = 1000 * 60 * 60 * 24;
        long days = time1 / time2;
        if (time1 > 0) {
            if (time1 % time2 != 0) {
                days = days + 1;
            }
        } else {
            if (time1 % time2 != 0) {
                days = days - 1;
            }
        }
        return days;
    }


    public static long getYYYYMMDD(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date);
        String date1 = sdf.format(calendar.getTime());
        Date date11 = null;
        long longDate = 0L;
        try {
            date11 = sdf.parse(date1);
            longDate = date11.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return longDate;
    }

    public static boolean jisuan(String date1, String date2) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d HH:mm:ss");
        Date start = sdf.parse(date1);
        Date end = sdf.parse(date2);
        long cha = end.getTime() - start.getTime();
        double result = cha * 1.0 / (1000 * 60 * 60);
        if (result <= 24) {
            //没有超过
            return true;
        } else {
            //已超过;
            return false;
        }
    }

    public static String getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.setTime(date);
        //设置月份
        cal.set(Calendar.MONTH, date.getMonth() - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    public static String getLastDayOfCurrentMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.setTime(date);
        //设置月份
        cal.set(Calendar.MONTH, date.getMonth());
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    public static long daysBetween(Date one, Date two) {
        long difference = (one.getTime() - two.getTime()) / 86400000;
        return Math.abs(difference);
    }


    public static Date localDateTransDate(LocalDate date) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = date.atStartOfDay(zoneId);
        return Date.from(zdt.toInstant());
    }

    public static LocalDateTime dateTransLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    public static Date checkDate(Date now) {
        int day = now.getDate();
        if (day < 11) {
            return DateUtils.addDays(now, -15);
        }
        return now;
    }

//    /**
//     * 获取 n 个工作日前的时间
//     *
//     * @param n
//     */
//    public static long getNDayAgoTime(int n) {
//        int oneDayTimeMillis = 86400000;
//        long currentTimeMillis = System.currentTimeMillis();
//        long targetTimeMillis = currentTimeMillis;
//        int count = 0;
//        while (count < n) {
//            targetTimeMillis = targetTimeMillis - oneDayTimeMillis;
//            String dataToString = getYYYYMMDD(new Date(targetTimeMillis));
//            Map<String, String> params = Maps.newHashMap();
//            params.put("date", dataToString);
//            String str = HttpClientUtil.httpGet("http://api.goseek.cn/Tools/holiday", null, params);
//            System.out.println(str);
//            if (null != str && !str.isEmpty()) {
//                System.out.println("调用节假日接口成功");
//                JSONObject result = JSONObject.parseObject(str);
//                if (result.getString("data").equals("0")) {
//                    count++;
//                }
//            } else {
//                throw new CustomException("调用节假日接口失败");
//            }
//        }
//        return targetTimeMillis;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getCurrentTime(1529572866000L));
//    }

}
