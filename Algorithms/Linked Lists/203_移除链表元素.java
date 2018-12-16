/*
删除链表中等于给定值 val 的所有节点。

注意：要有curr和pre两个局部变量，否则单单令curr = curr.next是不好删除的
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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head.val == val){
            head = head.next;
            if (head == null) return null;
        } 
        ListNode pre = head;
        ListNode curr = head.next;
        

        while (curr!= null){
            if (curr.val == val){
                pre.next = curr.next;
                curr = curr.next;
            }else {
                pre = pre.next;
                curr = curr.next;
            }
        }
        
        return head;
    }
}
