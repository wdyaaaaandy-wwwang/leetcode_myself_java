import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy_Wang
 * @version
 * @description: 40 组合总和Ⅱ 中等 回溯
 * @date 2024/10/31 11:32
 */
public class combinationSum2 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used_origin = new boolean[candidates.length];
        List<List<Integer>> res = new ArrayList<>();
        int temp=0;
        for(int i = 0; i < candidates.length; i++) {
            used_origin[i] = false;
        }
        int i=0;
        while(i < candidates.length) {
            List<Integer>listTemp=new ArrayList<>();
            listTemp.add(candidates[i]);
            temp = candidates[i];
            boolean[] used=used_origin;
            for (int j=0;j<candidates.length;j++){
                if(used[j]!=true){
                    back(listTemp,temp,target,j,res,candidates,used);
                }
            }
            i=i+1;
            used_origin[i]=true;
        }
        return res;
    }
    public static void back(List<Integer>listTemp,int current,int target,int position,List<List<Integer>> res,int[] candidates,boolean[] used) {
        if(current==target&&!res.contains(listTemp)) {
            res.add(listTemp);
        }else if(current!=target){
            current=current+candidates[position];
            used[current]=true;
            back(listTemp,current,target,position+1,res,candidates,used);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>>res = combinationSum2(candidates, target);
        System.out.println(res);
    }
}
