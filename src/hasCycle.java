import java.util.ArrayList;
import java.util.List;

/**
 * @author Andy_Wang
 * @version 1.0
 * @description: 141. 环形链表 简单  自己写出来解法一 一次过 且解法一是官方解法一  官方解法二（龟兔赛跑思想）
 * @date 2024/12/10 14:48
 */
public class hasCycle {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public boolean hasCycle(ListNode head) {
        boolean ifHasCycle = false;
        List<ListNode> haveFoundlist = new ArrayList<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            if (!haveFoundlist.contains(cur)) {
                haveFoundlist.add(cur);
                cur = cur.next;
            }else {
                ifHasCycle = true;
                break;
            }
        }
        return ifHasCycle;
    }
        //官方解法2：快慢指针
        public boolean hasCycle_official_two(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }

    public ListNode detectCycle(ListNode head) {
        List<ListNode>FoundList=new ArrayList<>();
        boolean found=false;
        while (!found) {
            if (FoundList.contains(head)) {
                found=true;
                break;
            }else {
                FoundList.add(head);
                head = head.next;
            }
        }
        return head;
    }
}
