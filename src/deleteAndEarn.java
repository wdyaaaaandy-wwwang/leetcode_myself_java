import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andy Wang
 * @version
 * @date 2024/6/3 13:59
 * @Description 740.删除并获得点数  动态规划 中等（自己没写出来，看官方教程才知道本质是动态规划的打家劫舍翻版）
 * 题目描述：给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * -------------------------------------------
 * 输入示例1：
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * -------------------------------------------
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * -------------------------------------------
 * 官方解法：原理类似打家劫舍那道题，标准的动态规划
 * 根据题意，在选择了元素 xxx 后，该元素以及所有等于 x−1x-1x−1 或 x+1x+1x+1 的元素会从数组中删去。若还有多个值为 xxx 的元素，由于所有等于 x−1x-1x−1 或 x+1x+1x+1 的元素已经被删除，我们可以直接删除 xxx 并获得其点数。因此若选择了 xxx，所有等于 xxx 的元素也应一同被选择，以尽可能多地获得点数。
 */
public class deleteAndEarn {
    public static int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
    public static void main(String args[]){
        int[] nums={2,2,3,3,3,4};
        int res=0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int m= nums.length;
//        List<Integer>originList=new LinkedList<>();
//        int[] numsNumber=new int[m];
//        int current=nums[0];
//        for (int i=0;i<m;i++){
//            numsNumber[nums[i]]+=1;
//        }
//        for (int i=1;i<m;i++){
//            if (current==nums[i]){
//                continue;
//            }
//
//        }
//        HashMap<Integer,Integer>hashMap=new HashMap<>();
//        for (int i=0;i<m;i++){
//            numsNumber[nums[i]-1]+=1;
//            originList.add(nums[i]);
//            if (hashMap.containsKey(nums[i])) {
//                hashMap.put(nums[i], hashMap.get(nums[i] + 1));
//            }else {
//                hashMap.put(nums[i],1);
//            }
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        //return rob(sum);
        System.out.println(rob(sum));
    }
}
