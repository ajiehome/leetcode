package cn.ajiehome.secondary;

/**
 * author: huang
 * time: 2021/7/19
 * description:{
 *     Z字形变换，将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * }
 */

public class ZShapePrint {
    public static String solution(String s, int numRows){

        if (numRows==1){
            return s;
        }

        StringBuilder[] arrayBuilder = new StringBuilder[Math.min(numRows,s.length())];
        for (int i = 0; i < arrayBuilder.length; i++) {
            arrayBuilder[i] = new StringBuilder();
        }
        int index = 0;
        int rowsIndex = 0;

        recursion(arrayBuilder,index,rowsIndex,s.toCharArray(),numRows,false);

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder builder : arrayBuilder) {
           stringBuilder.append(builder);
        }
        return stringBuilder.toString();
    }

    public static void recursion(StringBuilder[] arrayBuilder,int index, int rowsIndex,char[] str,int nowRoes,boolean status){
        if (index==str.length){
            // 出口
        }else {
            if (rowsIndex==0||rowsIndex==(nowRoes-1)){
                status=!status;
            }
            arrayBuilder[rowsIndex].append(str[index++]);
            rowsIndex+=status?1:-1;
            recursion(arrayBuilder,index,rowsIndex,str,nowRoes,status);
        }
    }
}
