package com.hucs.top.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Time: 18-4-26 : 下午14:01
 */
@Slf4j
public class DateUtil extends org.apache.commons.lang3.time.DateUtils {

    private static final String TIMEZONE_FORMAT = "%+03d";

    public static final FastDateFormat FORMAT_YYYYMMDDHHMMSS = FastDateFormat.getInstance("yyyyMMddHHmmss");

    public static final FastDateFormat FORMAT_MMDDHHMMSS = FastDateFormat.getInstance("MMddHHmmss");

    public static final FastDateFormat FORMAT_HH_MM = FastDateFormat.getInstance("HH:mm");

    public static final FastDateFormat FORMAT_YMDHMS = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");

    public static final FastDateFormat FORMAT_YMDHM = FastDateFormat.getInstance("yyyy-MM-dd HH:mm");

    public static final FastDateFormat FORMAT_YYYYMMDD = FastDateFormat.getInstance("yyyyMMdd");

    public static final FastDateFormat FORMAT_YYYYMM = FastDateFormat.getInstance("yyyy-MM");

    public static final FastDateFormat FORMAT_YYYYDMMD = FastDateFormat.getInstance("yyyy年MM月");

    public static final FastDateFormat FORMAT_YYYYDMMD_ = FastDateFormat.getInstance("yyyy年MM月dd日");

    public static final FastDateFormat FORMAT_YYYYMMA = FastDateFormat.getInstance("yyyyMM");

    public static final FastDateFormat FORMAT_YYYY_MM_DD = FastDateFormat.getInstance("yyyy-MM-dd");

    public static final FastDateFormat FORMAT_MM_DD = FastDateFormat.getInstance("MM-dd");

    public static final FastDateFormat FORMAT_YYYY = FastDateFormat.getInstance("yyyy");

    public static final FastDateFormat FORMAT_RFC822 = FastDateFormat.getInstance("MMM dd yyyy h:mm:ss:SSSa", Locale.ENGLISH);

    public static final FastDateFormat FORMAT_YYYY_MM_DDTHH_MM_SSZ = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss'Z'");
    public static final FastDateFormat FORMAT_YYYYMMDDTHHMMSSZ = FastDateFormat.getInstance("yyyyMMdd'T'HHmmss'Z'");

    public static final DateTimeFormatter PARSER_YYYYMMDDHHMMSS = DateTimeFormat.forPattern("yyyyMMddHHmmss").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_YYYYMMDDHHMMSSZ = DateTimeFormat.forPattern("yyyyMMddHHmmssZ").withZone(DateTimeZone.forID("Asia/Shanghai"));

    public static final DateTimeFormatter PARSER_YYYY_MM_DDTHH_MM_SS_000_Z = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'").withZone(DateTimeZone.forID("Asia/Shanghai"));

    public static final DateTimeFormatter PARSER_YYYY_MM_DDTHH_MM_SSZ = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_YYYY_MM_DDTHH_MM_SS = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_YMDHMS = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_YMDHM = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_YYYYMMDD = DateTimeFormat.forPattern("yyyyMMdd").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_YYYYMMDDZ = DateTimeFormat.forPattern("yyyyMMddZ").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_YYYYMM = DateTimeFormat.forPattern("yyyyMM").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_YYYY_MM = DateTimeFormat.forPattern("yyyy-MM").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_YYYY_MM_DD = DateTimeFormat.forPattern("yyyy-MM-dd").withZone(DateTimeZone.forID("Asia/Shanghai"));
    public static final DateTimeFormatter PARSER_HH_MM = DateTimeFormat.forPattern("HH:mm").withZone(DateTimeZone.forID("Asia/Shanghai"));


    /**
     * 输出yyyyMMddHHmmss格式的日期字符串
     */
    public static String formatYYYYMMDDHHMMSS(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYYMMDDHHMMSS.format(date);
    }

    /**
     * 输出MMddHHmmss格式的日期字符串
     */
    public static String formatMMDDHHMMSS(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_MMDDHHMMSS.format(date);
    }

    /**
     * 输出HH:mm格式的日期字符串
     */
    public static String formatHH_MM(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_HH_MM.format(date);
    }

    /**
     * @Description: 输出 2021年07月28日格式
     **/
    public static String formatHH_MMDD(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYYDMMD_.format(date);
    }

