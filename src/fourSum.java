import java.util.*;

/**
 * @author Andy Wang
 * @version
 * @date 2024/5/15 11:43
 * @Description 18.四数之和 双指针&朴素模拟 中等
 */
public class fourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = false;
        }
        Arrays.sort(nums);
        HashMap<Integer,List<List<Integer>>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if(hashMap.containsKey(sum)){
                    List<List<Integer>> list_current = hashMap.get(sum);
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list_current.add(list);
                }else {
                    List<List<Integer>> list_current = new LinkedList<>();
                    list_current.add(Arrays.asList(nums[i],nums[j]));
                    hashMap.put(sum,list_current);
                }
            }
        }

        return res;
    }
    public static void main(String args[]){
        int[] nums={1,0,-1,0,-2,2};
        int target=0;
        Arrays.sort(nums);//-2 -1 0 0 1 2
    }
}
