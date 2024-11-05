import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Andy_Wang
 * @version
 * @description: 有效的括号 回溯 中等
 * @date 2024/10/29 17:14
 */
public class generateParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.peek(), c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
    public static void dfs_inner(int n,List<String>res,String temp,int openCount, int closeCount){
         if(temp.length()==n){
            if (isValid(temp)){
                res.add(temp);
            }
        }else if(temp.length()<n){
             dfs_inner(n, res, temp + "(", openCount + 1, closeCount);
             dfs_inner(n, res, temp + "{", openCount + 1, closeCount);
             dfs_inner(n, res, temp + "[", openCount + 1, closeCount);
        }
        if (closeCount < openCount) { // 确保在添加闭合括号之前有对应的开放括号
            dfs_inner(n, res, temp + ")", openCount, closeCount + 1);
            dfs_inner(n, res, temp + "}", openCount, closeCount + 1);
            dfs_inner(n, res, temp + "]", openCount, closeCount + 1);
        }
    }

    public static void main(String[] args) {
        int n=1;
        List<String>res=new ArrayList<>();
        dfs_inner(2*n,res,"",0,0);
        System.out.println("输出一共%d个结果！\n"+res.size());
        for (String s:res){
            System.out.println(s);
        }
    }
}
