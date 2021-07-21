package cn.ajiehome.secondary;

import java.util.HashMap;

/**
 * author: huang
 * time: 2021/7/15
 * description:{
 * 寻找最长字串
 * }
 */

public class LongString {
    public static Integer solution(String s) {
        int index1 = 0;
        int temp = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Integer index = map.put(chars[i], i);
            if (index != null) {
                if (temp < map.size()) {
                    temp = map.size();
                }
                for (int j = index1; j < index; j++) {
                    map.remove(chars[j]);
                }
                index1 = index + 1;
            }
        }
        if (temp < map.size()) {
            temp = map.size();
        }
        return temp;
    }

    public static Integer solution2(String s) {
        int[] position = new int[128];
        for (int i = 0; i < position.length; i++) {
            position[i]=-1;
        }
        int start = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (position[c] != -1) {
                start = position[c] + 1>start?position[c]+1:start ;
            }
            position[c] = i;
            int len = i - start + 1;
            length = len>length?len:length;
        }
        return length;
    }

}
