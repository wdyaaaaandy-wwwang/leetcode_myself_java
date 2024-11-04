import java.util.LinkedList;
import java.util.List;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/6/5 11:03
 * @Description 120.三角形最小路径和   动态规划   中等
 */
public class minimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int currentPosition=0;
        int tempPositionMin=0;
        int tempNextPositionMin=0;
        int level=1;
        int res=0;
        for (int i=0;i< triangle.size();i++,level++){
            List<Integer>temp=triangle.get(i);
            tempPositionMin=temp.get(currentPosition);
            if (i==0){
                res+=temp.get(currentPosition);
                continue;
            }
            if (currentPosition+1<level){
                tempNextPositionMin=temp.get(currentPosition+1);
            }else {
                tempNextPositionMin=temp.get(currentPosition);
            }
            //---------------------------------------------
            if (tempPositionMin>=tempNextPositionMin){
                res+=tempNextPositionMin;
                currentPosition=currentPosition+1;
            }else {
                res+=tempPositionMin;
            }
        }
        return res;
    }

    public static void main(String[] agrs){
//        List<List<Integer>> triangle={{2},{3,4},{5,6,7},{4,1,8,3}};
        List<List<Integer>> triangle=new LinkedList<>();
        List<Integer>list1=new LinkedList<>();
        List<Integer>list2=new LinkedList<>();
        List<Integer>list3=new LinkedList<>();
        List<Integer>list4=new LinkedList<>();
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list3.add(5);
        list3.add(6);
        list3.add(7);
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);

        System.out.println(minimumTotal(triangle));
    }
}
