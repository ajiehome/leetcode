package cn.ajiehome.easily;

import java.util.HashMap;

/**
 * author: huang
 * time: 2021/7/29
 * description:{
 * 罗马转整数
 * }
 */

public class RomeToInt {



    public static int solution(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>() {
            {put('M',1000);put('D',500);put('C',100);put('L',50);put('X',10);put('V',5);put('I',1);}
        };
        int index = 0,result=0;
        while (index<s.length()){
            // char current = s.charAt(index);
            // char next = index<s.length()-1?s.charAt(index+1):'N';
            // index++;
            // if (current=='I'&&(next=='V'||next=='X')){ result -= map.get(current); continue;}
            // if (current=='X'&&(next=='L'||next=='C')){ result -= map.get(current); continue;}
            // if (current=='C'&&(next=='D'||next=='M')){ result -= map.get(current); continue;}
            // result+= map.get(current);

            if (index<s.length()-1&&map.get(s.charAt(index))<map.get(s.charAt(index+1)))
                result-=map.get(s.charAt(index));
            else
                result+=map.get(s.charAt(index));
            index++;
        }
        return result;
    }
}
