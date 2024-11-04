/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/5/29 15:41
 * @Description 200.岛屿数量 DFS典型例题 中等(已自己写出来)
 */
public class numIslands {
    public static void dfs(int i,int j,char[][] grid){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return ;
        }
        grid[i][j]='0';
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
    public static void main(String args[]){
        char[][] grid={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int res=0;
        for (int i=0;i< grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    dfs(i,j,grid);
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
