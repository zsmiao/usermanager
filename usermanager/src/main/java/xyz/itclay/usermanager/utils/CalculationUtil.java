package xyz.itclay.usermanager.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 精确计算工具类(加，减，乘，除，返回较大值，返回较小值)
 */
public class CalculationUtil {

    /**
     * 提供精确加法计算的add方法
     */
    public static String add(String value1, String value2) {
        return add(value1, value2, 0, 0);
    }

    /**
     * 提供精确加法计算的add方法(默認四捨五入)
     * @param value1 被加数
     * @param value2 加数
     * @param scale 精确范围(小数点后几位)
     */
    public static String add(String value1, String value2, int scale) {
        return add(value1, value2, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确加法计算的add方法
     * @param value1 被加数
     * @param value2 加数
     * @param scale 精确范围(小数点后几位)
     */
    public static String add(String value1, String value2, int scale, int mode) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        BigDecimal result = b1.add(b2);
        // mode为0，则不需要精确
        if (mode != 0) {
            result = result.setScale(scale, mode);
        }
        return result.toString();
    }

    public static int compareTo(String value1, String value2, int scale, int mode) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        BigDecimal result = b1.subtract(b2);
        // mode为0，则不需要精确
        if (mode != 0) {
            result = result.setScale(scale, mode);
        }
        return result.compareTo(BigDecimal.ZERO);
    }

    /**
     * 提供精确的除法运算方法divide
     * @param value1 被除数
     * @param value2 除数
     */
    public static String divide(String value1, String value2) throws IllegalAccessException {
        return divide(value1, value2, 0, null);
    }

    /**
     * 提供精确的除法运算方法divide(默認四捨五入)
     * @param value1 被除数
     * @param value2 除数
     * @param scale 精确范围(小数点后几位)
     */
    public static String divide(String value1, String value2, int scale) throws IllegalAccessException {
        return divide(value1, value2, scale, RoundingMode.HALF_UP);
    }

    /**
     * 提供精确的除法运算方法divide
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale 精确范围(小数点后几位)
     * @param roundingMode 精確模式
     */
    public static String divide(String value1, String value2, int scale, RoundingMode roundingMode)
            throws IllegalAccessException {
        // 如果精确范围小于0，抛出异常信息
        if (scale < 0) {
            throw new IllegalAccessException("精确度不能小于0");
        }
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        // roundingMode为null，则不需要精确
        if (roundingMode != null) {
            return new Double(b1.divide(b2, scale, roundingMode).doubleValue()).toString();
        } else {
            return new Double(b1.divide(b2).doubleValue()).toString();
        }
    }

    /**
     * 比较大小 ：返回较大的那个
     */
    public static String getMax(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return new Double(b1.max(b2).doubleValue()).toString();
    }

    /**
     * 比较大小 ：返回较小的那个
     */
    public static String getMin(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return new Double(b1.min(b2).doubleValue()).toString();
    }


    /**
     *
     * 提供精确乘法运算的multiply方法
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static String multiply(String value1, String value2) {
        return multiply(value1, value2, 0, 0);
    }

    /**
     * 提供精确乘法运算的multiply方法(默認四捨五入)
     * @param value1 被乘数
     * @param value2 乘数
     * @param scale 精确范围(小数点后几位)
     */
    public static String multiply(String value1, String value2, int scale) {
        return multiply(value1, value2, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确乘法运算的multiply方法
     * @param value1 被乘数
     * @param value2 乘数
     * @param scale 精确范围(小数点后几位)
     */
    public static String multiply(String value1, String value2, int scale, int mode) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        BigDecimal result = b1.multiply(b2);
        // mode为0，则不需要精确
        if (mode != 0) {
            result = result.setScale(scale, mode);
        }
        return result.toString();
    }

    /**
     * 提供精确减法运算的subtract方法
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static String subtract(String value1, String value2) {
        return subtract(value1, value2, 0, 0);
    }

    /**
     * 提供精确减法运算的subtract方法(默認四捨五入)
     * @param value1 被减数
     * @param value2 减数
     * @param scale 精确范围(小数点后几位)
     */
    public static String subtract(String value1, String value2, int scale) {
        return subtract(value1, value2, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确减法运算的subtract方法
     * @param value1 被减数
     * @param value2 减数
     * @param scale 精确范围(小数点后几位)
     */
    public static String subtract(String value1, String value2, int scale, int mode) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        BigDecimal result = b1.subtract(b2);
        // mode为0，则不需要精确
        if (mode != 0) {
            result = result.setScale(scale, mode);
        }
        return result.toString();
    }


    /**
     * 提供精确的小数位四舍五入处理。
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(String v, int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.valueOf(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, RoundingMode.HALF_UP).doubleValue();
    }

}