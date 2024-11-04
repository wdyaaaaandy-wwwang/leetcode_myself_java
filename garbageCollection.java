import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/5/14 10:15
 * @Description 收集垃圾的最少总时间
 */
public class garbageCollection {
    public static int HasCharacterNum(String Temp,char t){
        int returnNum=0;
        for (int i=0;i<Temp.length();i++){
            if (Temp.charAt(i)==t){
                returnNum++;
            }
        }
        return returnNum;
    }

    public static boolean ifHasCharacter(String Temp,char t){
        return HasCharacterNum(Temp, t) > 0;
    }

    public static void main(String args[]){
//        String[] garbage={"G","P","GP","GG"};
        String[] garbage={"MMM","PGM","GP"};
//        int[] travel={2,4,3};
        int[] travel={3,10};
        int aim=0;
//        Queue<Integer> garbagePosition_G=new LinkedList<>();
//        Queue<Integer> garbagePosition_M=new LinkedList<>();
//        Queue<Integer> garbagePosition_P=new LinkedList<>();
//        int i,j;
//        for (i=0;i<garbage.length;i++){
//            String temp=garbage[i];
//            if (ifHasCharacter(temp,'G')){
//                garbagePosition_G.offer(i);
//            } else if (ifHasCharacter(temp,'M')){
//                garbagePosition_M.offer(i);
//            } else if (ifHasCharacter(temp,'P')) {
//                garbagePosition_P.offer(i);
//            }
//        }
//        for (j=0;j<garbage.length;j++){
//
//        }
        int i,j;
        int last_position_G=0;
        int last_position_M=0;
        int last_position_P=0;
        for (i=0;i<garbage.length;i++){
            String temp=garbage[i];
            if (ifHasCharacter(temp,'G')){
                last_position_G=i;
            }
            if (ifHasCharacter(temp,'M')) {
                last_position_M=i;
            }
            if (ifHasCharacter(temp,'P')) {
                last_position_P=i;
            }
        }
        for (j=0;j<=last_position_G;j++){
            aim+=HasCharacterNum(garbage[j],'G' );
            if (j>=1){
                aim+=travel[j-1];
            }
        }
        for (j=0;j<=last_position_M;j++){
            aim+=HasCharacterNum(garbage[j],'M');
            if (j>=1){
                aim+=travel[j-1];
            }
        }
        for (j=0;j<=last_position_P;j++){
            aim+=HasCharacterNum(garbage[j],'P' );
            if (j>=1){
                aim+=travel[j-1];
            }
        }

        System.out.println(aim);
    }
}
