import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 239. 滑动窗口最大值 困难 队列 数组 滑动窗口 单调队列 堆（优先队列）
 * @date 2024/11/7 11:05
 */
public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        int n = nums.length;
//        if (n == 0||nums==null || n<k) return null;
//        if (n==1||k==1){
//            return nums;
//        }
//        int[] res = new int[nums.length - k + 1];
//        Deque<Integer> deque = new LinkedList<>();
//        int start = 0;
//        while (start + k - 1 < nums.length) {
//            if(start==0) {
//                for (int i = 0; i < k; i++) {
//                    deque.offerLast(nums[start + i]);
//                }
//            }else {
//
//            }
//            int max = deque.stream()
//                    .mapToInt(Integer::intValue)
//                    .max()
//                    .getAsInt();
//            res[start] = max;
////            deque.removeFirst();
//            while (!deque.isEmpty() && deque.peekFirst() < start- k + 1) {
//                deque.pollFirst();
//            }
//            deque.offerLast(nums[start + k]);
//            start=start+1;
//        }
//        return res;
        int len = nums.length;
        int[] result = new int[len - k + 1]; //用来存储结果的数组
        Deque<Integer> Deque = new LinkedList<>(); //双端队列
        //通过这个for循环先将前k的元素(即第一个窗口的值)入队列
        for( int i = 0; i < k; i++  ){
            int num = nums[i];
            //如果队列不为空,且队列末尾元素的值小于要存入的元素,就将这个元素移出队列,要循环操作
            while( !Deque.isEmpty() && Deque.peekLast() < num ){
                Deque.pollLast();
            }
            Deque.offerLast(num);
        }
        int index = 0;
        result[index++] = Deque.peek(); //先将第一个窗口的最大值存到数组中
        //通过这个for循环来将窗口移动,j为窗口的末尾元素的位置,j开始值为第二个窗口末尾位置
        for( int j = k; j < len; j++ ){
            int num = nums[j];
            //先判断队列头元素是不是移出窗口的元素,如果是则将该元素移出队列
            if( Deque.peekFirst() == nums[ j - k ] ){
                Deque.pollFirst();
            }
            //如果队列不为空,且队列末尾元素的值小于要存入的元素,就将这个元素移出队列,要循环操作
            while( !Deque.isEmpty() && Deque.peekLast() < num ){
                Deque.pollLast();
            }
            Deque.offerLast(num);
            //每次循环的最后,将队列中的头元素存到结果数组中去
            result[index++] = Deque.peek();
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int k=3;
        int[] res = new maxSlidingWindow().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
