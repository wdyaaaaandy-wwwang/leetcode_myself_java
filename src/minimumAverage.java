import java.util.Arrays;
import java.util.HashSet;


public class minimumAverage {
    public static void main(String[] args) {
        double[] nums={1,9,8,3,10,5};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int i=0;
        int j=nums.length-1;
        double result=(nums[i]+nums[j])/2;
        while (i<j){
            double temp=(nums[i]+nums[j])/2;
            if (result>temp){
                result=temp;
            }
            i=i+1;
            j=j-1;
        }
        //return result;
        System.out.println(result);
    }
}
