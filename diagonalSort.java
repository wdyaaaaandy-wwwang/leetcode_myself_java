

public class diagonalSort {
    public static void main(String args[]) {
        int[][] mat={{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        int i=0,j=0;
        int m=mat.length;
        int n=mat[0].length;
        int[][] returnArray=new int[m][n];
        boolean[][] isSet=new boolean[m][n];
        i=m-1;
        j=0;
        while (i>=0&&i<m){
            int templength=1;
            if(i+1<m&&j+1<n){
                templength+=1;
            }
            i+=1;
            j+=1;
        }
    }
}
