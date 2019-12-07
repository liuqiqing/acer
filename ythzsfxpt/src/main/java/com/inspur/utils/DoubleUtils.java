package com.inspur.utils;

import java.text.DecimalFormat;

/**
 * 针对计算的工具类
 * @author zxp
 * @date 2018年12月29日
 */
public class DoubleUtils {
    /**
     * @param d1
     * @param d2
     * @return 返回d1除以d2的百分比，保留两位小数
     */
    public static String getDoublePercent(double d1,double d2){
        double c = d2 == 0 ? 0 : d1 / d2;
        DecimalFormat df = new DecimalFormat("#0.00");
        String str = df.format(c*100)+"%";
        return str;
    }

    /**
     * @param d1
     * @param d2
     * @return 返回d1除以d2的百分比，不保留小数带点后的位数
     */
    public static String getDoublePercent2(double d1,double d2){
        double c = d2 == 0 ? 0 : d1 / d2;
        DecimalFormat df = new DecimalFormat("#0");
        String str = df.format(c*100)+"%";
        return str;
    }

    /**
     * Object类型转为Double
     */
    public static Double objectToDouble(Object obj){
        String _str = obj.toString();
        double _val = Double.parseDouble(_str);
        return _val;
    }


}
