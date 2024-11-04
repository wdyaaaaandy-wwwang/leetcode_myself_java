import java.util.Arrays;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 910.最小差值 Ⅱ 中等
 * @date 2024/10/21 11:20
 */
public class smallestRangeII {
    public static void main(String[] args) {
        int[] nums={2,7,2};
        int k=1;
        if (nums.length<=2){
            if (nums.length==1){
                //return 0;
                System.out.println(0);
            }else {
                Arrays.sort(nums);
                //return nums[1]-nums[0];
                System.out.println(nums[1]-k-nums[0]-k);
            }
        }
        Arrays.sort(nums);
        int compare1=nums[1]-k-nums[0]-k;
        int compare2=nums[nums.length-1]-k-nums[nums.length-2]-k;
//        if (compare1>compare2&&compare2>=0&&compare1>=0){
//            System.out.println(compare2);
//        } else if (compare1>compare2&&compare2<0&&compare1>0) {
//            System.out.println(compare1);
//        } else if (compare2>compare1&&compare1>=0&&compare2>=0) {
//            System.out.println(compare1);
//        } else if (compare2>compare1&&compare2>=0&&compare1<0) {
//            System.out.println(compare1);
//        }
        //System.out.println(Math.min((nums[1]-k-nums[0]-k),nums[nums.length-1]-k-nums[nums.length-2]-k));
        System.out.println(Math.min(Math.abs(compare1),Math.abs(compare2)));
    }
}
