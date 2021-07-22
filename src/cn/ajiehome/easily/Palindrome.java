package cn.ajiehome.easily;

/**
 * author: huang
 * time: 2021/7/22
 * description:{
 *     回文串判断
 * }
 */

public class Palindrome {

    public static boolean solution(int x){
        int temp = 0;
        int tempX = x;
        if (x<0||x%10==0&&x!=0){
            return false;
        }
        while (x!=0){
            temp = temp*10+ x%10;
            x = x / 10;
        }
        System.out.println(temp);
        return temp==tempX;
    }
}
