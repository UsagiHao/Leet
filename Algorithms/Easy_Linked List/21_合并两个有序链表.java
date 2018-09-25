/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

思路：最普通的逐个比较大小然后插入
要注意返回的是新链表的头节点，而不是逐个插入后的最末端节点
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode result = null;
        ListNode resultHead = null;
        
        if (l2 == null) return l1;
        if (l1 == null) return l2;
        
        if (l1.val <= l2.val){
            result = l1;
            resultHead = result;
            l1 = l1.next;
        }else {
            result = l2;
            resultHead = result;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                result.next = l1;
                result = result.next;
                l1 = l1.next;
            }else {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
            }
        }
        
        while (l1 != null){
            result.next = l1;
            result = result.next;
            l1 = l1.next;
        }
        
        while (l2 != null){
            result.next = l2;
            result = result.next;
            l2 = l2.next;
        }
        return resultHead;
    }
}
