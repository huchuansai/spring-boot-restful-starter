package com.hucs.top.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Description: 
 * @Param: 
 * @return: 
 * @Author: huchuansai
 * @Date: 2021/5/8 11:49 上午
 */ 
public class BigDecimalUtil {


    /**************************************ADD*************************************************************************/
    /**
     * numStr1 + numStr2
     *
     * @param numStr1
     * @param numStr2
     * @param scale
     * @return
     */
    public static BigDecimal add(String numStr1, String numStr2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numStr1);
        BigDecimal num2 = new BigDecimal(numStr2);
        return add(num1, num2, scale, roundMode);
    }

    public static BigDecimal add(Long numLong1, Long numLong2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numLong1);
        BigDecimal num2 = new BigDecimal(numLong2);
        return add(num1, num2, scale, roundMode);
    }

    public static BigDecimal add(Double numDouble1, Double numDouble2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numDouble1);
        BigDecimal num2 = new BigDecimal(numDouble2);
        return add(num1, num2, scale, roundMode);
    }

    public static BigDecimal add(BigDecimal num1, BigDecimal num2, int scale, int roundMode) {
        if (num1 == null) {
            num1 = new BigDecimal(0);
        }
        if (num2 == null) {
            num2 = new BigDecimal(0);
        }
        BigDecimal result = num1.add(num2);
        result = result.setScale(scale, roundMode);
        return result;
    }

    /**************************************SUBTRACT********************************************************************/
    /**
     * numStr1 - numStr2
     *
     * @param numStr1 被减数
     * @param numStr2 不带符号的减数
     * @param scale
     * @return
     */
    public static BigDecimal subtract(String numStr1, String numStr2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numStr1);
        BigDecimal num2 = new BigDecimal(numStr2);
        return subtract(num1, num2, scale, roundMode);
    }

    public static BigDecimal subtract(Long numLong1, Long numLong2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numLong1);
        BigDecimal num2 = new BigDecimal(numLong2);
        return subtract(num1, num2, scale, roundMode);
    }

    public static BigDecimal subtract(Double numDouble1, Double numDouble2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numDouble1);
        BigDecimal num2 = new BigDecimal(numDouble2);
        return subtract(num1, num2, scale, roundMode);
    }

    public static BigDecimal subtract(BigDecimal num1, BigDecimal num2, int scale, int roundMode) {
        if (num1 == null) {
            num1 = new BigDecimal(0);
        }
        if (num2 == null) {
            num2 = new BigDecimal(0);
        }
        BigDecimal result = num1.subtract(num2);
        result = result.setScale(scale, roundMode);
        return result;
    }

    /**************************************DIVIDE**********************************************************************/
    /**
     * numStr1 / numStr2
     *
     * @param numStr1
     * @param numStr2
     * @param scale
     * @param roundMode
     * @return
     */
    public static BigDecimal divide(String numStr1, String numStr2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numStr1);
        BigDecimal num2 = new BigDecimal(numStr2);
        return divide(num1, num2, scale, roundMode);
    }

    public static BigDecimal divide(Long numLong1, Long numLong2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numLong1);
        BigDecimal num2 = new BigDecimal(numLong2);
        return divide(num1, num2, scale, roundMode);
    }

    public static BigDecimal divide(BigDecimal numLong1, Integer numLong2, int scale, int roundMode) {
        BigDecimal num1 = numLong1;
        BigDecimal num2 = new BigDecimal(numLong2);
        return divide(num1, num2, scale, roundMode);
    }

    public static BigDecimal divide(Double numDouble1, Double numDouble2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numDouble1);
        BigDecimal num2 = new BigDecimal(numDouble2);
        return divide(num1, num2, scale, roundMode);
    }

    public static BigDecimal divide(BigDecimal num1, BigDecimal num2, int scale, int roundMode) {
        BigDecimal result = num1.divide(num2, scale, roundMode);
        result = result.setScale(scale, roundMode);
        return result;
    }

    /**************************************MULTIPLY********************************************************************/
    /**
     * numStr1 * numStr2
     *
     * @param numStr1
     * @param numStr2
     * @param scale
     * @param roundMode
     * @return
     */
    public static BigDecimal multiply(String numStr1, String numStr2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numStr1);
        BigDecimal num2 = new BigDecimal(numStr2);
        return multiply(num1, num2, scale, roundMode);
    }

    public static BigDecimal multiply(Long numStr1, Long numStr2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numStr1);
        BigDecimal num2 = new BigDecimal(numStr2);
        return multiply(num1, num2, scale, roundMode);
    }

    public static BigDecimal multiply(Double numDouble1, Double numDouble2, int scale, int roundMode) {
        BigDecimal num1 = new BigDecimal(numDouble1);
        BigDecimal num2 = new BigDecimal(numDouble2);
        return multiply(num1, num2, scale, roundMode);
    }

    public static BigDecimal multiply(BigDecimal numDouble1, Integer numDouble2, int scale, int roundMode) {
        BigDecimal num1 = numDouble1;
        BigDecimal num2 = new BigDecimal(numDouble2);
        return multiply(num1, num2, scale, roundMode);
    }

    public static BigDecimal multiply(BigDecimal num1, BigDecimal num2, int scale, int roundMode) {
        BigDecimal result = num1.multiply(num2);
        result = result.setScale(scale, roundMode);
        return result;
    }

    public static BigDecimal multiply(Integer num1, BigDecimal num2) {
        BigDecimal result = new BigDecimal(num1).multiply(num2);
        return result;
    }


    /**************************************COMPARETO*******************************************************************/
    /**
     * @param numStr1
     * @param numStr2
     * @return -1, 0, or 1 as numStr1 is numerically
     * less than, equal to, or greater than numStr2.
     */
    public static int compareTo(String numStr1, String numStr2) {
        BigDecimal num1 = new BigDecimal(numStr1);
        BigDecimal num2 = new BigDecimal(numStr2);
        return num1.compareTo(num2);
    }

    public static int compareTo(Long numLong1, Long numLong2) {
        BigDecimal num1 = new BigDecimal(numLong1);
        BigDecimal num2 = new BigDecimal(numLong2);
        return num1.compareTo(num2);
    }

    public static int compareTo(Double numDouble1, Double numDouble2) {
        BigDecimal num1 = new BigDecimal(numDouble1);
        BigDecimal num2 = new BigDecimal(numDouble2);
        return num1.compareTo(num2);
    }


    /**
     * 把金额从分转换成元
     * eg:1234 to  12.34
     *
     * @param amountStr
     * @return
     */
    public static BigDecimal amountFenTOamountYuan(String amountStr) {
        if (amountStr == null || "".equals(amountStr)) {
            return BigDecimal.ZERO;
        }
        BigDecimal bigDecimalFen = new BigDecimal(amountStr);
        BigDecimal bigDecimalYuan = bigDecimalFen.divide(new BigDecimal(100));

        return bigDecimalYuan;
    }

    public static BigDecimal strToBig(String amount) {
        if (amount == null || "".equals(amount)) {
            return BigDecimal.ZERO;
        }
        return new BigDecimal(amount);
    }

    /**
     * 把金额从厘分转换成元
     * eg:1234 to  12.34
     *
     * @param amountStr
     * @return
     */
    public static BigDecimal amountLTOamountYuan(String amountStr) {
        if (amountStr == null || "".equals(amountStr)) {
            return BigDecimal.ZERO;
        }
        BigDecimal bigDecimalFen = new BigDecimal(amountStr);
        BigDecimal bigDecimalYuan = bigDecimalFen.divide(new BigDecimal(1000));

        return bigDecimalYuan;
    }

    public static int getInt(BigDecimal amount, int number) {
        BigDecimal bd = amount.multiply(new BigDecimal(number)).setScale(0, BigDecimal.ROUND_HALF_UP);
        return Integer.parseInt(bd.toString());
    }

    public static Long getLong(BigDecimal amount, int number) {
        BigDecimal bd = amount.multiply(new BigDecimal(number)).setScale(0, BigDecimal.ROUND_HALF_UP);
        return Long.parseLong(bd.toString());
    }

    /**
     * 厘转元保留两位小数：如1230 -> 1.23
     *
     * @param amountStr
     * @return
     */
    public static BigDecimal coverterLTOYuan(String amountStr) {

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (amountStr == null || "".equals(amountStr)) {
            amountStr = "0";
        }
        BigDecimal bigDecimalLi = new BigDecimal(amountStr);
        BigDecimal bigDecimalYuan = bigDecimalLi.divide(new BigDecimal(1000));
        String re = decimalFormat.format(bigDecimalYuan);

        return new BigDecimal(re);
    }

    public static BigDecimal coverterLTOYuanNODecimal(String amountStr) {

        DecimalFormat decimalFormat = new DecimalFormat("0");
        if (amountStr == null || "".equals(amountStr)) {
            amountStr = "0";
        }
        BigDecimal bigDecimalLi = new BigDecimal(amountStr);
        BigDecimal bigDecimalYuan = bigDecimalLi.divide(new BigDecimal(1000));
        String re = decimalFormat.format(bigDecimalYuan);

        return new BigDecimal(re);
    }

    /**
     * 格式化数据为100,111.23
     *
     * @param amountStr
     * @return
     */
    public static String formatTosepara(String amountStr) {

        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        if (amountStr == null || "".equals(amountStr)) {
            amountStr = "0";
        }
        BigDecimal bigDecimalLi = new BigDecimal(amountStr);
        BigDecimal bigDecimalYuan = bigDecimalLi.divide(new BigDecimal(1000));
        String re = decimalFormat.format(bigDecimalYuan);

        return re;
    }

    /**
     * 元转厘 12.22 -> 12 220
     *
     * @param bigDecimal
     * @return
     */
    public static int YTL(BigDecimal bigDecimal) {
        if (bigDecimal == null) bigDecimal = BigDecimal.ZERO;
        BigDecimal num1 = bigDecimal;
        BigDecimal num2 = new BigDecimal(1000);
        return multiply(num1, num2, 0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    /**
     * 元转分 0.01 -> 100
     *
     * @return
     */
    public static String getTrxamt(BigDecimal bigDecimal) {
        if (bigDecimal == null) bigDecimal = BigDecimal.ZERO;
        BigDecimal num1 = bigDecimal;
        BigDecimal num2 = new BigDecimal(100);
        return String.valueOf(multiply(num1, num2, 0, BigDecimal.ROUND_HALF_UP).intValue());
    }

    /**
     * 元转厘
     *
     * @param bigDecimal
     * @return
     */
    public static Long YTL_Long(BigDecimal bigDecimal) {
        if (bigDecimal == null) bigDecimal = BigDecimal.ZERO;
        BigDecimal num1 = bigDecimal;
        BigDecimal num2 = new BigDecimal(1000);
        return multiply(num1, num2, 0, BigDecimal.ROUND_HALF_UP).longValue();
    }

    public static BigDecimal LTY(Integer amount) {
        if (amount == null) {
            amount = 0;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        BigDecimal bigDecimalYuan = BigDecimalUtil.divide(String.valueOf(amount), String.valueOf(1000.0), 2, BigDecimal.ROUND_HALF_UP);
        String re = decimalFormat.format(bigDecimalYuan);
        return new BigDecimal(re);
    }

    /**
     * 厘转元
     *
     * @param amount
     * @return
     */
    public static BigDecimal LTY_Long(Long amount) {
        if (amount == null) {
            amount = 0L;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        BigDecimal bigDecimalYuan = BigDecimalUtil.divide(String.valueOf(amount), String.valueOf(1000.0), 2, BigDecimal.ROUND_HALF_UP);
        String re = decimalFormat.format(bigDecimalYuan);
        return new BigDecimal(re);
    }

    /**
     * num(int) / 1000 -> 小数
     *
     * @param value
     * @param decimalNum 保留小数位数
     * @return
     */
    public static BigDecimal toDecimal_1000(Integer value, int decimalNum) {
        if (value == null) {
            value = 0;
        }
        String format;
        switch (decimalNum) {
            case 1:
                format = "0.0";
                break;
            case 2:
                format = "0.00";
                break;
            case 3:
                format = "0.000";
                break;
            default:
                throw new RuntimeException("to decimal error");
        }

        DecimalFormat decimalFormat = new DecimalFormat(format);
        BigDecimal bigDecimal = BigDecimalUtil.divide(String.valueOf(value), String.valueOf(1000.0), 3, BigDecimal.ROUND_HALF_UP);
        String re = decimalFormat.format(bigDecimal);
        return new BigDecimal(re);
    }

    /**
     * 小数 * 1000 -> num(int)
     *
     * @param bigDecimal
     * @return
     */
    public static Integer toInt_1000(BigDecimal bigDecimal) {
        if (bigDecimal == null) bigDecimal = BigDecimal.ZERO;
        BigDecimal num1 = bigDecimal;
        BigDecimal num2 = new BigDecimal(1000);
        return multiply(num1, num2, 0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    public static BigDecimal add(BigDecimal value1, BigDecimal value2) {
        if (value1 != null && value2 != null) {
            return add(value1, value2, 2, BigDecimal.ROUND_HALF_UP);
        } else {
            return BigDecimal.ZERO;
        }
    }

    public static BigDecimal subtract(BigDecimal value1, BigDecimal value2) {
        if (value1 != null && value2 != null) {
            return subtract(value1, value2, 2, BigDecimal.ROUND_HALF_UP);
        } else {
            return BigDecimal.ZERO;
        }
    }

    public static BigDecimal multiply(BigDecimal value1, BigDecimal value2) {
        if (value1 != null && value2 != null) {
            return multiply(value1, value2, 2, BigDecimal.ROUND_HALF_UP);
        } else {
            return BigDecimal.ZERO;
        }
    }

    public static BigDecimal divide(BigDecimal value1, BigDecimal value2) {
        if (value1 != null && value2 != null) {
            return divide(value1, value2, 2, BigDecimal.ROUND_HALF_UP);
        } else {
            return BigDecimal.ZERO;
        }
    }

    public static boolean compareAGreaterThanB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) == 1;
    }

    public static boolean compareALessThanB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) == -1;
    }

    public static boolean compareAGreaterThanOrEqualToB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) > -1;
    }

    public static boolean compareALessThanOrEqualToB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) < 1;
    }

    public static boolean compareAEqualToB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) == 0;
    }

    public static boolean compareANoEqualToB(BigDecimal a, BigDecimal b) {
        return a.compareTo(b) != 0;
    }

    /**
     * 计算账单部分天数金额：price = billPrice * days / billDays
     *
     * @param price
     * @param days
     * @param billDays
     * @return
     */
    public static BigDecimal computeBillPriceForDays(BigDecimal price, int days, int billDays) {
        BigDecimal t1 = multiply(price, BigDecimal.valueOf(days), 6, BigDecimal.ROUND_HALF_UP);
        return divide(t1, BigDecimal.valueOf(billDays), 2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal mulThenDivBII(BigDecimal price, int num1, int num2) {
        BigDecimal p1 = multiply(price, BigDecimal.valueOf(num1), 6, BigDecimal.ROUND_HALF_UP);
        return divide(p1, BigDecimal.valueOf(num2));
    }

    public static BigDecimal mul(BigDecimal val1, BigDecimal val2, int val3) {
        BigDecimal p1 = multiply(val1, val2, 6, BigDecimal.ROUND_HALF_UP);
        return multiply(p1, BigDecimal.valueOf(val3));
    }

    public static BigDecimal mul_6(BigDecimal val1, BigDecimal val2) {
        return multiply(val1, val2, 6, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal mulThenDiv(BigDecimal value1, BigDecimal value2, int value3) {
        BigDecimal p1 = multiply(value1, value2, 6, BigDecimal.ROUND_HALF_UP);
        return divide(p1, BigDecimal.valueOf(value3));
    }

    public static BigDecimal mulThenDiv6(BigDecimal value1, BigDecimal value2, int value3) {
        BigDecimal p1 = multiply(value1, value2, 6, BigDecimal.ROUND_HALF_UP);
        return divide(p1, BigDecimal.valueOf(value3), 6, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal compute(BigDecimal avg, int monthNum, int extDays, int monthDays) {
        BigDecimal intact = BigDecimalUtil.multiply(avg, BigDecimal.valueOf(monthNum));
        BigDecimal ext = BigDecimal.ZERO;
        if (extDays > 0) {
            ext = BigDecimalUtil.mulThenDivBII(avg, extDays, monthDays);
        }
        return BigDecimalUtil.add(intact, ext);
    }
}
