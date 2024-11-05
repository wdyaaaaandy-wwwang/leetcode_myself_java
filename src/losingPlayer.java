/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3222.求出硬币游戏的赢家 简单 自己写过的
 * @date 2024/11/5 09:22
 */
public class losingPlayer {
    public static String losingPlayer(int x, int y) {
        if (y<4){
            return "Alice";
        }
        String Alice="Alice";
        String Bob="Bob";
        int current=1;
        while (x>=0&&y>=0){
            x=x-1;
            y=y-4;
            current=current+1;
        }
        if (current%2==0){
            return Bob;
        }
        return Alice;
    }
    public static void main(String[] args) {
        System.out.println(losingPlayer(2,7));
        System.out.println(losingPlayer(4, 11));
    }
}
