/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
示例 1:
输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL

思路:取模，将尾节点前移转为头节点后移
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int length = 1;
        ListNode temp = head;
        while (temp.next != null){
            length++;
            temp = temp.next;
        }
        ListNode newTail = temp;
        ListNode newHead = head;
        k = k % length;
        
        k = length - k;
        
        for (int i = 0; i < k; i++){
            newTail.next = newHead;
            newHead = newHead.next;
            newTail = newTail.next;
            newTail.next = null;
        }
        
        return newHead;
    }
}
