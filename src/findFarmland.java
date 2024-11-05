import java.util.LinkedList;
import java.util.List;

/**
 * @author Andy Wang
 * @version
 * @date 2024/5/31 10:07
 * @Description 1992.找到所有的农场组 DFS 中等
 * 题目描述：给你一个下标从 0 开始，大小为 m x n 的二进制矩阵 land ，其中 0 表示一单位的森林土地，1 表示一单位的农场土地。
 *
 * 为了让农场保持有序，农场土地之间以矩形的 农场组 的形式存在。每一个农场组都 仅 包含农场土地。且题目保证不会有两个农场组相邻，也就是说一个农场组中的任何一块土地都 不会 与另一个农场组的任何一块土地在四个方向上相邻。
 *
 * land 可以用坐标系统表示，其中 land 左上角坐标为 (0, 0) ，右下角坐标为 (m-1, n-1) 。请你找到所有 农场组 最左上角和最右下角的坐标。一个左上角坐标为 (r1, c1) 且右下角坐标为 (r2, c2) 的 农场组 用长度为 4 的数组 [r1, c1, r2, c2] 表示。
 *
 * 请你返回一个二维数组，它包含若干个长度为 4 的子数组，每个子数组表示 land 中的一个 农场组 。如果没有任何农场组，请你返回一个空数组。可以以 任意顺序 返回所有农场组。
 *
 * 输入：land = [[1,0,0],[0,1,1],[0,1,1]]
 * 输出：[[0,0,0,0],[1,1,2,2]]
 * 解释：
 * 第一个农场组的左上角为 land[0][0] ，右下角为 land[0][0] 。
 * 第二个农场组的左上角为 land[1][1] ，右下角为 land[2][2] 。
 */
public class findFarmland {
    public static int lastStep;
    public static int lastStepColumn;

    public static void dfs(int i,int j,int[][] land){
        if (i < 0 || i >(land.length-1) || j < 0 || j >(land[0].length-1) || land[i][j] !=1){
            return;
        }
        land[i][j]=0;
        lastStep=i;
        lastStepColumn=j;
        if (i== land.length-1) {
            dfs(i,j+1,land);
        } else if (j==land[0].length-1) {
            dfs(i+1,j,land);
        } else {
            dfs(i+1,j,land);
//            dfs(i-1,j,land);
            dfs(i,j+1,land);
//            dfs(i,j-1,land);
        }
    }
    
    public static void main(String args[]){
//        int[][] land={{1,0,0},{0,1,1},{0,1,1}};
        int[][] land={{1,1},{1,1}};
        int m= land.length;
        int n=land[0].length;
        int resNum=0;
        List<List<Integer>>res=new LinkedList<>();
        int firstPoint=0;
        int firstPointColumn=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (land[i][j]==1){
                    firstPoint=i;
                    firstPointColumn=j;
                    dfs(i,j,land);
                    List<Integer>temp=new LinkedList<>();
                    temp.add(firstPoint);
                    temp.add(firstPointColumn);
                    temp.add(lastStep);
                    temp.add(lastStepColumn);
                    res.add(temp);
                    resNum+=1;
                }
            }
        }
        System.out.println(resNum);
        System.out.println(res);

    }
}
