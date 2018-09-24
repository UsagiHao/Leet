/*
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

思路：关于O(1)的空间复杂度毫无思路，参考了别人的代码
设置快慢双指针，分别指向链表前半部分和后半部分，然后将后半部分链表反转，再与前半部分比较
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
    public static boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
		 
        if(fast==null||fast.next==null) return true;
        
        while(fast.next != null && fast.next.next != null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        //对链表后半段进行反转
		ListNode midNode=slow;
		ListNode firNode=slow.next;//后半段链表的第一个节点
		ListNode cur=firNode.next;//插入节点从第一个节点后面一个开始
		firNode.next=null;//第一个节点最后会变最后一个节点
		while(cur!=null){
            ListNode nextNode=cur.next;//保存下次遍历的节点
			cur.next=midNode.next;
			midNode.next=cur;
			cur=nextNode;
		}
		 
		//反转之后对前后半段进行比较
		slow=head;
		fast=midNode.next;
		while(fast!=null){
            if(fast.val!=slow.val) return false;
			slow=slow.next;
			fast=fast.next;
		}
		
        return true; 
    }
}
