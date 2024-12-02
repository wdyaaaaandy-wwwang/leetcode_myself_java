import java.util.Arrays;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 238. 除自身以外数组的乘积  中等 数组 前缀和    自己写出了官方解答1，但是空间复杂度还不是O（1）
 * @date 2024/12/2 16:34
 */
public class productExceptSelf {
    //官方题解
    public static int[] productExceptSelf_official(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre= new int[nums.length];
        int[] back= new int[nums.length];
        //先遍历pre数组
        int i=1;
        pre[0]=1;
        while(i<nums.length){
            pre[i]=nums[i-1]*pre[i-1];
            i=i+1;
        }
        //再遍历back数组
        int j=nums.length-2;
        back[nums.length-1]=1;
        while (j>=0){
            back[j]=nums[j+1]*back[j+1];
            j=j-1;
        }
        for (int point=0;point<nums.length;point++){
            res[point]=pre[point]*back[point];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] nums2={-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf(nums2)));
    }
}
