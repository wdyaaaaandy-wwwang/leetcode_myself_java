import java.util.HashMap;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 560. 和为 K 的子数组   中等  哈希 数组  前缀和
 * 自己写出来了暴力算法，但是前缀和+哈希表的方法不会
 * @date 2024/11/6 18:45
 */
public class subarraySum {
    //官方题解：利用前缀和跟哈希表，空间复杂度O(n)
    public int subarraySum_official(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    //暴力算法 自己写的
    public static int subarraySum(int[] nums, int k) {
        int res=0;
        int temp=0;
        for (int i = 0; i < nums.length; i++) {
            temp=nums[i];
            if (temp==k) res++;
            //列举1到n的和是否为目标值
            for (int j = i+1; j < nums.length; j++) {
                temp=temp+nums[j];
                if (temp==k) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int k1=3;
        int[] nums1 = new int[]{1,1,1};
        int k2=2;
        System.out.println(subarraySum(nums,k1));
        System.out.println(subarraySum(nums1,k2));
    }
}
