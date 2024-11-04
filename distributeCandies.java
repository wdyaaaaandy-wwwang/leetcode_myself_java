import java.util.Arrays;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/6/3 11:10
 * @Description 1103.分糖果Ⅱ 简单 简单的数学模拟
 * 自己写的，已通过！
 */
public class distributeCandies {

    public static void main(String[] grgs){
        int candidates=7;
        int num_people=4;
//        int candidates=10;
//        int num_people=3;
        int[] res=new int[num_people];
        int origin=1;
        int position=0;
        while (candidates>0){
            int temp=0;
            if (candidates-origin>=0){
                temp=origin;
            }else {
                temp=candidates;
            }
            if (position==(num_people-1)) {
                res[position]+=temp;
                candidates-=origin;
                origin+=1;
                position=0;
            }else {
                res[position]+=temp;
                candidates-=origin;
                origin+=1;
                position++;
            }
        }
        System.out.println(Arrays.toString(res));
        //return res;
    }
}
