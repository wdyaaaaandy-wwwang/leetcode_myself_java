/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3184.构成整天的下标对数目Ⅰ 简单 + 3184.构成整天的下标对数目Ⅱ 中等
 * @date 2024/10/22 10:04
 */
public class countCompleteDayPairs {
    public static int countCompleteDayPairsⅡ(int[] hours){
        int n = hours.length;
        int res = 0;
        return 0;
    }
    public static int countCompleteDayPairs(int[] hours){
        int n = hours.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp1=hours[i],temp2=hours[j];
                if ((temp2+temp1)%24==0){
                    res++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] hours1={12,12,30,24,24};
        int[] hours2={72,48,24,3};
        System.out.println(countCompleteDayPairs(hours1));
        System.out.println(countCompleteDayPairs(hours2));
    }
}
