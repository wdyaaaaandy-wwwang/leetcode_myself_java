import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class maxSatisfied {
    public static void main(String args[]){
//        int[] grumpy={0,1,0,1,0,1,0,1};
//        int[] customers={1,0,1,2,1,1,7,5};
//        int n=grumpy.length;
//        int minutes=3;
//        int maxStart=0;
//        int maxEnd=0;
//        int maxSum=0;
////        int temp=0;
//        for(int i=0;i<=n-minutes;i++){
//            int temp=0;
//            for(int j=0;j<minutes;j++){
//                temp=temp+customers[i+j];
//            }
//            if(temp>maxSum){
//                maxSum=temp;
//                maxStart=i;
//                maxEnd=i+minutes-1;
//            }
//        }
//        System.out.println(maxSum);

//        boolean[] isFoundMax=new boolean[n];
//        int i=0;
//        while (i<n){
//            if (i>=maxStart&&i<=maxEnd){
//                isFoundMax[i]=true;
//                i++;
//            }else {
//                isFoundMax[i]=false;
//                i++;
//            }
//        }
//        int j=0;
//        int returnSum=0;
//        while (j<n){
//            if (isFoundMax[j]==false){
//                if (grumpy[j]!=1){
//                    returnSum=returnSum+customers[j];
//                }
//                j++;
//            }
//        }
//        returnSum=returnSum+maxSum;
//        System.out.println(returnSum);
        int[][] array = {{3, 7}, {1, 5}, {2, 4}, {5, 9}, {4, 8}};
        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));

        // 输出排序后的二维数组
        Arrays.stream(array).map(Arrays::toString).forEach(System.out::println);

        int[][] intervals={{1,3},{2,6},{8,10},{15,18}};
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.stream(intervals).map(Arrays::toString).forEach(System.out::println);
        int m=intervals.length;
        int aim=0;
        int i=0;
        int j=1;
        boolean[] isRap=new boolean[m];
        List<List<Integer>>returnList=new LinkedList<>();
        List<List<Integer>>originList=new LinkedList<>();
        for (i=0;i<m;i++){
            List<Integer>temp=new LinkedList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            originList.add(temp);
        }
        i=0;

        while (i<m&&j<m){
            int temp1=intervals[i][1];
            int temp2=intervals[j][0];
            if (temp2<temp1){
                aim++;
                isRap[i]=true;
                isRap[j]=true;
                List<Integer>tempList=new LinkedList<>();
                tempList.add(intervals[i][0]);
                tempList.add(intervals[j][1]);
            }
            i++;
            j++;
        }
        int returnLength=m-aim;
//        int[][] returnArray=new int[returnLength][2];
//        i=0;
//        j=1;
//        while (i<m&&j<m){
//
//        }
    }
}
