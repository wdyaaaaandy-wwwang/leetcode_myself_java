/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/6/3 15:16
 * @Description 198.打家劫舍 动态规划 中等(第一遍有错误，但已通过查看官方题解自己改正通过)
 * 题目描述：你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * ---------------------------------------------
 * 输入示例1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * ---------------------------------------------
 * 输入示例2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */

public class rob {
    public static void main(String args[]){
        int[] nums={2,1,1,2};
        int res=0;
        int m= nums.length;
        if (m==1){
            System.out.println(nums[0]);
            //return nums[0];
        }
        if (m==2){
            System.out.println(Math.max(nums[0],nums[1]));
            //return Math.max(nums[0],nums[1]);
        }
        int[] hp=new int[m];
        hp[0]=nums[0];
//        hp[1]=nums[1];
        hp[1]=Math.max(nums[0], nums[1]);
//        res=Math.max(hp[0],hp[1]);
        for (int i=2;i<m;i++){
            hp[i]=Math.max(hp[i-1], hp[i-2]+nums[i]);
//            if (res>=(hp[i-2]+nums[i])){
//                hp[i]=res;
//            }else {
//                hp[i]=hp[i-2]+nums[i];
//                res=hp[i];
//            }
        }
        //return res;
        System.out.println(hp[m-1]);
    }
}
