class MyLinkedList {

    class Node{
        int value;
        Node next;
        
        public Node(){
            
        }
        
        public Node(int x){
            this.value = x;
        }
        
    }
    
    Node head;
    int size = 0;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = new Node();
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size){
            return -1;
        }
        Node t = head;
        for (int i = 0; i <= index; i++){
            t = t.next;
        }
        return t.value;   
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node t = new Node(val);
        if(head.next == null){
            head.next = t;
        }else{
            t.next = head.next;
            head.next = t;
        }
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size || index < 0){
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0){
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++){
            temp = temp.next;
        }
        Node afterTemp = temp.next;
        temp.next = afterTemp.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
