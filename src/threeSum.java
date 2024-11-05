import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/5/17 8:58
 * @Description 15.三数之和 中等 双指针 朴素模拟
 */

public class threeSum {
    public static void main(String args[]){
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>>returnArray=new LinkedList<>();
        Arrays.sort(nums);
        int first=0;
        for (first=0;first<nums.length;first++){
            if (nums[first]==nums[first+1]){
                continue;
            }
            int second=first+1;
            int third= nums.length-1;
            int target=-nums[first];
            List<Integer>temp=new LinkedList<>();
            while (second<third){
                if (nums[second]==nums[second+1]){
                    second++;
                }
                if (nums[second]+nums[first]+nums[third]==0){
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    returnArray.add(temp);
                } else if (nums[second]+nums[third]<target) {
                    second+=1;
                } else if (nums[second]+nums[third]>target) {
                    third-=1;
                }
            }
        }
        System.out.println("we have found the answers!");
    }
}
