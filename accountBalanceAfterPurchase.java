/**
 * @author Andy Wang
 * @version 1.0
 * @date 2024/6/12 14:55
 * @Description 2806.取整购买后的账户余额  简单     已自己写出来！
 */
public class accountBalanceAfterPurchase {
    public static void main(String[] agrs){
        int purchaseAmount = 17;
        int old=0;
//        int res=0;
        int allSum=100;
        int res=0;
        if (purchaseAmount%10==5){
            //return allSum-((purchaseAmount/10+1)*10;
            System.out.println(allSum-((purchaseAmount/10+1)*10));
        }

        boolean isFound=false;
        int current=Math.abs(old-purchaseAmount);
        while (old<=100){
            int temp=Math.abs(old-purchaseAmount);
            if (temp<=current){
                res=old;
                current=temp;
                //isFound=true;
            }
            old=old+10;
        }
        //return allSum-res;
        System.out.println(allSum-res);
    }
}