    /**
     * 输出格式为yyyy-MM-dd HH:mm:ss的日期字符串
     */
    public static String formatYMDHMS(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YMDHMS.format(date);
    }


    public static String formatYMDHM(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YMDHM.format(date);
    }

    /**
     * 输出格式为yyyy-MM-dd'T'HH:mm:ssZ的日期字符串
     */
    public static String formatYMDTHMSZ(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYY_MM_DDTHH_MM_SSZ.format(date);
    }

    /**
     * 输出格式为yyyyMMdd'T'HHmmssZ的日期字符串
     */
    public static String formatYYYYMMDDTHHMMSSZ(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYYMMDDTHHMMSSZ.format(date);
    }

    /**
     * 输出格式为yyyyMMdd的日期字符串
     */
    public static String formatYYYYMMDD(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYYMMDD.format(date);
    }

    /**
     * 输出格式为MM-dd的日期字符串
     */
    public static String formatMMDD(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_MM_DD.format(date);
    }

    public static String formatYYYYMM(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYYMM.format(date);
    }

    public static String formatYYYYDMMD(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYYDMMD.format(date);
    }

    public static String formatYYYYMMA(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYYMMA.format(date);
    }


    /**
     * 输出格式为yyyy的日期字符串
     */
    public static String formatYYYY(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYY.format(date);
    }

    /**
     * 输出格式为yyyy-MM-dd的日期字符串
     */
    public static String formatYYYY_MM_DD(Date date) {
        if (date == null) {
            return "";
        }
        return FORMAT_YYYY_MM_DD.format(date);
    }

