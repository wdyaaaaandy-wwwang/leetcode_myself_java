import java.util.Arrays;

public class numberOfPairs {
    public static void main(String[] args) {
//        int[] nums1={1,3,4};
//        int[] nums2={1,3,4};
        int[] nums1={1,2,4,12};
        int[] nums2={2,4};
        int k=3;
        int n=nums1.length;
        int m=nums2.length;
        long result=0;
        if (k<=0||nums2.length<=0||nums1.length<=0){
            //return 0;
            System.out.println("error");
        }
        Arrays.sort(nums2);
        Arrays.sort(nums1);
        int i=n-1;
        int j=0;
        for (i=n-1;i>=0;i--){
            if (nums1[i]<nums2[j]){
                continue;
            } else {
                while (j>=0&&j<=(m-1)){
                    if (nums1[i]%(nums2[j]*k)==0){
                        result++;
                        j=j+1;
                    }else {
                        j=j+1;
                    }
                }
                j=0;
            }
        }
        //return result;
        System.out.println(result);
    }
}
