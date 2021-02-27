package xyz.itclay.usermanager.entity;

import lombok.Data;
import xyz.itclay.usermanager.utils.CalculationUtil;

import java.io.Serializable;

@Data
public class Cpu implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 核心数
     */
    private int cpuNum;

    /**
     * CPU总的使用率
     */
    private double total;

    /**
     * CPU系统使用率
     */
    private double sys;

    /**
     * CPU用户使用率
     */
    private double used;

    /**
     * CPU当前等待率
     */
    private double wait;

    /**
     * CPU当前空闲率
     */
    private double free;


    public double getTotal() {
        return CalculationUtil.round(CalculationUtil.multiply(total+"", "100"), 2);
    }

    public double getSys() {
        return CalculationUtil.round(CalculationUtil.multiply((sys/total)+"", "100"), 2);
    }

    public double getUsed() {
        return CalculationUtil.round(CalculationUtil.multiply((used / total)+"", "100"), 2);
    }

    public double getWait() {
        return CalculationUtil.round(CalculationUtil.multiply((wait / total)+"", "100"), 2);
    }

    public double getFree() {
        return CalculationUtil.round(CalculationUtil.multiply((free / total)+"", "100"), 2);
    }
}