    /**
     * 格式为yyyy-MM-dd的日期字符串转换成日期类型
     */
    public static Date parseYYYY_MM_DD(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYY_MM_DD.parseDateTime(dateStr);
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyyMMddHHMMSS的日期字符串
     */
    public static Date parseYYYYMMDDHHMMSS(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYYMMDDHHMMSS.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 比较两个日期（年月日）
     * -1, 0, or 1 as this is numerically less than, equal to, or greater than val.
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int dateCompare(Date date1, Date date2) {
        if (date1.before(date2)) return -1;
        return date1.after(date2) ? 1 : 0;
    }

    public static boolean compareALessOrEqualB(Date beginDate, Date endDate) {
        int i = dateCompare(beginDate, endDate);
        return i != 1;
    }

    public static boolean compareALessB(Date beginDate, Date endDate) {
        int i = dateCompare(beginDate, endDate);
        return i == -1;
    }

    public static boolean compareAGrateB(Date beginDate, Date endDate) {
        int i = dateCompare(beginDate, endDate);
        return i == 1;
    }

    public static boolean compareAEqualB(Date beginDate, Date endDate) {
        int i = dateCompare(beginDate, endDate);
        return i == 0;
    }

    public static boolean compareAGrateOrEqualB(Date beginDate, Date endDate) {
        int i = dateCompare(beginDate, endDate);
        return i == 1 || i == 0;
    }

    /**
     * 解析格式为yyyyMMddHHMMSS的日期字符串,支持时区
     *
     * @param timezone the offset in hours from UTC, from -23 to +23
     */
    public static Date parseYYYYMMDDHHMMSSZ(String dateString, int timezone) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYYMMDDHHMMSSZ.parseDateTime(dateString + String.format(TIMEZONE_FORMAT, timezone));
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyy-MM-dd HH:mm:ss的日期字符串
     */
    public static Date parseYMDHMS(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YMDHMS.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyy-MM-dd的日期字符串
     */
    public static Date parseYMD(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYY_MM_DD.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyy-MM-dd HH:mm的日期字符串
     */
    public static Date parseYMDHM(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YMDHM.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyyMMdd的日期字符串
     */
    public static Date parseYYYYMMDD(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYYMMDD.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyyMMdd的日期字符串,支持时区
     *
     * @param timezone the offset in hours from UTC, from -23 to +23
     */
    public static Date parseYYYYMMDD(String dateString, int timezone) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYYMMDDZ.parseDateTime(dateString + String.format(TIMEZONE_FORMAT, timezone));
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyyMM的日期字符串
     */
    public static Date parseYYYYMM(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYYMM.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyy-MM的日期字符串
     */
    public static Date parseYYYY_MM(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYY_MM.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 解析格式为 HH:mm 的日期字符串
     */
    public static Date parseHHmm(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_HH_MM.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyy-MM-dd'T'HH:mm:ssXXX的日期字符串
     */
    public static Date parseYYYY_MM_DDTHH_MM_SSZ(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYY_MM_DDTHH_MM_SSZ.parseDateTime(dateString);
        return dateTime.toDate();
    }

    public static Date parseYYYY_MM_DDTHH_MM_SS_000_Z(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYY_MM_DDTHH_MM_SS_000_Z.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 解析格式为yyyy-MM-dd'T'HH:mm:ss的日期字符串
     */
    public static Date parserYYYY_MM_DDTHH_MM_SS(String dateString) {
        if (StringUtils.isEmpty(dateString)) {
            throw new RuntimeException("date param can not bu null");
        }
        DateTime dateTime = PARSER_YYYY_MM_DDTHH_MM_SS.parseDateTime(dateString);
        return dateTime.toDate();
    }

    public static Date addHour(Date date, int hour) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hour).toDate();
    }

    public static Date addMinutes(Date date, int minutes) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMinutes(minutes).toDate();
    }

    public static Date addDay(Date date, int day) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusDays(day).toDate();
    }

    public static Date addMonth(Date date, int month) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusMonths(month).toDate();
    }

    public static Date addDay(String dateStr, int day) {
        DateTime dateTime = new DateTime(parseYYYYMMDD(dateStr));
        return dateTime.plusDays(day).toDate();
    }

    public static Date getYMDHMS(String dateString) {
        DateTime dateTime = PARSER_YMDHMS.parseDateTime(dateString);
        return dateTime.toDate();
    }

    /**
     * 获取用户友好的间隔时间，某时间距当前时间的间隔
     *
     * @param dateStr, yyyyMMddHHmmss 格式表示的日期
     */
    public static String getHumanizedInterval(String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return "";
        }
        Calendar nowCalendar = Calendar.getInstance();
        Calendar baseCalendar = Calendar.getInstance();
        baseCalendar.setTime(DateUtil.parseYYYYMMDDHHMMSS(dateStr));
        long seconds = Math.abs(nowCalendar.getTimeInMillis() - baseCalendar.getTimeInMillis()) / 1000;
        long minutes = seconds / 60;
        long days = minutes / (60 * 24);
        long month = days / 30;
        if (days >= 365) {
            return "很久前";
        } else if (days >= 30) {
            return month + "月前";
        } else if (days >= 1) {
            return days + "天前";
        } else if (minutes >= 60) {
            return (minutes / 60) + "小时前";
        } else if (minutes > 0) {
            return minutes + "分钟前";
        } else {
            return "刚刚";
        }
    }


    public static Date getTodayBeginTime() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today.getTime();
    }

    /**
     * 获取当天结束时间
     *
     * @return 当天结束时间
     */
    public static Date getTodayEndTime() {
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 59);
        today.set(Calendar.SECOND, 59);
        today.set(Calendar.MILLISECOND, 999);
        return today.getTime();
    }

    /**
     * 获取当天+amount日的开始时间
     *
     * @return 当天结束时间
     */
    public static Date getDayBeginTime(int amount) {
        Calendar today = Calendar.getInstance();
        today.add(Calendar.DATE, amount);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today.getTime();
    }

    /**
     * 设置日期 -> 时分秒 00：00：00
     */
    public static Date setHhMmSsTo_0_0_0(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        // 如果没有设置毫秒值，数据库就随机生成一个毫秒值，当该值大于500ms时，会出现加1秒的情况
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 设置日期 -> 时分秒 23：59：59
     */
    public static Date setHhMmSsTo_23_59_59(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        // 如果没有设置毫秒值，数据库就随机生成一个毫秒值，当该值大于500ms时，会出现加1秒的情况
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date setHhMmTo_23_59(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 0);
        // 如果没有设置毫秒值，数据库就随机生成一个毫秒值，当该值大于500ms时，会出现加1秒的情况
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 计算两个时间之间的天数
     */
    public static int getDaysByBeginAndEnd(Date maxDate, Date minDate) {
        Calendar calendarMax = Calendar.getInstance();
        Calendar calendarMin = Calendar.getInstance();
        calendarMax.setTime(maxDate);
        calendarMin.setTime(minDate);
        int minDay = calendarMin.get(Calendar.DAY_OF_YEAR);
        int maxDay = calendarMax.get(Calendar.DAY_OF_YEAR);
        int minYear = calendarMin.get(Calendar.YEAR);
        int maxYear = calendarMax.get(Calendar.YEAR);

        int days = 0;

        if (minYear != maxYear) {
            int timeDistance = 0;
            for (int i = minYear; i < maxYear; i++) {
                // 闰年
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else {  // 平年
                    timeDistance += 365;
                }
            }
            days = timeDistance + (maxDay - minDay);
        } else {
            days = maxDay - minDay;
        }
        return days;
    }

    public static int getDateMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDateDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 获取当前时间月份的开始日期
     */
    public static Date getMonthBeginDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间月份的结束日期
     */
    public static Date getMonthEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    // 时分秒均为0
    public static Date getMonthEndDate2(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前时间年份的开始日期
     */
    public static Date getYearBeginDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int last = cal.getActualMinimum(Calendar.DAY_OF_YEAR);
        cal.set(Calendar.DAY_OF_YEAR, last);
        return cal.getTime();
    }

    /**
     * 合同完整月租期
     */
    public static int getLease(Date contractBeginTime, Date contractEndTime) {
        int lease = 0;
        for (int i = 1; i <= 999; i++) {
            // 每月结束日期 = 合同开始日期 + 1个月 - 1天
            Date monthEndTime = addDays(addMonths(contractBeginTime, i), -1);

            if (DateUtil.sameDate(monthEndTime, contractEndTime) == 1) {
                return lease;
            } else {
                lease = i;
            }
        }
        return lease;
    }

    /**
     * 零散天数
     */
    public static int getExtendDays(Date contractBeginTime, Date contractEndTime) {
        int lease = getLease(contractBeginTime, contractEndTime);
        if (lease > 0) {
            if (DateUtil.sameDate(DateUtil.addDay(DateUtil.addMonth(contractBeginTime, lease), -1), contractEndTime) == 0) {
                return 0;
            } else {
                contractBeginTime = addDay(addMonths(contractBeginTime, lease), -1);
                return getDaysByBeginAndEnd(contractEndTime, contractBeginTime);
            }
        } else {
            return getDaysIncludeBeginAndEnd(contractBeginTime, contractEndTime);
        }
    }

    public static Integer sameDate(Date d1, Date d2) {
        if (null == d1 || null == d2) {
            return 0;
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
        return cal1.getTime().compareTo(cal2.getTime());
    }

    public static int getDaysOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static java.time.LocalDate toLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str
     * @param format   如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 计算两个日期相差的年数
     *
     * @return
     */
    public static Integer getYearDiff(Date startDate, Date endDate) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(startDate);
        c2.setTime(endDate);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        return year2 - year1;
    }

    /**
     * 获取两个日期相差的月数
     */
    public static int getMonthDiff(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);
        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int day2 = c2.get(Calendar.DAY_OF_MONTH);
        // 获取年的差值 
        int yearInterval = year1 - year2;
        // 如果 d1的 月-日 小于 d2的 月-日 那么 yearInterval-- 这样就得到了相差的年数
        if (month1 < month2 || month1 == month2 && day1 < day2) {
            yearInterval--;
        }
        // 获取月数差值
        int monthInterval = (month1 + 12) - month2;
        if (day1 < day2) {
            monthInterval--;
        }
        monthInterval %= 12;
        int monthsDiff = Math.abs(yearInterval * 12 + monthInterval);
        return monthsDiff;
    }

    /**
     * 计算两个日期之间相差得天数，包含开始和结束日期
     */
    public static int getDaysIncludeBeginAndEnd(Date minDate, Date maxDate) {
        Calendar calendarMax = Calendar.getInstance();
        Calendar calendarMin = Calendar.getInstance();
        calendarMax.setTime(maxDate);
        calendarMin.setTime(minDate);
        int minDay = calendarMin.get(Calendar.DAY_OF_YEAR);
        int maxDay = calendarMax.get(Calendar.DAY_OF_YEAR);
        int minYear = calendarMin.get(Calendar.YEAR);
        int maxYear = calendarMax.get(Calendar.YEAR);
        int days = 0;
        if (minYear != maxYear) {
            int timeDistance = 0;
            for (int i = minYear; i < maxYear; i++) {
                // 闰年
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else {  // 平年
                    timeDistance += 365;
                }
            }
            days = timeDistance + (maxDay - minDay);
        } else {
            days = maxDay - minDay;
        }
        days = days + 1;
        return days;
    }

    /**
     * 计算两个日期相差的小时数
     *
     * @return
     */
    public static double calculateHourDiff(Date startDate, Date endDate) {
        long a = endDate.getTime();
        long b = startDate.getTime();
        return (double) ((a - b) / 1000) / 3600;
    }

    public static double calculateHourDiff2359(Date startDate, Date endDate) {
        if (endDate.equals(DateUtil.setHhMmTo_23_59(endDate))) {
            endDate = DateUtil.addMinutes(endDate, 1);
        }
        long a = endDate.getTime();
        long b = startDate.getTime();
        return (double) ((a - b) / 1000) / 3600;
    }

    // 方法已修改,不会返回负数
    public static long calculateSecondDiff(Date minDate, Date maxDate) {
        if (DateUtil.compareALessB(maxDate, minDate)) {
            return 1;
        }
        long max = maxDate.getTime();
        long min = minDate.getTime();
        long seconds = (max - min) / 1000;
        return seconds <= 0 ? 1 : seconds;
    }


    /**
     * 计算两个日期相差的秒数
     *
     * @return
     */
    public static int calculateLastedTime(Date startDate, Date endDate) {
        long a = endDate.getTime();
        long b = startDate.getTime();
        return (int) ((a - b) / 1000);
    }

    public static long getHourDifference(Date nowDate, Date endDate) {
        // 获得两个时间的毫秒时间差异
        long diff = nowDate.getTime() - endDate.getTime();
        // 计算差多少分钟
        return diff / (1000 * 60);
    }

    public static double getTimeDifference(Date nowDate, Date endDate) {
        //毫秒转换 To XXX
        long convertToDay = 1000 * 24 * 60 * 60;
        long convertToHour = 1000 * 60 * 60;
        long convertToMin = 1000 * 60;
        long convertToSec = 1000;
        // 获得两个时间的毫秒时间差异
        long dValue = nowDate.getTime() - endDate.getTime();
        // 计算差多少天
        long day = dValue / convertToDay;
        // 计算差多少小时
        long hour = dValue % convertToDay / convertToHour;
        // 计算差多少分钟
        long min = dValue % convertToDay % convertToHour / convertToMin;
        // 计算差多少秒
        long sec = dValue % convertToDay % convertToHour % convertToMin / convertToSec;
        //返回结果
//        return day + "天" + hour + "小时" + min + "分钟";
//天数数        return day;
        return day * 24 + hour;
    }


    private static Integer getMonthDiff1(Date startDate, Date endDate) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(startDate);
        c2.setTime(endDate);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int month2 = c2.get(Calendar.MONTH);

        if (year1 == year2 && month1 == month2) {
            return 0;
        } else {
            return 1;
        }
    }

    // 获取某个周的第X天
    public static Date getWeekDay(Date weekDate, Integer days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(weekDate);
        calendar.set(Calendar.DAY_OF_WEEK, days);
        return calendar.getTime();
    }

    // 获取某个月的第X天
    public static Date getMonthDay(Date monthDate, Integer days) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(monthDate);
            int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            if (days > actualMaximum) {
                days = actualMaximum;
            }
            calendar.set(Calendar.DAY_OF_MONTH, days);
            return calendar.getTime();
        } catch (Exception e) {
            log.error("getMonthDay error");
            log.error(e.getMessage(), e);
        }
        return null;
    }

    // 获取某年的第X天
    public static Date getYearDay(Date date, Integer days) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int actualMaximum = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
            if (days > actualMaximum) {
                days = actualMaximum;
            }
            calendar.set(Calendar.DAY_OF_YEAR, days);
            return calendar.getTime();
        } catch (Exception e) {
            log.error("getYearDay error");
            log.error(e.getMessage(), e);
        }
        return null;
    }
}
