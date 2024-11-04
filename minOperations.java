import java.util.Arrays;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3191.使二进制数组全部等于一的最小操作次数  中等，贪心+位运算 自己写过
 * @date 2024/10/18 11:58
 *
 */
public class minOperations {
    public static void swap(int[] arr,int k){
        int currency=0;
        while (currency<3){
            if (arr[k+currency]==0){
                arr[k+currency]=1;
                currency++;
            } else if (arr[k+currency]==1) {
                arr[k+currency]=0;
                currency++;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={1,1,1,1};
        if (nums.length==3){
            int tempsum=0;
            for (int i=0;i<nums.length;i++){
                tempsum+=nums[i];
            }
            if (tempsum==3){
                //return 0;
                System.out.println(0);
            } else if (tempsum!=3) {
                //return -1;
                System.out.println(1);
            }
            //return -1;
            //System.out.println("false");
        }
//        }else if (nums.length==4){
//            int position_1=0;
//            int sum_special=0;
//            for (int i=0;i<nums.length;i++){
//                sum_special=sum_special+nums[i];
//                if (sum_special>1&&sum_special!=4){
//                    //return -1;
//                    System.out.println("false");
//                }else if (sum_special==4){
//                    //return 0;
//                    System.out.println("true");
//                }
//                if (nums[i]==1){
//                    position_1=i;
//                }
//            }
//            if (position_1==nums.length-1||position_1==0){
//                //return position_1;
//                System.out.println("true");
//            }
//        }
        //接下来探讨一般的情况

        int last_zero_position=0;
        int numbers=0;
        for (int i=0;i<=(nums.length-3);i++){
            if (nums[i]==0){
                last_zero_position=i;
                swap(nums,i);
                numbers=numbers+1;
            }
        }
        boolean isOK=true;
        for (int i=0;i<(nums.length);i++){
            if (nums[i]==0){
                isOK=false;
                break;
            }
        }
        if (isOK==true){
            //return numbers;
            System.out.println("true");
            System.out.println(numbers);
        }
        //return -1;
        System.out.println("false");
    }
}
