/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

说明：不允许修改给定的链表。

示例 1：

输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。

思路：设开始节点到入环节点距离为a，入环节点到相遇节点为b，相遇节点到入环节点距离为c，快慢指针相遇时快指针比慢指针多跑一个环，
则a + b + c + b = 2 (a + b)，推出a = c，此时让慢指针回到头节点，快慢指针每次各走一步，最后就能在入环节点的位置处相遇了。
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (head == null || head.next == null) return null;
        
        while (fast!= null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        
        slow = head;
        
        if (fast == null || fast.next == null){
            return null;
        }
        
       while (fast != slow){
           fast = fast.next;
           slow = slow.next;
       }
        
        return slow;
    }
}

