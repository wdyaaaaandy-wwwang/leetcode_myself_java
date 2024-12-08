import java.util.*;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 739. 每日温度  中等 栈 数组 单调栈  自己理解了，但差一点点写出来
 * @date 2024/12/2 18:32
 */
public class dailyTemperatures {
    public static int[] dailyTemperatures_official(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

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
                    int pos1 = i;
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
