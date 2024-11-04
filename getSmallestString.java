/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3216 交换后字典序最小的字符串 简单 贪心 自己写过
 * @date 2024/10/30 16:47
 */
public class getSmallestString {
    public static String swap(int positon_1, int positon_2,String s) {
        char[] toCharArray = s.toCharArray();
        char temp = toCharArray[positon_1];
        toCharArray[positon_1] = toCharArray[positon_2];
        toCharArray[positon_2] = temp;
        return new String(toCharArray);

    }
    public static String getSmallestString(String s) {
        boolean isMatch = false;
        String result = "";
        for (int i = 0; i < s.length()-1; i++) {
            char digitChar = s.charAt(i);
            char digitChar2 = s.charAt(i+1);
            int digit1=Character.getNumericValue(digitChar);
            int digit2=Character.getNumericValue(digitChar2);
            int digit1_odd = Character.getNumericValue(digitChar)%2;
            int digit2_odd = Character.getNumericValue(digitChar2)%2;
            if (digit1_odd == digit2_odd&&digit1>digit2) {
                isMatch = true;
                result=swap(i,i+1,s);
                break;
            }
        }
        if (!isMatch) {
            return s;
        }
        return result;
    }
    public static void main(String[] args) {
        String s1 = "45320";
        String s2 = "001";
        String s3 = "13";
        String s4="10";
        System.out.println(getSmallestString(s1));
        System.out.println(getSmallestString(s2));
        System.out.println(getSmallestString(s3));
        System.out.println(getSmallestString(s4));
    }
}
