package xyz.itclay.datatiame;

import org.junit.Test;
import xyz.itclay.usermanager.utils.DateTimeUtil;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author ZhangSenmiao
 * @date 2021/2/24 19:00
 **/
public class TestDatetime {
    /**
     * 测试返回周数以及天数
     *
     * @throws Exception 异常
     */
    @Test
    public void test01() throws Exception {
        int week = DateTimeUtil.getWeek("2021-02-28");
        System.out.println(week);
    }

    /**
     * 测试获取系统当前时间 （yyyy-MM-dd HH:mm:ss ）
     */
    @Test
    public void test02() {
        String dateTimeStr = DateTimeUtil.getDateTimeStr();
        System.out.println(dateTimeStr);
    }

    /**
     * 根据date对象返回时间字符串
     *
     * @throws Exception 异常
     */
    @Test
    public void test03() throws Exception {
        String dateTimeStr = DateTimeUtil.getDateTimeStr(new Date());
        System.out.println(dateTimeStr);
    }

    /**
     * 测试获取系统当前时间（yyyy-MM-dd）
     */
    @Test
    public void test04() {
    }

    /**
     * 测试获取系统当前时间（HH:mm:ss）
     */
    @Test
    public void test05() {
        String date = DateTimeUtil.getTimeStr();
        System.out.println(date);
    }

    /**
     * 测试获取系统当前时间（date)型
     */
    @Test
    public void test06() throws ParseException {
        Date dateTime = DateTimeUtil.getDateTime();
        System.out.println(dateTime);
    }

    /**
     * 测试一天是否为一个月中的最后一天(日期字符串)
     * 返回boolean型值
     */
    @Test
    public void test07() throws Exception {
        boolean lastDayOfMonth = DateTimeUtil.isLastDayOfMonth("2021-02-28");
        System.out.println(lastDayOfMonth);
    }

    /**
     * 测试获取下一天时间
     */
    @Test
    public void test08() throws Exception {
        String dateNext = DateTimeUtil.getDateNext("2021-02-24");
        System.out.println(dateNext);
    }

    /**
     * 获取每月的最后一天
     */
    @Test
    public void test09() throws Exception {
        String dateNext = DateTimeUtil.getLastDayOfMonth("2021-02");
        System.out.println(dateNext);
    }

    /**
     * 时间以月为单位后移
     */
    @Test
    public void test10() throws Exception {
        String dateNext = DateTimeUtil.getAroundMonthBeforeDate("2021-02-24", 13);
        System.out.println(dateNext);
    }

    /**
     * 日期格式转换
     */
    @Test
    public void test11() throws Exception {
        String dateNext = DateTimeUtil.getDateFormatConversion("2021-02-24");
        System.out.println(dateNext);
    }

    /**
     * 获取一个月的天数
     */
    @Test
    public void test12() throws Exception {
        int dateNext = DateTimeUtil.getDaysOfMonth("2021-03");
        System.out.println(dateNext);
    }

    /**
     * 两个月之间的月数
     */
    @Test
    public void test13() throws Exception {
        int dateNext = DateTimeUtil.getMonthBetweenNum("2021-03", "2022-06");
        System.out.println(dateNext);
    }
    /**
     * 两年之间的年数
     */
    @Test
    public void test14() throws Exception {
        List<String> yearBetween = DateTimeUtil.getYearBetween("2021", "2022");
        System.out.println(yearBetween);
    }
}
