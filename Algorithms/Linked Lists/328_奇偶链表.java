/*
给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL

思路：按奇偶项拆分成两个链表，保存偶链表的头节点，与奇链表的末尾相连。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        ListNode evenHead = head.next;
        
        while (temp1.next != null && temp2.next != null){
            temp1.next = temp1.next.next;
            temp2.next = temp1.next.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        temp1.next = evenHead;
        return head;
    }
}
