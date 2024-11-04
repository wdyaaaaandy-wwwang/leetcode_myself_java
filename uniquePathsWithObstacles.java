/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/6/4 10:30
 * @Description 63.不同路径Ⅱ 中等 动态规划
 * 题目描述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * ------------------------------------------------------------------------
 * 输入输出示例：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * -----------------------------------------------------------------------
 * 思路正确，和官方一样是动态规划，动态规划方程：f(i,j)=f(i−1,j)+f(i,j−1)
 * 由于滚动数组思想，可以简化为f[j]，其中j代表是原方程的纵坐标
 *
 */
public class uniquePathsWithObstacles {
    public static void main(String[] agrs){
//        int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        int[][] obstacleGrid={{0,1},{0,0}};
//        int m=obstacleGrid.length;
//        int n=obstacleGrid[0].length;

//        int[][] hp=new int[m][n];
//        //横边
//        for (int j=0;j<n;j++){
//            if (obstacleGrid[0][j]==1){
//                hp[0][j]=0;
//                continue;
//            }
//            hp[0][j]=1;
//        }
//        //纵边
//        for (int i=0;i<m;i++){
//            if (obstacleGrid[i][0]==1){
//                hp[i][0]=0;
//                continue;
//            }
//            hp[i][0]=1;
//        }
//
//        for (int i=1;i<m;i++){
//            for (int j=1;j<n;j++){
//                if (obstacleGrid[i][j]==1){
//                    hp[i][j]=0;
//                }else {
//                    if (i==0&&j!=0){
//                        hp[i][j]=hp[i][j-1];
//                    }else if (i!=0&&j==0){
//                        hp[i][j]=hp[i-1][j];
//                    }else {
//                        hp[i][j]=hp[i-1][j]+hp[i][j-1];
//                    }
//                }
//            }
//        }
//        //return hp[m-1][n-1]
//        System.out.println(hp[m-1][n-1]);
// ------------------------------------------------------------------------------
//        下面是官方题解，用滚动数组思想做了简化
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        System.out.println(f[m-1]);
        //return f[m - 1];
    }
}
