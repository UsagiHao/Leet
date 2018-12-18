/*
您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
示例:
输入:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL
输出:
1-2-3-7-8-11-12-9-10-4-5-6-NULL

思路：依次遍历，处理child != null的节点（关于节点原本的next节点无法保存的问题，由于在处理child的节点的时候不去判断child节点连接的子链表是否有child节点，而是只用一层for循环留待之后再去判断，所以其实next节点是可以保存的）
思路二：当处理child节点的时候同时判断它连接的子链表中是否还会有子链表，使用stack保存每次遇到子链表的节点的next节点
*/
/*
// Definition for a Node.
//解法一：
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        for(Node p = head; p != null; p = p.next){
            Node n = p.next;
            if(p.child != null){
                Node c = p.child;
                p.next = c;
                c.prev = p;
                p.child = null;
                Node t = c;
                while(t != null && t.next != null)
                    t = t.next;
                t.next = n;
                if(n != null)
                    n.prev = t;
            }
        }
        return head;        
    }
}

//解法二
class Solution {
    public Node flatten(Node head) {
        if(head==null) return head;
        Node p=head;
        Stack<Node> s=new Stack<Node>();
        while(p!=null){
            if(p.child!=null){
                s.push(p.next);
                p.next=p.child;
                if(p.next!=null) p.next.prev=p;
                p.child=null;
            }else if(p.next==null&&!s.empty()){
                p.next=s.pop();
                if(p.next!=null) p.next.prev=p;
            }
            p=p.next;
        }
        return head;
    }
}
