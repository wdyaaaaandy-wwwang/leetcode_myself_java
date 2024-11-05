import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Andy_Wang
 * @version
 * @description: 3175.找到连续赢得k场比赛的第一位玩家 中等
 * @date 2024/10/24 14:04
 */
public class findWinningPlayer {
    public static int officialSolution(int[] skills, int k) {
        int n = skills.length;
        int cnt = 0;
        int i = 0, last_i = 0;

        while (i < n) {
            int j = i + 1;
            while (j < n && skills[j] < skills[i] && cnt < k) {
                j++;
                cnt++;
            }
            if (cnt == k) {
                return i;
            }
            cnt = 1;
            last_i = i;
            i = j;
        }
        return last_i;
    }
    public static int findWinningPlayer(int[] skills, int k) {
        //当数组只有两个时
        if (skills.length == 2) return (skills[0]>skills[1]) ? 0 : 1;
        //当K大于数组长度时，一定是数组中最大的那个数
        if(k>skills.length){
            int skills_max=skills[0];
            int skills_position=0;
            for (int i=0;i<skills.length;i++){
                if(skills[i]>skills_max){
                    skills_position=i;
                    skills_max=skills[i];
                }
            }
            return skills_position;
        }
        //接下来看不是只有两个的情况
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<skills.length;i++){
            //queues[i]=i;
            deque.addLast(i);
        }
//        boolean isFirst=true;
//        int current=0;
//        int first_value,second_value,delete_value,win_value;
//        first_value=0;
//        while (current!=k){
//            if (isFirst){
//                current=1;
//                first_value=deque.removeFirst();
//                second_value=deque.removeFirst();
//                delete_value=(skills[first_value]>skills[second_value])?second_value:first_value;
//                win_value=(skills[first_value]>skills[second_value])?first_value:second_value;
//                first_value=win_value;
//                deque.addFirst(first_value);
//                deque.addLast(delete_value);
//                isFirst=false;
//            }else{
//                first_value=deque.removeFirst();
//                second_value=deque.removeFirst();
//                delete_value=(skills[first_value]>skills[second_value])?second_value:first_value;
//                win_value=(skills[first_value]>skills[second_value])?first_value:second_value;
//                if (win_value==first_value){
//                    current=current+1;
//                    deque.addFirst(first_value);
//                    deque.addLast(delete_value);
//                }else {
//                    current=1;
//                    first_value=win_value;
//                }
//            }
//        }
//
//        return first_value;
        int currentWinner = 0;
        int consecutiveWins = 0;
        int res=0;

        while (deque.size() > 1) {
            int firstPlayer = deque.removeFirst();
            int secondPlayer = deque.removeFirst();

            int winner = skills[firstPlayer] > skills[secondPlayer] ? firstPlayer : secondPlayer;
            int loser = skills[firstPlayer] > skills[secondPlayer] ? secondPlayer : firstPlayer;


            deque.addLast(loser);  // 将败者放回队列末尾

            if (winner == currentWinner) {
                consecutiveWins++;
                if (consecutiveWins == k) {
                    res=winner;
                    break;
//                    return winner;
                }
                deque.addFirst(winner);  // 如果当前胜者连续赢，则将其放回队列前端
            } else {
                consecutiveWins = 1;  // 重置连续赢的计数
                currentWinner = winner;
                deque.addFirst(winner);  // 新的胜者放到队列前端
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] skills = new int[]{4,2,6,3,9};
        int k=2;
        int[] skills2=new int[]{2,5,4};
        int k2=3;
        int[] skills3=new int[]{4,8,9,7};
        int k3=717834084;
        //System.out.println(findWinningPlayer(skills, k));
        //System.out.println(findWinningPlayer(skills2, k2));
        System.out.println(findWinningPlayer(skills3, k3));
    }
}
