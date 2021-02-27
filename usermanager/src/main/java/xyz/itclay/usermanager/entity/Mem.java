package xyz.itclay.usermanager.entity;

import lombok.Data;
import xyz.itclay.usermanager.utils.CalculationUtil;

import java.io.Serializable;

@Data
public class Mem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 内存总量
     */
    private double total;

    /**
     * 已用内存
     */
    private double used;

    /**
     * 剩余内存
     */
    private double free;

    public double getTotal() {
        String value = "";
        try {
            value = CalculationUtil.divide(total+"", (1024 * 1024 * 1024)+"", 2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Double.parseDouble(value);
    }

    public double getUsed() {
        String value = "";
        try {
            value = CalculationUtil.divide(used+"", (1024 * 1024 * 1024)+"", 2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Double.parseDouble(value);
    }


    public double getFree() {
        String value = "";
        try {
            value = CalculationUtil.divide(free+"", (1024 * 1024 * 1024)+"", 2);
        }catch (Exception e){
            e.printStackTrace();
        }
        return Double.parseDouble(value);
    }

    public double getUsage() {
        String value = "";
        try {
            value = CalculationUtil.multiply(CalculationUtil.divide(used+"", total+"", 4), "100");
        }catch (Exception e){
            e.printStackTrace();
        }
        return Double.parseDouble(value);
    }
}