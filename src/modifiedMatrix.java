import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/7/6 16:47
 * @Description 3033.修改矩阵
 */

public class modifiedMatrix {
    public static int Swap(int i,int j,int[][] matrix){
        int length=matrix[0].length;
        int[] temp=new int[length];
        int max=matrix[0][j];
        int returnNum=0;
        for (int a=0;a<matrix.length;a++){
            temp[a]=matrix[a][j];
            if (temp[a]>=max){
                max=temp[a];
                returnNum=max;
            }
        }
        return returnNum;
    }
    public static void main(String[] args){
        int[][] matrix={{1,2,-1},{4,-1,6},{7,8,9}};
        int m= matrix.length;
        int n= matrix[0].length;
        int[][] res=new int[m][n];
        List<Integer>aimColumns=new ArrayList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (matrix[i][j]!=-1){
                    res[i][j]=matrix[i][j];
                }else {
                    res[i][j]=Swap(i,j,matrix);
                }
            }
        }
        //System.out.println(Arrays.toString(res));
        for (int i=0;i< res.length;i++){
            for (int j=0;j<res[0].length;j++){
                System.out.println(res[i][j]);
                //System.out.println("\n");
            }
        }
    }
}
