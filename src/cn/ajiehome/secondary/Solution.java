package cn.ajiehome.secondary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: JIE
 * @Date: 2021/6/22 11:04
 * @Version: 1.0
 * @Description: {
 *     使用的是回溯发，具体见下注解
 * }
 */
public class Solution {
    List<String> rec;
    boolean[] vis; // 存储使用过了的字符的下表
    public String[] permutation(String s) {
        int n = s.length(); // 获得字符串的长度
        rec = new ArrayList<String>(); // 创建
        vis = new boolean[n]; // 创建
        char[] arr = s.toCharArray(); // 把字符串切割成字符数组
        Arrays.sort(arr); // 字符数组排序
        StringBuffer perm = new StringBuffer(); // 可变字符对象
        backtrack(arr, 0, n, perm); // 取得一个合法字符串
        int size = rec.size(); // 最终结果长度
        String[] recArr = new String[size]; // 创建一个等长的字符数组
        for (int i = 0; i < size; i++) {
            recArr[i] = rec.get(i); // 把最终结果的List集合转为一个数组
        }
        return recArr;
    }

    // 指定字符   索引0    字符长度  可变字符串对象
    public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
        // 递归出口，作为字符排列完成，存入指定集合
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        // 遍历字符长度
        for (int j = 0; j < n; j++) {
            // 字符默认都是false，如果为true说明已经用过了，如果前一个没有用过，并且前一个等于后一个，那么跳出这层循环
            if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                continue;
            }
            vis[j] = true; // 设置当前字符用过状态
            perm.append(arr[j]); // 把当前字符叠加
            backtrack(arr, i + 1, n, perm); // 进行下一个字符选择
            perm.deleteCharAt(perm.length() - 1); // 字符使用完毕，把可变字符一层层清空
            vis[j] = false; // 解除使用了的状态
        }
    }
}
