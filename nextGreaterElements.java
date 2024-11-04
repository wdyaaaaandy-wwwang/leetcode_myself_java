import java.util.Arrays;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/6/25 9:01
 * @Description 503.下一个更大元素Ⅱ 中等
 * 题目描述：给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * ----------------------------------------------------------------------------------------------------------------------
 * 示例：
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * ----------------------------------------------------------------------------------------------------------------------
 * 示例：
 * 示例 2:
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 */
public class nextGreaterElements {
    public static void main(String[] args){
        int[] nums={1,2,1};
        int m=nums.length;
        int[] res=new int[m];
        int max=nums[0];
        int max_position=0;
        int temp=nums[0];
        boolean isOver=false;
        int i=1;
        for (int j=0;j<m;j++){
            if (max<=nums[j]){
                max=nums[j];
                max_position=j;
            }
        }

//        while (!isOver){
//            if (i>=1&&i<=(m-1)){
//                if (max<=nums[i]){
//                    max=nums[i];
//                    max_position=i;
//                    temp=nums[i];
//                    res[i-1]=temp;
//                    i+=1;
//                } else if (max>nums[i]) {
//
//                }
//            }
//        }
        res[max_position]=-1;
        //return res;
        System.out.println(Arrays.toString(res));
    }
}
