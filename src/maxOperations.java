/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/6/7 10:26
 * @Description 3038.相同分数的最大操作数目 Ⅰ  简单   每日一题   自己写的（已通过！）
 */

public class maxOperations {
    public static void main(String[] agrs){
        int[] nums={3,2,6,1,4};
        int m=nums.length;
        int res=1;
        if (m<=2){
            if (m==2){
                //return 1;
                System.out.println("1");
            }
            //return 0;
            System.out.println("0");
        }
        int i=2;
        int j=3;
        int currentSum=nums[0]+nums[1];
        while (i<m&&j<m){
            int tempI=nums[i];
            int tempJ=nums[j];
            int tempSum=tempI+tempJ;
            if (tempSum==currentSum){
                res+=1;
                i=i+2;
                j=j+2;
            }else {
                break;
            }
        }
        //return res;
        System.out.println(res);
    }
}
