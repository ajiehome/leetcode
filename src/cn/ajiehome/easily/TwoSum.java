package cn.ajiehome.easily;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: JIE
 * @Date: 2021/6/22 10:12
 * @Version: 1.0
 * @Description: {
 *      计算两数之和，在一个数组中快速找到两个符合条件的两数，两数的结果要等于给定的和
 * }
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            result[0] = i;
            if (hashMap.get(target - nums[i]) != null && hashMap.get(target - nums[i]) != i) {
                result[1] = hashMap.get(target - nums[i]);
                break;
            } else
                result.clone();
        }
        return result;
    }
}
