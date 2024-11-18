import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3239. 最少翻转次数使二进制矩阵回文 I  难度中等  数组 双指针 矩阵  自己写的已通过！
 * 3240. 最少翻转次数使二进制矩阵回文 II  难度中等 数组 双指针 矩阵（没写出来，看官方题解的）
 * Ⅱ的题目描述：给你一个 m x n 的二进制矩阵 grid 。
 *
 * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
 *
 * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
 *
 * 请你返回 最少 翻转次数，使得矩阵中 所有 行和列都是 回文的 ，且矩阵中 1 的数目可以被 4 整除 。
 * @date 2024/11/15 15:41
 */
public class minFlips {
    //官方题解
    private static int minFlips_official(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0; // 获取矩阵的行数和列数，并初始化答案变量

        // 遍历矩阵的左上角和右下角的四个象限
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                // 计算四个对称位置上的1的个数
                int cnt1 = grid[i][j] + grid[i][n - 1 - j] +
                        grid[m - 1 - i][j] + grid[m - 1 - i][n - 1 - j];
                // 计算最少翻转次数，取cnt1和4-cnt1的较小值
                ans += Math.min(cnt1, 4 - cnt1);
            }
        }

        int diff = 0, cnt1 = 0; // 初始化差异计数器和cnt1计数器

        // 如果行数为奇数，处理中间的列
        if (m % 2 == 1) {
            for (int j = 0; j < n / 2; j++) {
                // 如果对称位置上的值不同，则需要翻转
                if ((grid[m / 2][j] ^ grid[m / 2][n - 1 - j]) != 0) {
                    diff++;
                } else {
                    // 如果对称位置上的值相同，则累加它们的值
                    cnt1 += grid[m / 2][j] * 2;
                }
            }
        }

        // 如果列数为奇数，处理中间的行
        if (n % 2 == 1) {
            for (int i = 0; i < m / 2; i++) {
                // 如果对称位置上的值不同，则需要翻转
                if ((grid[i][n / 2] ^ grid[m - 1 - i][n / 2]) != 0) {
                    diff++;
                } else {
                    // 如果对称位置上的值相同，则累加它们的值
                    cnt1 += grid[i][n / 2] * 2;
                }
            }
        }

        // 如果行数和列数都是奇数，处理中心点
        if (m % 2 == 1 && n % 2 == 1) {
            ans += grid[m / 2][n / 2];
        }

        // 如果有差异，则增加差异计数到答案中
        if (diff > 0) {
            ans += diff;
        } else {
            // 如果没有差异，增加cnt1的模4余数到答案中
            ans += cnt1 % 4;
        }
        return ans; // 返回最终的最少翻转次数
    }

    private static boolean isPointEqual(int[] pointA, int[] pointB) {
        return pointA[0] == pointB[0] && pointA[1] == pointB[1];
    }

    private static boolean areAllPointsDifferent(int[] point1, int[] point2, int[] point3, int[] point4) {
        if (isPointEqual(point1, point2) || isPointEqual(point1, point3) || isPointEqual(point1, point4)) {
            return false;
        }
        if (isPointEqual(point2, point3) || isPointEqual(point2, point4)) {
            return false;
        }
        if (isPointEqual(point3, point4)) {
            return false;
        }
        return true;
    }

    private static int processPoint(int res, Set<String> processedPoints, int[] point, int[][] grid) {
        int x = point[0];
        int y = point[1];
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            String pointKey = x + "," + y;
            if (!processedPoints.contains(pointKey) && grid[x][y] == 0) {
                res += 1;
                processedPoints.add(pointKey);
            }
        }
        return res;
    }

    public static int minFlips_two(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        Set<String> processedPoints = new HashSet<>();
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int[] position = {i, j};
                    int[] position_right = {m - 1 - i, j};
                    int[] position_down = {i, n - 1 - j};
                    int[] position_angle = {m - 1 - i, n - 1 - j};

                    if (areAllPointsDifferent(position, position_right, position_down, position_angle)) {
                        res += (4 - (grid[position[0]][position[1]] == 1 ? 1 : 0) -
                                (grid[position_right[0]][position_right[1]] == 1 ? 1 : 0) -
                                (grid[position_down[0]][position_down[1]] == 1 ? 1 : 0) -
                                (grid[position_angle[0]][position_angle[1]] == 1 ? 1 : 0));
                    } else {
                        res = processPoint(res, processedPoints, position, grid);
                        res = processPoint(res, processedPoints, position_right, grid);
                        res = processPoint(res, processedPoints, position_down, grid);
                        res = processPoint(res, processedPoints, position_angle, grid);
                    }

                    visited[i][j] = true;
                    visited[position_right[0]][position_right[1]] = true;
                    visited[position_down[0]][position_down[1]] = true;
                    visited[position_angle[0]][position_angle[1]] = true;
                }
            }
        }
        return res;
    }
    public static int minFlips(int[][] grid) {
        if (grid == null || grid.length == 0||grid.length==1||grid[0].length==1) return 0;
        int res=0;
        int m = grid.length;
        int n = grid[0].length;
            int res_m = 0;
            int res_n = 0;
            //如果按照行来比较
            for (int i = 0; i < m; i++) {
                int[] temp = grid[i];
                int length = temp.length;
                int left = 0;
                int right = length - 1;
                while (left < right) {
                    if (temp[left] == temp[right]) {
                        left++;
                        right--;
                    } else {
                        //temp[left] = temp[right];
                        res_m = res_m + 1;
                        right--;
                        left++;
                    }
                }
            }
            //如果按照列来比较
            for (int i = 0; i < n; i++) {
                int up = 0;
                int down = m - 1;
                while (up < down) {
                    if (grid[up][i] == grid[down][i]) {
                        up++;
                        down--;
                    } else {
                        res_n = res_n + 1;
                        up++;
                        down--;
                    }
                }
            }
            res = Math.min(res_m, res_n);
//        }
        return res;
    }
    public static void main(String[] args) {
        int[][] grid1 = {{1,0,0},{0,0,0},{0,0,1}};
        int[][] grid2 = {{0,1},{0,1},{0,0}};
        int[][] grid3 = {{1},{0}};
        int[][] grid4 = {{0,1},{1,1}};
        int[][] grid5 = {{1,0,0},{0,1,0},{0,0,1}};
        int[][] grid6 = {{1},{1}};
        //System.out.println(minFlips(grid1));
        //System.out.println(minFlips(grid2));
        //System.out.println(minFlips(grid3));
        //System.out.println(minFlips(grid4));
        System.out.println("-----------Ⅱ题的测试区-----------------");
        //System.out.println(minFlips_two(grid5));
        System.out.println(minFlips_two(grid2));
        //System.out.println(minFlips_two(grid6));
    }
}
