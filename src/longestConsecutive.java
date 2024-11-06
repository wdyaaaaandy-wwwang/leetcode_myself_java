import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 128. 最长连续序列  中等 数组 并查集 哈希表
 * 自己写出来了！恭喜我自己！！！
 * @date 2024/11/5 18:12
 */
public class longestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //数组去重
        HashSet<Integer> set = new LinkedHashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        // 将 LinkedHashSet 转换回数组
        nums = new int[set.size()];
        int index = 0;
        for (int num : set) {
            nums[index++] = num;
        }
        //数组重新排序
        Arrays.sort(nums);
        int i=0;
        int j=1;
        int res=1;
        int tempmax=1;
        while(j<nums.length&&i<nums.length){
            if(nums[j]-nums[i]==1){
                i=i+1;
                j=j+1;
                tempmax=tempmax+1;
                if (tempmax>=res){
                    res=tempmax;
                }
            }else {
                tempmax=1;
                i=i+1;
                j=j+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arrays={100,4,200,1,3,2};
        int[] test1={0,3,7,2,5,8,4,6,0,1};
        int[] test2={1,2,0,1};
        System.out.println(longestConsecutive(arrays));
        System.out.println(longestConsecutive(test1));
        System.out.println(longestConsecutive(test2));
    }
}
