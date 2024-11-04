/**
 * @author Andy_Wang
 * @version
 * @description: 633 平方数之和 中等 二分查找 双指针
 * @date 2024/11/4 10:28
 * 看了答案 发现自己想歪了 其实是会做的 也算过了 加油加油！！！
 */
public class judgeSquareSum {
    public static boolean isOk(int c){
        long sqrt = (long)Math.sqrt(c);
        return (sqrt * sqrt == c);
    }
    public static boolean judgeSquareSum(int c) {
        if (isOk(c)){
            return true;
        }
        double sqrt = Math.sqrt(c);
        int sqrt_int = (int) sqrt;
        if (sqrt_int * sqrt_int < c) {
            sqrt_int=sqrt_int+1;
        }
        int i=1;
        int res=0;
        while (i<sqrt_int) {
            res=res+(i*i);
            i=i+1;
            if (res==c){
                return true;
            }
        }
        return false;
    }
    public static boolean officialSolution(int c){
        long left=0;
        long right=(long)Math.sqrt(c);
        while (left<=right){
            long mid=left*left+right*right;
            if (mid==c){
                return true;
            } else if (mid>c) {
                right=right-1;
            } else if (mid<c) {
                left=left+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int selec2=5;
        int select=3;
        int partion=4;
//        System.out.println(judgeSquareSum(partion));
//        System.out.println(judgeSquareSum(select));
//        System.out.println(judgeSquareSum(selec2));
        System.out.println(officialSolution(2));
    }
}
