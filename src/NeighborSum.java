import java.util.HashMap;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 3242. 设计相邻元素求和服务（简单）设计 数组 哈希表 矩阵 模拟
 * @date 2024/11/12 11:04
 * 已自己写出来，没有参考官方题解
 * /**
 *  * Your NeighborSum object will be instantiated and called as such:
 *  * NeighborSum obj = new NeighborSum(grid);
 *  * int param_1 = obj.adjacentSum(value);
 *  * int param_2 = obj.diagonalSum(value);
 *
 */
//public class NeighborSum {
//    public static int[][] operation;
//    public  HashMap<Integer, int[]> map;
//
//    public NeighborSum(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//        operation = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                operation[i][j] = grid[i][j];
//                map.put(grid[i][j], new int[]{i, j});
//            }
//        }
//    }
//
//    public static int adjacentSum(int value) {
//        int n = operation.length;
//        int m = operation[0].length;
//        int i=map.get(value)[0];
//        int j=map.get(value)[1];
//        int value_up = (i > 0) ? operation[i - 1][j] : 0;
//        int value_down = (i < n - 1) ? operation[i + 1][j] : 0;
//        int value_left = (j > 0) ? operation[i][j - 1] : 0;
//        int value_right = (j < m - 1) ? operation[i][j + 1] : 0;
//        int sum = value_up + value_down + value_left + value_right;
//        return sum;
//    }
//
//    public static int diagonalSum(int value) {
//        int n = operation.length;
//        int m = operation[0].length;
//        int i=map.get(value)[0];
//        int j=map.get(value)[1];
//        int value_left_up = (i > 0 && j > 0) ? operation[i - 1][j - 1] : 0;
//        int value_right_up = (i > 0 && j < m - 1) ? operation[i - 1][j + 1] : 0;
//        int value_left_down = (i < n - 1 && j > 0) ? operation[i + 1][j - 1] : 0;
//        int value_right_down = (i < n - 1 && j < m - 1) ? operation[i + 1][j + 1] : 0;
//        int sum = value_left_up + value_right_down + value_left_down + value_right_up;
//        return sum;
//    }
//
//    public static void main(String[] args) {
////        int[][] grid = {
////                {0,1,2},
////                {3,4,5},
////                {6,7,8}
////        };
//        int[][] grid = {
//                {1,2,0,3},
//                {4,7,15,6},
//                {8,9,10,11},
//                {12,13,14,5}
//        };
//        NeighborSum obj = new NeighborSum(grid);
//        System.out.println(obj.adjacentSum(15));
////        System.out.println(obj.adjacentSum(4));
////        System.out.println(obj.diagonalSum(4));
//        System.out.println(obj.diagonalSum(9));
//    }
//}

public class NeighborSum {
    public int[][] operation;
    public HashMap<Integer, int[]> map;

    public NeighborSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        operation = new int[n][m];
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                operation[i][j] = grid[i][j];
                map.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Value not found in the grid");
        }
        int n = operation.length;
        int m = operation[0].length;
        int i = map.get(value)[0];
        int j = map.get(value)[1];
        int value_up = (i > 0) ? operation[i - 1][j] : 0;
        int value_down = (i < n - 1) ? operation[i + 1][j] : 0;
        int value_left = (j > 0) ? operation[i][j - 1] : 0;
        int value_right = (j < m - 1) ? operation[i][j + 1] : 0;
        int sum = value_up + value_down + value_left + value_right;
        return sum;
    }

    public int diagonalSum(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Value not found in the grid");
        }
        int n = operation.length;
        int m = operation[0].length;
        int i = map.get(value)[0];
        int j = map.get(value)[1];
        int value_left_up = (i > 0 && j > 0) ? operation[i - 1][j - 1] : 0;
        int value_right_up = (i > 0 && j < m - 1) ? operation[i - 1][j + 1] : 0;
        int value_left_down = (i < n - 1 && j > 0) ? operation[i + 1][j - 1] : 0;
        int value_right_down = (i < n - 1 && j < m - 1) ? operation[i + 1][j + 1] : 0;
        int sum = value_left_up + value_right_down + value_left_down + value_right_up;
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 0, 3},
                {4, 7, 15, 6},
                {8, 9, 10, 11},
                {12, 13, 14, 5}
        };
        NeighborSum obj = new NeighborSum(grid);
        System.out.println(obj.adjacentSum(15));
        System.out.println(obj.diagonalSum(9));
    }
}
