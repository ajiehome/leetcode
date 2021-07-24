package cn.ajiehome.my;

/**
 * author: huang
 * time: 2021/7/24
 * description:{
 *     动态规划
 *     int[] arr = {3,34,4,12,5,2};
 *     int arrMaxIndex = arr.length() - 1;
 *     int S = 9;
 *     给出一个数组，在这个数组中找到若干个元素相加等于9，如果有满足该种情况的就返回ture，否则false，假定条件，数组中的元素都是正整数，给出的 S 也是正整数
 *     分析：
 *         在数组中的所有元素，都逃不掉一个标准，那就是选择或者不选择
 *         在取 arrMaxIndex 元素的时候，有两种方式，第一种是选取该元素，也就是说在 arrMaxIndex 加上这之前可能出现的组合，相加结果刚好等于给定的 S
 *                                            第二种是舍弃该元素，那么也就是说在arrMaxIndex 之前的元素的某些组合就符合要求，相加结果等于 S
 *         那么按照如此规律往下走，必然有一种骇然规律，就是选择第 n 个数字的时候 发现 S 所需要的结果刚好已经满足，这种情况则可以直接判定成功
 *         还有一种情况就是，当我们取到最后可供选择的数的时候，发现数恰好为欠缺的数，那么这种情况也是符合的，而在这种情况下还没有符合的话说明没有肯再符合了
 *
 *     矩阵分析：*->ture F->false
 *
 *          0   1   2   3   4   5   6   7   8   9   S
 *     3    T   F   F   *   F   F   F   F   F   F
 *     34   T   F   F   *   F   F   F   F   F   F
 *     4    T   F   F   *   *   F   F   *   F   F
 *     12   T   F   F   *   *   F   F   *   F   F
 *     5    T   F   F   *   *   *   F   *   *   *
 *     2    T   F   *   *   *   *   *   *   *   *
 *     arr
 * }
 */

public class DynamicPlanTwo {

    public static boolean solution(int[] arr, int S) {
        boolean[][] opt = new boolean[arr.length][S + 1];
        for (boolean b : opt[0]) b = false;
        for (int i=0;i< arr.length;i++) opt[i][0] =true;
        opt[0][arr[0]] = true;
        for (int i=1;i< arr.length;i++){
            for (int s=1;s<S+1;s++){
                if(arr[i] > s){
                    opt[i][s] = opt[i-1][s];
                }else {
                    boolean a = opt[i-1][s-arr[i]];
                    boolean b = opt[i-1][s];
                    opt[i][s] = a||b;
                }
            }
        }
        return opt[arr.length-1][S];
    }
    public static void main(String[] args) {
        int[] arr = {3,34,4,12,5,2};
        System.out.println(solution(arr, 9));
    }
}
