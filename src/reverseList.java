/**
 * @author Andy_Wang
 * @version 1.0
 * @description:
 * @date 2024/12/9 14:48
 */
public class reverseList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public  static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public  static boolean isPalindrome(ListNode head) {
        boolean result = true;
        ListNode reversed = reverseList(head);
        ListNode curr = head;
        while (curr != null&&reversed!=null) {
            if (curr.val != reversed.val) {
                result = false;
                break;
            }
            curr = curr.next;
            reversed = reversed.next;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] tests={1,1,2,1};
        int i=0;
        ListNode phead=null;
        ListNode p=null;
        while(i<tests.length) {
            if(phead==null) {
                ListNode temp=new ListNode(tests[i]);
                phead=temp;
                p=phead;
                i=i+1;
            }else {
                ListNode temp=new ListNode(tests[i]);
                phead.next=temp;
                phead=temp;
                i=i+1;
            }
        }
        System.out.println(isPalindrome(p));
    }
}
