/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 148. 排序链表 中等
 * @date 2024/12/16 10:18
 */
public class sortList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head;
        ListNode q = head.next;
        ListNode r = head.next.next;
        while (q != null && q.next != null) {

        }
        return p;
    }
    public static void main(String[] args) {
        
    }
}
