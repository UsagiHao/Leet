/*
反转一个单链表。

思路：递归或者迭代。递归比较易懂，但开销较大
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //迭代法
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre=null;//始终指向新链表的头部
        ListNode next=null;//当前处理节点的下一个节点
        ListNode curr=head;//当前处理的节点
        while(curr!=null){
            next=curr.next;
            curr.next=pre;
            pre=curr;//移动新链表的头指针，让它始终指向新链表头部
            curr=next;
        }
        // head=pre;
        return pre;
        
    }
}

//递归法
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
