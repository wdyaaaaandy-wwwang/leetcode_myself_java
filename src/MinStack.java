import java.util.Stack;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 155.最小栈  中等
 * @date 2024/12/4 11:16
 */
public class MinStack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public MinStack() {

    }

    public void push(int val) {
//        if (stack.isEmpty()) {
//            stack.push(val);
//        }else{
//            Stack<Integer> stack_temp = new Stack<>();
//            while(val>stack.peek()&&!stack.isEmpty()) {
//                stack_temp.push(stack.peek());
//                stack.pop();
//            }
//            stack.push(val);
//            while(!stack_temp.isEmpty()){
//                stack.push(stack_temp.pop());
//            }
//        }
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int peek=stack.pop();
        if(minStack.peek()==peek){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
