import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: TODO
 * @date 2024/12/2 18:32
 */
public class dailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        int position=0;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] two=new int[temperatures.length][2];
        for (int i = 0; i < temperatures.length; i++) {
            map.put(temperatures[i], i);
            two[i][0] = temperatures[i];
            two[i][1] = i;
        }
        stack.push(temperatures[0]);
        int i=1;
        while (i <= temperatures.length) {
            if (i==temperatures.length){
                res[i-1]=0;
                break;
            }
            if (stack.peek()<temperatures[i]){
                    int pos1 = map.get(stack.peek());
//                    int pos2 = map.get(temperatures[i]);
                    int pos2 = two[i][1];
                    int result=pos2-pos1;
                    stack.pop();
                    stack.push(temperatures[i]);
                    res[pos1]=result;
                    i=i+1;
            }else{
                stack.push(temperatures[i]);
                i=i+1;
            }
        }
        res[map.get(stack.peek())]=0;
        return res;
    }
    public static void main(String[] args) {
        int[] nums={73,74,75,71,69,72,76,73};
        int[] nums2={30,40,50,60};
        int[] nums3={30,60,90};
        System.out.println(Arrays.toString(dailyTemperatures(nums)));
        System.out.println(Arrays.toString(dailyTemperatures(nums2)));
        System.out.println(Arrays.toString(dailyTemperatures(nums3)));
    }
}
