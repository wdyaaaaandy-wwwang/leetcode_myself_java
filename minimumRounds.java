import java.util.HashMap;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/5/14 10:15
 * @Description 2244.完成所有任务需要的最少轮数（中等）
 */
public class minimumRounds {
    public static void main(String args[]){
        int[] tasks={2,2,3,3,2,4,4,4,4,4};
        int round=0;
        boolean isFound=false;
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<tasks.length;i++){
            int temp=tasks[i];
            if (map.containsKey(temp)){
                int current=map.get(temp);
                current=current+1;
                map.put(temp,current);
            }else {
                map.put(temp,1);
            }
        }
        for (Integer key: map.keySet()){
            int tempValue=map.get(key);
            if (tempValue==1){
                isFound=false;
                //return -1;
            }
        }

    }
}
