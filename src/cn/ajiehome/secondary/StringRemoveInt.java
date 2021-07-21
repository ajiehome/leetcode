package cn.ajiehome.secondary;

/**
 * author: huang
 * time: 2021/7/21
 * description:{
 *     字符串转换整数
 * }
 */

public class StringRemoveInt {

    public static int solution(String s){
        char[] charArray = s.toCharArray();
        long result = 0;
        int multiple = 0;

        for (char c : charArray) {
            if(multiple==0&&c==' ') continue;
            if(multiple==0&&c=='-'){ multiple = -1;continue; }
            if(multiple==0&&c=='+'){ multiple = 1;continue; }
            if (c>='0'&&c<='9'){
                if (multiple==0) multiple = 1;
                result = result*10 + ((int)c-48)*multiple;
                if(result>Integer.MAX_VALUE) {result = Integer.MAX_VALUE;break;}
                if(result<Integer.MIN_VALUE) {result = Integer.MIN_VALUE;break;}
            }else break;
        }
        return (int) result;
    }


    // public static int solution(String s){
    //     s=s.trim();
    //     String regular = "^(-?[0-9]+)";
    //     Pattern pattern = Pattern.compile(regular);
    //     Matcher matcher = pattern.matcher(s);
    //     long result = 0;
    //     while (matcher.find()){
    //         String group = matcher.group();
    //         result = Long.parseLong(group);
    //     }
    //     if (result < Integer.MIN_VALUE)  result = Integer.MIN_VALUE;
    //     if (result > Integer.MAX_VALUE)  result = Integer.MAX_VALUE;
    //     return (int) result;
    // }
}
