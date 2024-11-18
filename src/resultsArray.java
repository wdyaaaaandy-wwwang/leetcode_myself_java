import java.util.Arrays;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3254. 长度为 K 的子数组的能量值 I  中等 数组 滑动窗口   这个是自己写出来的！！！
 * 3255. 长度为 K 的子数组的能量值 Ⅱ  昨天方法可以沿用，但是遇到了特别大的数组最后超时了
 * resultsArray_official函数是官方题解
 * 本题与 「3254. 长度为 K 的子数组的能量值 I」同样的问题，根据题意可知，由于子数组如果满足连续上升，此时相邻元素的差值一定为 1，此时我们在遍历数组的同时，用一个计数器 cnt 统计以当前索引 i 为结尾时连续上升的元素个数，初始化 cnt=0，此时：
 *
 * 如果满足 i=0 或者 nums[i]−nums[i−1]=1 时，此时 cnt=cnt+1，即在 nums[i−1] 末尾可以追加元素 nums[i] 仍然满足连续上升；
 *
 * nums[i]−nums[i−1]
 * =1 时，此时 cnt 重新置为 1，即在 nums[i−1] 末尾无法追加 nums[i]；
 *
 * 在计算的同时，此时如果以 nums[i] 为结尾的连续上升的元素数组如果大于等于 k，则当前一定存在长度为 k 且以 nums[i] 为结尾的连续上升的子数组，此时能量值即为 nums[i]；如果不满足，则无法构成长度为 k 且连续上升的子数组，则当前能量值为 −1，返回最终统计的能量值即可。
 * @date 2024/11/6 10:56
 */
public class resultsArray {
    public static int[] resultsArray_official(int[] nums,int k){
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt = i == 0 || nums[i] - nums[i - 1] != 1 ? 1 : cnt + 1;
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }
    public static int[] resultsArray_two(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n-k+1];
        if (k>n){
            return res;
        }
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
        System.out.println("------------------------------------------");
        System.out.println(Arrays.toString(resultsArray_two(nums1,k1)));
        System.out.println(Arrays.toString(resultsArray_two(nums2,k2)));
    }
}
