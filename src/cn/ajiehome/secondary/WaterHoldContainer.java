package cn.ajiehome.secondary;

/**
 * author: huang
 * time: 2021/7/25
 * description:{
 *     盛最多水的容器：
 *         给予一个数组，找出数组中两个数能组成的最大水容量。
 * }
 */

public class WaterHoldContainer {
    public static int solution(int[] height){
        int startIndex = 0,endIndex = height.length -1,temp = 0;
        while(startIndex!=endIndex){
            int h = Math.min(height[startIndex], height[endIndex]);
            temp = Math.max((endIndex - startIndex) * h, temp);
            if (height[startIndex] > height[endIndex]) endIndex--;
            else startIndex++;
        }
        return temp;
    }
}
