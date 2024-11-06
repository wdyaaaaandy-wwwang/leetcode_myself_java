import java.util.Arrays;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3254. 长度为 K 的子数组的能量值 I  中等 数组 滑动窗口   这个是自己写出来的！！！
 * @date 2024/11/6 10:56
 */
public class resultsArray {
    public static int[] resultsArray_one(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int i=0;
        while (i<=(n-k)){
            int j=i;
            boolean flag = true;
            while (j<i+k-1){
                int temp1=nums[j];
                int temp2=nums[j+1];
                if (temp2>temp1&&temp2==(temp1+1)){
                    j=j+1;
                }else {
                    flag=false;
                    break;
                }
            }
            if (flag){
                res[i]=nums[j];
            }else {
                res[i]=-1;
            }
            i=i+1;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums1={1,2,3,4,3,2,5};
        int[] nums2={2,2,2,2,2};
        int[] nums3={1,3,4};
        int[] nums4={3,2,3,2,3,2};
        int k1=3;
        int k2=4;
        int k3=2;
        int k4=2;
        System.out.println(Arrays.toString(resultsArray_one(nums1,k1)));
        System.out.println(Arrays.toString(resultsArray_one(nums2,k2)));
        System.out.println(Arrays.toString(resultsArray_one(nums3,k3)));
        System.out.println(Arrays.toString(resultsArray_one(nums4,k4)));
    }
}
