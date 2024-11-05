import java.util.Arrays;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/5/27 10:32
 * @Description 2028.找出缺失的关键数据 中等
 */

public class missingRolls {
    public static void dfs(){

    }
    public static void main(String args[]){
        int[] rolls={3,2,4,3};
        int mean=4;
        int n=2;
        int m=rolls.length;
        int allSum=(m+n)*mean;
        int[] dice={1,2,3,4,5,6};
        int i,j;
        int aimSum=allSum-Arrays.stream(rolls).sum();
        System.out.println(aimSum);

    }
}
