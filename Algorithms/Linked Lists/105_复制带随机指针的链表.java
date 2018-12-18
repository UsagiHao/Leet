/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
要求返回这个链表的深度拷贝。

思路：使用hashmap，先存对应的节点，然后第二遍遍历的时候再给random赋值
思路二：如果要满足O（1）的空间复杂度，方法见https://www.jianshu.com/p/8b0688ed7afb，比较特殊
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> newMap=new HashMap<>();
        
        RandomListNode cur=head;
		while(cur!=null){
            RandomListNode newNode = new RandomListNode(cur.label);
			newMap.put(cur, newNode);
			cur=cur.next;
		}
		 
		cur=head;
		while(cur!=null){
			RandomListNode node = newMap.get(cur);
			node.next = newMap.get(cur.next);
			node.random = newMap.get(cur.random);
			cur=cur.next;
		}
		return newMap.get(head);
    }
//解法二：O（1)的空间复杂度
//https://www.jianshu.com/p/8b0688ed7afb
    public RandomListNode copyRandomList(RandomListNode head) {
       if(head == null)
			return null;
		
		RandomListNode pNode = head;
		
		//新节点接到原节点的后面
		while(pNode != null){
			RandomListNode clone = new RandomListNode(pNode.label);
			clone.next = pNode.next;
			pNode.next = clone;
			pNode = clone.next;
		}
		
		//参照原节点的random,改变新节点的random
		pNode = head;
		while(pNode != null){
			pNode.next.random = pNode.random == null ? null:pNode.random.next;
			pNode = pNode.next.next;
		}
		
		//将两部分分离
		pNode = head;
		RandomListNode cloneHead = head.next;
		RandomListNode cloneNode = cloneHead;
		while(pNode != null){
			pNode.next = cloneNode.next;
			if(cloneNode.next != null){
				cloneNode.next = cloneNode.next.next;
			}
			pNode = pNode.next;
			cloneNode = cloneNode.next;
		}
		return cloneHead;
    }
}
