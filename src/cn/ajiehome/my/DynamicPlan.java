package cn.ajiehome.my;

/**
 * author: huang
 * time: 2021/7/24
 * description:{
 *     动态规划
 *
 *     int[] arr = [1,2,4,1,7,8,3]
 *     int arrLength = arr.length()
 *     给出一个数组，求取中间和最大的值，且求和过程中不能选取相邻位数，如选择arr[i]就不能选择arr[i+1]与arr[i-1];
 *     分析：
 *         这取决于两个过程，选择与不选择的过程，如果我们选择了arr[0]，那么就只能拿到arr[0]的值之后 + arr[4]选择与不选择的最大值
 *         以此推导下去，那么我们能够得出一个最有解决的结果集opt[],而opt[arrLength-1] 的结果为选择下表为arrLength-1和不选择arrLength-1与本身的最大结果集
 *         那么我们想要求出arr中的最大结果，那么我们就要先求出arr-1的结果，再进行比对
 *
 * }
 */

public class DynamicPlan {
    public static int solution(int[] arr){
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[1],arr[0]);

        for (int i = 2; i < arr.length; i++) {
            int a = opt[i-1];
            int b = arr[i] + opt[i-2];
            opt[i] = Math.max(a,b);
        }
        return opt[arr.length-1];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,1,7,8,3};
        System.out.println(solution(arr));
    }
}
