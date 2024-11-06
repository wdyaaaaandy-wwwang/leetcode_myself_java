import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 438. 找到字符串中所有字母异位词  中等 哈希表 字符串 滑动窗口
 * 举一反三，自己写出来的！
 * @date 2024/11/6 14:56
 */
public class findAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        char[] ttk=p.toCharArray();
        Arrays.sort(ttk);
        p=new String(ttk);
        for (int i = 0; i <= (n-m); i++) {
            String sub = s.substring(i,i+m);
            char[] temp = sub.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if (sorted.equals(p)) {
                ans.add(i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s="cbaebabacd", p = "abc";
        String s1="abab",p1="ab";
        System.out.println(findAnagrams(s, p));
        System.out.println(findAnagrams(s1, p1));
    }
}
