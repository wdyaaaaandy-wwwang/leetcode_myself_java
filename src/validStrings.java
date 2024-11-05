import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3211 不含相邻二进制0的字符串 中等 回溯 已靠自己和gpt完成
 * @date 2024/10/29 14:07
 */

public class validStrings {
    public static void dfs_inner(String s, List<String> tt, int len){
        if (s.length()==len){
            tt.add(s);
            return;
        } else if (s.isEmpty()) {
            dfs_inner("1", tt, len);
            dfs_inner("0", tt, len);
        } else if ( s.charAt(s.length() - 1) == '1') {
            dfs_inner(s+"0", tt, len);
            dfs_inner(s+"1", tt, len);
        } else if ( s.charAt(s.length() - 1) == '0') {
            dfs_inner(s+"1", tt, len);
        }
    }
    public static void validStrings(int n) {
        List<String> res = new ArrayList<>();
        dfs_inner("",res,n);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        int n=3;
        validStrings(n);
    }
}


