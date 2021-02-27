package xyz.itclay.usermanager.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间工具类
 *
 * @author ZhangSenmiao
 * @date 2021/2/24 18:57
 **/
public class DateTimeUtil {

    static String[] weeks = {"日", "一", "二", "三", "四", "五", "六"};


    /**
     * 根据日期字符串判断当月第几周以及一周第几天
     *
     * @param str 日期字符串
     * @return 周几
     * @throws Exception 异常
     */
    public static int getWeek(String str) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //一个月中的第几周
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        //一周中的第几天（从周日开始）
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取系统当前时间
     *
     * @return 系统当前时间
     */
    public static String getDateTimeStr() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currTime = new Date();
        return formatter.format(currTime);
    }

    /**
     * 将date对象装换成时间字符串
     *
     * @param date 对象
     * @return 时间字符串
     * @throws Exception 异常
     */
    public static String getDateTimeStr(Date date) throws Exception {
        //格式化规则
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化成yyyy-MM-dd格式的时间字符串
        String strDate = sdf.format(date);
        Date newDate = sdf.parse(strDate);
        return sdf.format(newDate);
    }

    /**
     * 系统当前时间（时分秒）
     *
     * @return 系统当前时间（HH:mm:ss）
     */
    public static String getTimeStr() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date currTime = new Date();
        return formatter.format(currTime);
    }

    /**
     * 系统当前时间（date型）
     *
     * @return 当前系统时间的Date对象
     * @throws ParseException 异常
     */
    public static Date getDateTime() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currTime = new Date();
        return formatter.parse(formatter.format(currTime));
    }

    public static Date getDDate() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date currTime = new Date();
        Date curTime = formatter.parse(formatter.format(currTime));
        return curTime;
    }

    public static Date getDateTimeGsh() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date currTime = new Date();
        Date curTime = formatter.parse(formatter.format(currTime));
        return curTime;
    }


    public static String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date currTime = new Date();
        String curTime = formatter.format(currTime);
        return curTime;
    }


    public static String getGsDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        Date currTime = new Date();
        String curTime = formatter.format(currTime);
        return curTime;
    }

    //2017-2-2
    public static String getDateToStr(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        String formatDate = sdf.format(date);
        return formatDate;
    }

    public static String getMonthToStr(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date date = sdf.parse(str);
        String formatDate = sdf.format(date);
        return formatDate;
    }

    //转换yyyy-MM-dd
    public static String getDateStr(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(str);
        String formatDate = sdf.format(date);
        return formatDate;
    }

    public static String getDateType1(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(str);
        String formatDate = sdf.format(date);
        return formatDate;
    }

    public static String getDateTimeMonth() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M");
        Date currTime = new Date();
        String curTime = formatter.format(currTime);
        return curTime;
    }

    public static String getWeekFirstDate(String date) {
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(date.split("-")[0]),
                Integer.parseInt(date.split("-")[1]) - 1,
                Integer.parseInt(date.split("-")[2]));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        c.add(Calendar.DAY_OF_WEEK, (-1) * c.get(Calendar.DAY_OF_WEEK) + 1);
        return df.format(c.getTime());
    }


    public static String getWeekEndDate(String date) {
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(date.split("-")[0]),
                Integer.parseInt(date.split("-")[1]) - 1,
                Integer.parseInt(date.split("-")[2]));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        c.add(Calendar.DAY_OF_WEEK, 7 - c.get(Calendar.DAY_OF_WEEK));
        return df.format(c.getTime());
    }

    /**
     * 获取本周的第一天
     *
     * @return String
     **/
    public static String getWeekStart() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_MONTH, 0);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }

    /**
     * 获取本周的最后一天
     *
     * @return String
     **/
    public static String getWeekEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_WEEK, 1);
        Date time = cal.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(time);
    }


    public static String getDaty() {
        GregorianCalendar gc = new GregorianCalendar();
        int day = gc.get(Calendar.DAY_OF_MONTH);

        String d = "";
        if (day < 10) {
            d = "0" + day;
        } else {
            d = "" + day;
        }
        return d;
    }

    /**
     * @param @param  df
     * @param @param  oldDate
     * @param @param  newDate
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Title: compareDatesByCompareTo
     * @Description: 时间日期的比较
     */
    public static String compareDatesByCompareTo(DateFormat df, Date oldDate, Date newDate) {
        String flag = "";
        //how to check if date1 is equal to date2
        if (oldDate.compareTo(newDate) == 0) {
//	            System.out.println(df.format(oldDate) + " and " + df.format(newDate) + " are equal to each other");
            flag = "dengyu";
        }

        //checking if date1 is less than date 2
        if (oldDate.compareTo(newDate) < 0) {
//	            System.out.println(df.format(oldDate) + " is less than " + df.format(newDate));
            flag = "xiaoyu";
        }

        //how to check if date1 is greater than date2 in java
        if (oldDate.compareTo(newDate) > 0) {
//	            System.out.println(df.format(oldDate) + " is greater than " + df.format(newDate));
            flag = "dayu";
        }
        return flag;
    }

    public static String compareDatesByDateMethods(DateFormat df, Date oldDate, Date newDate) {
        String flag = "";
        //how to check if two dates are equals in java
        if (oldDate.equals(newDate)) {
            System.out.println(df.format(oldDate) + " and " + df.format(newDate) + " are equal to each other");
            flag = "dengyu";
        }

        //checking if date1 comes before date2
        if (oldDate.before(newDate)) {
            System.out.println(df.format(oldDate) + " comes before " + df.format(newDate));
            flag = "xiaoyu";
        }

        //checking if date1 comes after date2
        if (oldDate.after(newDate)) {
            System.out.println(df.format(oldDate) + " comes after " + df.format(newDate));
            flag = "dayu";
        }
        return flag;
    }

    public static String compareDatesByCalendarMethods(DateFormat df, Date oldDate, Date newDate) {
        String flag = "";
        //creating calendar instances for date comparision
        Calendar oldCal = Calendar.getInstance();
        Calendar newCal = Calendar.getInstance();

        oldCal.setTime(oldDate);
        newCal.setTime(newDate);

        //how to check if two dates are equals in java using Calendar
        if (oldCal.equals(newCal)) {
//	            System.out.println(df.format(oldDate) + " and " + df.format(newDate) + " are equal to each other");
            flag = "dengyu";
        }

        //how to check if one date comes before another using Calendar
        if (oldCal.before(newCal)) {
//	            System.out.println(df.format(oldDate) + " comes before " + df.format(newDate));
            flag = "xiaoyu";
        }

        //how to check if one date comes after another using Calendar
        if (oldCal.after(newCal)) {
//	            System.out.println(df.format(oldDate) + " comes after " + df.format(newDate));
            flag = "dayu";
        }
        return flag;
    }

    /**
     * @param @param
     * @param @return 设定文件
     * @return String    返回类型
     * @throws
     * @Title: getNowBeforeTime
     * @Description: 计算多少分钟之前的时间
     */
    public static String getNowBeforeTime(int minminute) {
        Date now = new Date();
        Date now_10 = new Date(now.getTime() - minminute * 60 * 1000); //10分钟前的时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
        String nowTime_10 = dateFormat.format(now_10);
        return nowTime_10;
    }


    public static String getBeforeDaty(int i) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.DAY_OF_MONTH, -i);
        int year = gc.get(Calendar.YEAR);
        int month = gc.get(Calendar.MONTH) + 1;
        int day = gc.get(Calendar.DAY_OF_MONTH);
        System.out.println("前150天是：" + year + "-" + month + "-" + day);

        String m = "";
        String d = "";
        if (month < 10) {
            m = "0" + month;
        } else {
            m = "" + month;
        }
        if (day < 10) {
            d = "0" + day;
        } else {
            d = "" + day;
        }
        return year + "-" + m + "-" + d;
    }

    public static void main1(String[] args) throws ParseException {
//	    	System.out.println(getNowBeforeTime(120));
//	    	
//			GregorianCalendar gc=new GregorianCalendar();
//			gc.add(Calendar.DAY_OF_MONTH,-10);
//			int year=gc.get(Calendar.YEAR);
//			int month=gc.get(Calendar.MONTH)+1;
//			int day=gc.get(Calendar.DAY_OF_MONTH);
//			System.out.println("前150天是："+year+"-"+month+"-"+day);
//			
//			System.out.println(DateTimeUtil.getDateTimeStr().substring(0,10));
////			
//			
//			System.out.println(getDateTimeGsh());


        //System.out.println(getdatetimetounix(DateTimeUtil.getDateTimeStr()));

        //System.out.println(DateTimeUtil.TimeStampDate("1415242236"));

        //System.out.println(new Date().getTime());
//	    	String str = "03/12/2017";
//	    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
//			   Date date = sdf.parse(str);  
//			   System.out.println(date);
        //String formatDate = DateFormat.getDateInstance().format(date);


    }

    public static String getdatetimetounix(String datetime) {
        Timestamp appointTime = Timestamp.valueOf(datetime);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = df.parse(String.valueOf(appointTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long s = date.getTime();
        System.out.println(s);
        return String.valueOf(s).substring(0, 10);
    }

    public static String TimeStampDate(String timestampString) {
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
        return date;
    }


    /**
     * 今年中的第几周
     *
     * @param date
     * @return
     */
    public static int getWeekNums(Date date) {
        GregorianCalendar g = new GregorianCalendar();
        g.setTime(date);
        return g.get(Calendar.WEEK_OF_YEAR);//获得周数
    }


    /**
     * 周几（今天是周几）
     *
     * @return
     */
    public static String getWeeks() {
        Calendar c = Calendar.getInstance();
//			  int week = c.get(Calendar.WEEK_OF_MONTH);//获取是本月的第几周
        int day = c.get(Calendar.DAY_OF_WEEK);//获致是本周的第几天地, 1代表星期天...7代表星期六
//			  System.out.println("今天是本月的第" + week + "周");
//			  System.out.println("今天是星期" + weeks[day-1]);
        String str = weeks[day - 1];
        return str;
    }

    /**
     * 获得当前年
     *
     * @return
     */
    public static String getCurrentYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(new Date());
    }

    /**
     * 获得当前年前一年
     *
     * @return
     */
    public static String getCurrentYear(int num) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -num);
        Date y = c.getTime();
        String year = sdf.format(y);
