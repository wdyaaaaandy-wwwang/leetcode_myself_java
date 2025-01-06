import java.util.HashMap;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3083. 字符串及其反转中是否存在同一子字符串 简单 哈希表 字符串
 * @date 2024/12/26 09:59
 */
public class isSubstringPresent {
    public static boolean isSubstringPresent(String s) {
        boolean result = false;
        int n = s.length();
        int i=0;
        int j=n-1;
        char[] s_arr = s.toCharArray();
        while(i<j) {
            char temp = s_arr[i];
            s_arr[i] = s_arr[j];
            s_arr[j] = temp;
            i=i+1;
            j=j-1;
        }
        String s_reverse=new String(s_arr);
        HashMap<Integer,Character>hashMap=new HashMap<>();
        for (int point=0;point<s.length();point++) {
            hashMap.put(point,s_arr[point]);
            char temp=s_arr[point];
            if(point>=1){
                if(temp==hashMap.get(point-1)) {
                    result=true;
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
//        String s="leetcode";
        String s="abcba";
        if(isSubstringPresent(s)) {
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
