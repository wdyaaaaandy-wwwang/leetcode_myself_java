/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3258. 统计满足 K 约束的子字符串数量 I 难度简单 字符串 滑动窗口(自己已写出来)
 * @date 2024/11/12 15:52
 */
public class countKConstraintSubstrings {
    public static boolean isOk(String s, int k) {
        int count_one=0;
        int count_zero=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count_one++;
            }else if (s.charAt(i) == '0') {
                count_zero++;
            }
        }
        if (count_one>k && count_zero>k) {
            return false;
        }
        return true;
    }
    public static int countKConstraintSubstrings_one(String s, int k) {
        int n = s.length();
        int fellow_count = n*(n+1)/2;
        int windows_length=0;
        int j=0;
        for (int i = 0; i < n; i++) {
            for (j=i,windows_length=k+1;(j+windows_length)<=n;++windows_length){
                String sub = s.substring(j,j+windows_length);
                if (!isOk(sub,k)) {
                    int temp=n-(j+windows_length-1);
                    fellow_count=fellow_count-temp;
                    break;
                }
            }

        }
        return fellow_count;
    }

    public static void main(String[] args) {
        String s1="10101";
        int k1=1;
        String s2="1010101";
        int k2=2;
        String s3="11111";
        int k3=1;
        String s4="0011";
        int k4=1;
        System.out.println(countKConstraintSubstrings_one(s1,k1));
        System.out.println(countKConstraintSubstrings_one(s2,k2));
        System.out.println(countKConstraintSubstrings_one(s3,k3));
        System.out.println(countKConstraintSubstrings_one(s4,k4));
    }
}
