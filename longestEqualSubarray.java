import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/5/24 9:07
 * @Description 2831.找出最长等值子数组（中等）
 */
public class longestEqualSubarray {
    public static Integer findMaxValueInHash(HashMap<Integer, Integer> hashMap) {
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getValue();
    }

    public static void main(String args[]){
        int[] nums={1,3,2,3,1,3};
        int k=3;
        int[] tempNums=nums;
        Arrays.sort(tempNums);
        System.out.println(Arrays.toString(tempNums));//[1, 1, 2, 3, 3, 3]
        HashMap<Integer,Integer>hashMap=new HashMap<>();
        int m= nums.length;
        for (int i=0;i<m;i++){
            if (hashMap.containsKey(nums[i])){
                int temp= hashMap.get(nums[i])+1;
                hashMap.put(nums[i],temp);
            }else {
                hashMap.put(nums[i],1);
            }
        }
//        return findMaxValueInHash(hashMap);
        System.out.println(findMaxValueInHash(hashMap));
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));//[1, 1, 2, 3, 3, 3]

    }
}
