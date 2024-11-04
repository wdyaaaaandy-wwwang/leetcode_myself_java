import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/6/7 11:24
 * @Description 3158.求出出现两次数字的XOR值   简单
 */
public class duplicateNumbersXOR {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int res=0;
        for(int a:count.keySet()){
            if (count.get(a)==2){
                res ^= a;
            }
        }
        System.out.println(res);
    }
}
