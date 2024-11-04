import java.util.Arrays;


/**
 * @author Andy_Wang
 * @version 1.0
 * @description: TODO
 * @date 2024/10/25 10:34
 */
public class maxTotalReward {
    public static int maxTotalReward(int[] rewardValues) {
        if (rewardValues.length == 0) return 0;
        if (rewardValues.length == 1) return rewardValues[0];
        if (rewardValues.length == 2){
            if (rewardValues[0]!=rewardValues[1]) {return rewardValues[0]+rewardValues[1];}
            else {return rewardValues[0];}
        }
        //数组长度为3及以上
        int res=0;
        Arrays.sort(rewardValues);
        int[] dp = new int[rewardValues.length];
        if (rewardValues[0]!=rewardValues[1]) {
            dp[0]=rewardValues[0];
            dp[1]=rewardValues[1]>dp[0]?dp[0]+rewardValues[1]:rewardValues[1];
        }else {
            dp[0]=rewardValues[0];
            dp[1]=rewardValues[1];
        }

        for(int i=2;i<rewardValues.length-1;i++){
            int j=0;
            int temp=0;
            while (j<i&&(temp+dp[j])<rewardValues[i]){
                temp=temp+dp[j];
                j=j+1;
            }
            temp=temp+rewardValues[i];
            dp[i]=temp;
        }
        int compare_dp=0;
        for (int i=rewardValues.length-2;i>=0;i--){
            if (dp[i]>rewardValues[rewardValues.length-1]){
                continue;
            }else {
                compare_dp=rewardValues[rewardValues.length-1]+dp[i];
                break;
            }
        }
        if(compare_dp>=rewardValues[rewardValues.length-2]&&compare_dp<rewardValues[rewardValues.length-1]){
            dp[rewardValues.length-1]=compare_dp+rewardValues[rewardValues.length-1];
        } else if (compare_dp>rewardValues[rewardValues.length-2]&&compare_dp>=rewardValues[rewardValues.length-1]) {
            dp[rewardValues.length-1]=rewardValues[rewardValues.length-2]+rewardValues[rewardValues.length-1];
        }
        return dp[rewardValues.length-1];
    }
    public static void main(String[] args) {
        int[] rewardValues = new int[]{1,6,4,3,2};
        int[] test=new int[]{1,1,3,3};
        int[] test2=new int[]{3,3};
        System.out.println(maxTotalReward(rewardValues));
        //System.out.println(maxTotalReward(test));
        //System.out.println(maxTotalReward(test2));
    }
}
