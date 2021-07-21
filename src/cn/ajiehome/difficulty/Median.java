package cn.ajiehome.difficulty;

/**
 * author: huang
 * time: 2021/7/16
 * description:{
 * 寻找两个正序数组的中位数
 * }
 */

public class Median {

    public static Double solution(int[] array1, int[] array2) {
        int index1 = 0, index2 = 0, index = 0;
        int length1 = array1.length, length2 = array2.length;
        int[] result = new int[length1 + length2];

        while (index1 < length1 || index2 < length2) {


            if (index1 == length1 || index2 == length2) {
                result[index++] = index1 == length1 ? array2[index2++] : array1[index1++];
                continue;
            }

            int temp1 = index1 == length1 ? null : array1[index1];
            int temp2 = index2 == length2 ? null : array2[index2];

            if (temp1 < temp2) {
                result[index++] = temp1;
                index1++;
            }
            if (temp1 == temp2) {
                result[index++] = temp1;
                result[index++] = temp2;
                index1++;
                index2++;
            }
            if (temp1 > temp2) {
                result[index++] = temp2;
                index2++;
            }
        }

        if ((length1 + length2) % 2 == 0) {
            return (result[(length1 + length2) / 2] + result[(length1 + length2) / 2 - 1] ) / 2d;
        }

        return result[(length1 + length2) / 2] * 1d;
    }
}
