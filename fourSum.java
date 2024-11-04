import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/5/15 11:43
 * @Description 18.四数之和 双指针&朴素模拟 中等
 */
public class fourSum {
    public static void main(String args[]){
        int[] nums={1,0,-1,0,-2,2};
        int target=0;
        Arrays.sort(nums);//-2 -1 0 0 1 2
        List<List<Integer>>returnArray=new LinkedList<>();
//        for (int i=0;i< nums.length;i++){
//            System.out.println(nums[i]);
//        }
        int m=nums.length;
        //判断数组长度小于等于4的情况
        if (m<4){
            System.out.println("不存在");
            //return null;
        } else if (m==4) {
            int temp_lower=0;
            for (int i=0;i<4;i++){
                temp_lower+=nums[i];
            }
            if (temp_lower==target){
                List<Integer>found=new LinkedList<>();
                for (int i=0;i<4;i++){
                    found.add(nums[i]);
                }
                returnArray.add(found);
            }
            System.out.println("存在！");
            //return returnArray;
        }
        //判断一般情况
        int round=0;
        for (round=0;round<=(m-4);round++){
            int i=0;
            int j=m-1;
            List<Integer>foundNormal=new LinkedList<>();
            while (i<j){
                int sum1=nums[i]+nums[j];

            }
        }
    }
}
