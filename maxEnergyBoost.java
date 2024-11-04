/**
 * @author Andy_Wang
 * @version 1.0
 * @description: TODO
 * @date 2024/11/1 14:50
 */

public class maxEnergyBoost {
    public static long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n=energyDrinkA.length;
        int[] dpA=new int[n];
        int[] dpB=new int[n];
        int[]dp=new int[n];
        dp[0]=Math.max(energyDrinkA[0],energyDrinkB[0]);
        dp[1]=Math.max(energyDrinkA[1]+energyDrinkA[0],energyDrinkB[1]+energyDrinkB[0]);
        dpA[0]=energyDrinkA[0];
        dpB[0]=energyDrinkB[0];
        dpA[1]=energyDrinkA[1]+energyDrinkA[0];
        dpB[1]=energyDrinkB[1]+energyDrinkB[0];
        for (int i=2;i<n;i++) {
            dpB[i]=dpB[i-1]+energyDrinkB[i];
            dpA[i]=dpA[i-1]+energyDrinkA[i];

                int temp_B=Math.max(dpB[i-1]+energyDrinkB[i],dp[i-2]+energyDrinkB[i]);
                int temp_A=Math.max(dp[i-2]+energyDrinkA[i],dpA[i-1]+energyDrinkA[i]);
                dp[i]=Math.max(temp_B,temp_A);

        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        int[] energyDrinkA={5,5,6,3,4,3,3,4};
        int[] energyDrinkB={5,3,3,4,4,6,6,3};
        System.out.println(maxEnergyBoost(energyDrinkA, energyDrinkB));
    }
}
