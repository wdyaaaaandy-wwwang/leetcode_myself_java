

public class maxHeightOfTriangle {
    public static int maxHeight(int x,int y) {
        int i=1;
        do {
            if (i%2==1){
                x=x-i;
                if (x<0){
                    return i-1;
                }
            }else if (i%2==0){
                y=y-i;
                if (y<0){
                    return i-1;
                }
            }
            i++;
        }while (true);
        //return 0;
    }
    public static void main(String[] args) {
        int red=10;
        int blue=1;
        //以下是我的解法，满足样例但是没有算出来
//        int result=1;
//        int dept=1;
//        int more=0;
//        int less=0;
//        if(red<blue){
//            more=blue;
//            less=red;
//        } else if (red>blue) {
//            more=red;
//            less=blue;
//        }
//        while (more>=0&&less>=0){
//            if ((more-dept)>=0||(less-(dept+1))>=0){
//                more=more-dept;
//                less=less-(dept+1);
//                dept=dept+2;
//                result=result+1;
//            }else {
//                break;
//            }
//        }
        //return result;
        //以下是标准解法
        System.out.println(Math.max(maxHeight(red,blue),maxHeight(blue,red)));

    }
}