//	        System.out.println("过去一年："+year);
        return year;
    }
    /**
     * 获得当前月
     * @return
    //		  */
//		 public static int getCurrentMonth(){
//			 Calendar calendar = Calendar.getInstance();
////			 calendar.add(Calendar.DATE, -1);    //得到前一天
////			 calendar.add(Calendar.MONTH, -1);    //得到前一个月
//			 int year = calendar.get(Calendar.YEAR);
//			 int month = calendar.get(Calendar.MONTH)+1;
//			return month;
//		 }

    /**
     * 获得当前年月
     *
     * @return
     */
    public static String getCurrentYearMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(new Date());
    }

    /**
     * @param @return
     * @param @throws Exception    设定文件
     * @return int[]    返回类型
     * @throws
     * @Title: temp
     * @Description: 获取当月的天数并以数组的形式展现出来
     */
    public static int[] temp() throws Exception {
//			   String strDate = getCurrentYearMonth();
//			   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM"); 
//			   Calendar calendar = new GregorianCalendar();   
//			   Date date = sdf.parse(strDate); 
//			   calendar.setTime(date);   
//			   int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);//把日期设置为当月第一天
        a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = a.get(Calendar.DATE);
//			    return maxDate;  
        int[] d = new int[maxDate];

        for (int i = 0; i < maxDate; i++) {
            d[i] = i + 1;
            //System.out.print(d[i]);
        }
        return d;
    }

    /**
     * @Description: 根据输入的月份获得上一个月
     * @Param: String yyyy-mm
     * @return: String yyyy-mm
     * @Author: zhaojishun
     * @Date: 2018.11.6
     */
    public static String getLastMonth(String yearMonth) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        Date curDate = java.sql.Date.valueOf(yearMonth + "-01");
        calendar.setTime(curDate);
        //取得上一个时间
        calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) - 1);
        //取得上一个月的下一天
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 1);
        return sdf.format(calendar.getTime());

    }

    public static String getAroundMonth(String yearMonth, int num) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        Date curDate = java.sql.Date.valueOf(yearMonth + "-01");
        calendar.setTime(curDate);
        calendar.set(Calendar.MONDAY, calendar.get(Calendar.MONDAY) + num);
        return sdf.format(calendar.getTime());

    }


    /**
     * @Description: 获取前后月
     * @Param: [i]
     * @return: java.lang.String
     * @Author: anxingtao
     * @Date: 2019-1-10 10:56
     */
    public static String getAroundMonth(int i) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.MONTH, i);
        int year = gc.get(Calendar.YEAR);
        int month = gc.get(Calendar.MONTH) + 1;

        String m = "";
        String d = "";
        if (month < 10) {
            m = "0" + month;
        } else {
            m = "" + month;
        }
        System.out.println(year + "-" + m);
        return year + "-" + m;
    }


    /**
     * @Description: 获取前后天
     * @Param: [i]
     * @return: java.lang.String
     * @Author: anxingtao
     * @Date: 2019-1-10 11:29
     */
    public static String getAroundDate(int i) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.DAY_OF_MONTH, i);
        int year = gc.get(Calendar.YEAR);
        int month = gc.get(Calendar.MONTH) + 1;
        int day = gc.get(Calendar.DAY_OF_MONTH);
        String m = "";
        String d = "";
        if (month < 10) {
            m = "0" + month;
        } else {
            m = "" + month;
        }
        if (day < 10) {
            d = "0" + day;
        } else {
            d = "" + day;
        }
        return year + "-" + m + "-" + d;
    }

    /**
     * 获取下一个月
     *
     * @param month 月份
     * @return 下一个月
     */
    public static String getNextMonth(String month) {
        String[] months = month.split("-");
        int year = Integer.parseInt(months[0]);
        int mon = Integer.parseInt(months[1]);
        if (mon == 12) {
            year++;
            mon = 1;
        } else {
            mon = mon + 1;
        }
        String ym = "";
        if (mon < 10) {
            ym = year + "-0" + mon;
        } else {
            ym = year + "-" + mon;
        }
        return ym;
    }


    /**
     * 月份之间的月数
     *
     * @param minDate 开始月数
     * @param maxDate 结束月数
     * @return 月份集合
     * @throws ParseException 异常
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        //格式化为年月
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }

    /**
     * 年份之间的年数
     *
     * @param minDate 开始年份
     * @param maxDate 结束年份
     * @return 年份集合
     * @throws ParseException 异常
     */
    public static List<String> getYearBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        //格式化为年
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), 1, 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), 1, 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.YEAR, 1);
        }

        return result;
    }

    /**
     * 计算两个月之间的月数
     *
     * @param minDate 开始月数
     * @param maxDate 结束月数
     * @return 月数
     * @throws ParseException 异常
     */
    public static int getMonthBetweenNum(String minDate, String maxDate) throws ParseException {
        int num = 0;
        //格式化为年月
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            num++;
            curr.add(Calendar.MONTH, 1);
        }

        return num;
    }

    /**
     * 获取一个月的天数
     *
     * @param date 日期字符串（年月）
     * @return 天数
     */
    public static int getDaysOfMonth(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 日期格式转换
     *
     * @param month 日期字符串（yyyy-MM）
     * @return yyyy年MM月
     * @throws ParseException 异常
     */
    public static String getYears(String month) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM").parse(month);
        String now = new SimpleDateFormat("yyyy年MM月").format(date);
        return now;
    }

    /**
     * 日期格式转换
     *
     * @param day 日期字符串（yyyy-MM-dd）
     * @return yyyy年MM月dd日
     */
    public static String getDateFormatConversion(String day) {
        Date date = null;
        String now = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(day);
            now = new SimpleDateFormat("yyyy年MM月dd日").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 时间以月为单位后移
     *
     * @param yearMonth 日期字符串（yyyy-MM-dd）
     * @param num       推后的月数
     * @return 推后的字符串
     */

    public static String getAroundMonthBeforeDate(String yearMonth, int num) {
        //获取当前时间
        Date date = new Date();
        //获得当前时间前一天时间
        Calendar calendar = Calendar.getInstance();
        Date curDate = java.sql.Date.valueOf(yearMonth);
        calendar.setTime(curDate);
        calendar.add(Calendar.MONTH, num);
        calendar.add(Calendar.DATE, -1);
//		calendar.add(Calendar.DATE, 1);
        Date resDate = calendar.getTime();
        //将得到的时间以字符串形式输出控制台
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(resDate);

    }

    /**
     * 获取每月的最后一天
     *
     * @param yearMonth 年月
     * @return 每月的最后一天
     */

    public static String getLastDayOfMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.split("-")[0]);  //年
        int month = Integer.parseInt(yearMonth.split("-")[1]); //月
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        // cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.MONTH, month); //设置当前月的上一个月
        // 获取某月最大天数
        //int lastDay = cal.getActualMaximum(Calendar.DATE);
        int lastDay = cal.getMinimum(Calendar.DATE); //获取月份中的最小值，即第一天
        // 设置日历中月份的最大天数
        //cal.set(Calendar.DAY_OF_MONTH, lastDay);
        cal.set(Calendar.DAY_OF_MONTH, lastDay - 1); //上月的第一天减去1就是当月的最后一天
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 根据日期字符串返回下一天日期
     *
     * @param date 日期字符串
     * @return 下一天日期
     */

    public static String getDateNext(String date) {
        if (date.length() > 7) {
            Calendar c = Calendar.getInstance();
            Date cdate = null;
            try {
                cdate = new SimpleDateFormat("yy-MM-dd").parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.setTime(cdate);
            int day1 = c.get(Calendar.DATE);
            c.set(Calendar.DATE, day1 + 1);
            return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
        } else {
            Calendar c = Calendar.getInstance();
            Date cdate = null;
            try {
                cdate = new SimpleDateFormat("yy-MM").parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.setTime(cdate);
            int day1 = c.get(Calendar.MONTH);
            c.set(Calendar.MONTH, day1 + 1);
            return new SimpleDateFormat("yyyy-MM").format(c.getTime());
        }
    }

    /**
     * 判断是否为一个月的最后一天
     *
     * @param day 日期(yyyy-MM-dd)
     * @return bool型的值
     * @throws Exception 异常
     */

    public static boolean isLastDayOfMonth(String day) throws Exception {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(day);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 计算两个时间差
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return 多少天多少小时多少分钟
     */
    public static String getDatePoor(Date startDate, Date endDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }
}
