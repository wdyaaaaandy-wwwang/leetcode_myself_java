/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/6/12 15:39
 * @Description 2834.找出美丽数组的最小和   中等 贪心     知道是贪心，但是没写出来，最后看的答案
 * 方法一：贪心
 * 思路与算法
 *
 * 根据题意，我们需要构造一个大小为 nnn 的正整数数组，该数组由不同的数字组成，并且没有任意两个数字的和等于 target，在满足这样的前提下，要保证数组的和最小。
 *
 * 为了让数组之和最小，我们按照 1,2,3,⋯1,2,3,\cdots1,2,3,⋯ 的顺序考虑，但添加了 xxx 之后，就不能添加 target−x，因此最大可以添加到 ⌊target/2⌋，如果个数还不够 nnn 个，就继续从 target,target+1,target+2,⋯ 依次添加。由于添加的数字是连续的，所以可以用等差数列求和公式快速求解。
 *
 */
public class minimumPossibleSum {
    public static void main(String[] agrs){
        int n=2;
        int target=3;
        int res=0;
        final int MOD = (int) 1e9 + 7;
        int m=target/2;
        if (n<=m){
            res=(int) ((long)(1+n)*n/2%MOD);
        }else {
            res=(int) (((long) (1 + m) * m / 2 + ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
        }
        //return res;
        System.out.println(res);
    }
}
