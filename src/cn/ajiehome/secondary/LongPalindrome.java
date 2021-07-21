package cn.ajiehome.secondary;

/**
 * author: huang
 * time: 2021/7/17
 * description:{
 * 最长回文子串
 * }
 */

public class LongPalindrome {
    public static String solution(String s) {
        int[] temp = new int[]{0, 0};
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length-1; i++) {
            // 接邻调用
            int[] index = recursion(charArray, i, i + 1);
            if((index[1]-index[0] > temp[1]-temp[0])){
                temp = index;
            }
            if(i<charArray.length-2){
                // 跨界调用
                int[] index1 = recursion(charArray, i, i + 2);
                if((index1[1]-index1[0] > temp[1]-temp[0])){
                    temp = index1;
                }
            }
        }
        return s.substring(temp[0], temp[1] + 1);
    }

    public static int[] recursion(char[] charArray, int indexStart,int indexEnd) {
        if(indexStart==-1||indexEnd==charArray.length||charArray[indexStart]!=charArray[indexEnd]){
            return new int[]{indexStart+1,indexEnd-1};
        }else {
            return recursion(charArray,indexStart-1 ,indexEnd+1);
        }
    }

}
