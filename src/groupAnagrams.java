import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 49.字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表
 * @date 2024/11/5 10:10
 */
public class groupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
//        if (strs == null || strs.length == 0) return new ArrayList<>();
//        if (strs.length == 1){
//            List<List<String>> ans = new ArrayList<>();
//            List<String> list = new ArrayList<>();
//            list.add(strs[0]);
//            ans.add(list);
//            return ans;
//        }
//        List<List<String>> ans = new ArrayList<List<String>>();
//        HashMap<List<Character>,List<Integer>>point=new HashMap<>();
//        List<List<Character>> split=new ArrayList<>();
//        for (int i = 0; i < strs.length; i++) {
//            String s = strs[i];
//            if (i==0){
//                List<Character> list = new ArrayList<>();
//                int length=s.length();
//                for (int j = 0; j < length; j++) {
//                    char c=s.charAt(j);
//                    list.add(c);
//                }
//                split.add(list);
//                List<Integer>temp=new ArrayList<>();
//                temp.add(i);
//                point.put(list,temp);
//            }else if (i!=0){
//                List<Character> list = new ArrayList<>();
//                int length=s.length();
//                for (int j = 0; j < length; j++) {
//                    char c=s.charAt(j);
//                    list.add(c);
//                }
//                if (split.contains(list)){
//                    List<Integer>temp=point.get(list);
//                    temp.add(i);
//                    point.put(list,temp);
//                }else {
//                    List<Integer>temp=new ArrayList<>();
//                    temp.add(i);
//                    point.put(list,temp);
//                }
//            }
//        }
//        for (List<Integer> list : point.values()){
//            List<String>single=new ArrayList<>();
//            for (Integer i : list){
//                single.add(strs[i]);
//            }
//            ans.add(single);
//        }
//        return ans;
        if (strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // 将字符串转换为字符数组，排序，然后转换回字符串
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedString = new String(chars);

            // 如果键不存在，则创建一个新的列表来存储异位词
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            // 将原始字符串添加到对应的列表中
            map.get(sortedString).add(s);
        }

        // 将Map的值（即异位词列表）转换为List<List<String>>并返回
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strArray = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strArray));
    }
}
