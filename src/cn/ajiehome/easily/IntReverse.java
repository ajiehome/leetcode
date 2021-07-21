package cn.ajiehome.easily;

/**
 * author: huang
 * time: 2021/7/20
 * description:{
 * 整数反转：给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。反转之后大于Int最大追或者小于最小值的都返回0
 * }
 */

public class IntReverse {
    public static int solution(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (int) result == result ? (int) result : 0;
    }
}