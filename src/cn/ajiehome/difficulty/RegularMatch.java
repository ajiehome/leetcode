package cn.ajiehome.difficulty;

/**
 * author: huang
 * time: 2021/7/23
 * description:{
 *      正则匹配    动态规划
 *      s->字符串  p->正则串
 *      分析：
 *          当前的regular是字符的情况下存在两种状况
 *              f[i][j] = f[i-1][j-1],  s[i]==p[j]
 *              f[i][j] = false,        s[i]!=p[j]
 *          当前的regular是 * 的情况下存在两种状况
 *              f[i][j] = f[i-1][j] || f[i][j-1],   s[i]==p[j-1]
 *                  由于s[i]==p[j]成立了，那么决定当前的匹配能不能成功取决于前面的字符是否匹配
 *                  而这是也存在两种情况
 *                      第一种：前面的字符也是 * 之前的字符，所以有f[i-1][j]
 *                      第二种：前面的字符不匹配了，那么我们只能丢弃当前的regular组合，去看前面的字符匹配是否成立
 *
 *              f[i][j] = f[i][j-2]                 s[i]!=p[j-1]
 *
 *      总结：
 *          动态规划存在一个特性，就是当前的状态，受前一种状态的影响，
 *          而使用好动态规划就要找好这个状态特性，做好动态转移的公式
 *
 * }
 */

public class RegularMatch {

    public static boolean solution(String s, String p) {

        int m = s.length(),n=p.length();
        boolean[][] result = new boolean[m+1][n+1];
        result[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j-1)=='*'){
                    result[i][j] = result[i][j-2];
                    if (matches(s,p,i,j-2)){
                        // 当两个字符匹配成功后，我们需要一次往下衍生匹配，如果这个字符不能匹配的时候，需要赋予前面字符的状态
                        // 而 result[i][j] = result[i][j-2]
                        // 需要看 result[i][j-2] 的原因是当我们的所有匹配完了之后，丢弃该字符，一定会遇到无法丢弃字符，就只能丢弃本身的组合了
                        result[i][j] = result[i-1][j]||result[i][j];
                    }
                }else {
                    if (matches(s,p,i,j-1)) result[i][j] = result[i-1][j-1];
                }
            }
        }
        return result[m][n];
    }

    public static boolean matches(String s,String p, int i,int j){
        if (i==0) return false;
        if (p.charAt(j)=='.')  return true;
        return s.charAt(i-1) == p.charAt(j);
    }
}
