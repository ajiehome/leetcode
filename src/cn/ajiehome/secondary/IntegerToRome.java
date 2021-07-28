package cn.ajiehome.secondary;

/**
 * author: huang
 * time: 2021/7/28
 * description:{
 * 整数转罗马数
 *     给定条件：
 *         I    IV  V   IX  X   XL   L  XC   C      CD   D      CM  M
 *         1    4   5   9   10  40   50 90   100    400  500    900 1000
 * }
 */
public class IntegerToRome {
    public static String solution(int num) {
        int[] intList = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romeList = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder builder = new StringBuilder();

        while (num>0){
            for (int i = 0; i < intList.length; i++) {
                if (num>=intList[i]){
                    builder.append(romeList[i]);
                    num -= intList[i];
                    break;
                }
            }
        }
        return builder.toString();
    }
}
