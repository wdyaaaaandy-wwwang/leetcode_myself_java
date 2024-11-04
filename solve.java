import java.util.Arrays;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/5/29 16:48
 * @Description 130.被围绕的区域 中等 DFS
 * 最终解决思路：反向思维
 * 本题要求将所有被字母 X 包围的字母 O都变为字母 X ，但很难判断哪些 O 是被包围的，哪些 O 不是被包围的。
 *
 * 注意到题目解释中提到：任何边界上的 O 都不会被填充为 X。 我们可以想到，所有的不被包围的 O 都直接或间接与边界上的 O 相连。我们可以利用这个性质判断 O 是否在边界上，具体地说：
 *
 * 对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O；
 * 最后我们遍历这个矩阵，对于每一个字母：
 * 如果该字母被标记过，则该字母为没有被字母 X 包围的字母 O，我们将其还原为字母 O；
 * 如果该字母没有被标记过，则该字母为被字母 X 包围的字母 O，我们将其修改为字母 X。
 */
public class solve {
    public static void dfs(int i,int j,char[][] board){
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O'){
            return;
        }
        board[i][j]='A';
        dfs(i+1,j,board);
        dfs(i-1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }
    public static void main(String args[]){
        char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        int m=board.length;
        int n=board[0].length;
        //DFS左右两边边界上的O并标记为A
        for (int i=0;i<m;i++){
            dfs(i,0,board);
            dfs(i,n-1,board);
        }
        //DFS上下两边边界上的O并标记为A
        for (int i=0;i<n;i++){
            dfs(0,i,board);
            dfs(m-1,i,board);
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='A'){
                    board[i][j]='O';
                } else if (board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
        System.out.println("最终结果是：\n");
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                System.out.println(board[i][j]);
            }
        }
    }
}
