/*
编写一个程序，找到两个单链表相交的起始节点。
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8

思路：相交的那一部分完全一致，因此可以先计算两个链表的长度，然后将它们的头节点均移动到两个链表长度相等的地方，之后寻找相等的节点即可。
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null) return null;
        if (headB == null) return null;
        int lengthA = 0;
        int lengthB = 0;
        
        ListNode temp = headA;
        while (temp.next != null){
            lengthA++;
            temp = temp.next;
        }
        
        temp = headB;
        while (temp.next != null){
            lengthB++;
            temp = temp.next;
        }
        
        while (lengthA > lengthB){
            headA = headA.next;
            lengthA--;
        }
        
        while (lengthA < lengthB){
            headB = headB.next;
            lengthB--;
        }
        
        while (headA != null || headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
}
