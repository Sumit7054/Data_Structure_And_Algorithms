package DLL;

class Node {
    int val;
    Node prev ;
    Node next = null;

    public Node(int val){
        this.val = val;
        this.prev = null;
        this.next = null;
    }
    
}

public class DoubleLinkedList {
    Node head;
    Node last;


    DoubleLinkedList(){
    this.head = null;
    this.last = null;
    }

    public void addHead(int val){

        Node newNode = new Node(val);

        // Base case

        if(this.head==null){
            this.head = newNode;
            this.last = newNode;
        }
        // Other cases

        else{

            newNode.next =  this.head;
            this.head.prev = newNode;
            this.head = newNode;

        }
    }

    
    

    public void addTail(int val){
        Node newNode = new Node(val);

        if(this.head==null ){
            this.head = newNode;
            this.last = newNode;
        }

        else{
            newNode.next = null;
            newNode.prev = this.last;
            this.last.next = newNode;
            this.last = newNode;

        }

    }


    public void display(){
        if(this.head == null){
            System.out.println("The Dobly Linked List is empty");
        }
        else{
            Node current = this.head;
            System.out.print("Null");
            while(current != null){
                System.out.print("<-->");
                System.out.print(current.val);
                current = current.next;

            }
        }
        System.out.println();
    }

    public int length(){
        Node current = this.head;
        if(this.head == this.last){
            return 1;
        }
        else if(this.head == null){
            return 0;
        }
        else{
            int len=1;
            while(current.next!=null){
                current = current.next;
                len++;
            }
            return len;
        }
    }

    public void forwardTravese(){
        Node currNode = this.head;

        if(this.head == null){
            System.out.println("No list exists for forward traversal.");
            return;
        }

        if(this.head == this.last){
            System.out.println("Null <-->"+this.head.val + "<--> Null");
            return;
        }
        else{
            System.out.print("Null");
        }

        while(currNode.next != null){
            System.out.print("<-->");
            System.out.print(currNode.val);
            currNode = currNode.next;
        }
        System.out.print("<--> Null");

    }

    public void backwardTravese(){
        Node currNode = this.last;

        if(this.last == null){
            System.out.println("No list exists for forward traversal.");
            return;
        }

        if(this.head == this.last){
            System.out.println("Null <-->"+this.head.val + "<--> Null");
            return;
        }
        else{
            System.out.print("Null");
        }

        while(currNode.prev != null){
            System.out.print("<-->");
            System.out.print(currNode.val);
            currNode = currNode.prev;
        }
        System.out.print("<--> Null");

    }

    public void deleteAt(int index){
        if(index == -1 || index > this.length()-1){
            System.out.println("Index out of bound!");
            return;
        }

        // Base case
        if(this.head==null){
            System.out.println("Node can't be deleted in empty list");
            return;
        }

        if(this.head==this.last && index==0){
            this.head = null;
            this.last = null;
            return;

        }

        if(index ==0){
            this.removeHead();
            return;
        }

        if(index == this.length()-1){
            this.removeTail();
            return;
        }

        Node currentNode = this.head;
        for(int i =1; i <= index-1; i++){
            currentNode = currentNode.next;
        }

        currentNode.next = currentNode.next.next;
        currentNode.next.prev = currentNode;

    }

    public void removeHead(){
        if(this.head ==null){
            System.out.println("List is empty!");
            return;
        }
        this.head = this.head.next;
        this.head.prev = null;
    }

    public void removeTail(){
        if(this.head ==null){
            System.out.println("List is empty!");
            return;
        }
        this.last = this.last.prev;
        this.last.next = null;
    }

    public void delete(){
        this.head=null;
        this.last = null;
    }

    // Searching Methods

    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next!=null){
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean binarySearch(int target, Node head) {
        if (head == null) return false; // Base case: Empty list

        Node mid = findMid(head);
        if (mid == null) return false; // Edge case

        if (mid.val == target) {
            return true;
        } else if (target < mid.val) {
            // Search in left half
            Node temp = head;
            while (temp.next != mid) {
                temp = temp.next;
            }
            temp.next = null; // Break the list at mid
            return binarySearch(target, head);
        } else {
            // Search in right half
            return binarySearch(target, mid.next);
        }
    }

    // Linear Search

    public boolean linearSearch(int target){

        if(this.head.val==target){
            return true;
        }

        if(this.last.val == target){
            return true;
        }

        Node currNode = this.head;
        while(currNode!=null){
            if(currNode.val == target){
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }

    // Sorting Algorithm

    public void bubbleSort() {
        if (this.head == null || this.head.next == null) return;
    
        boolean swapped;
        Node lastSorted = null;  
    
        do {
            swapped = false;
            Node current = this.head;
    
            while (current.next != lastSorted) {
                Node nextNode = current.next;
    
                if (current.val > nextNode.val) {
                    swapNodes(current, nextNode);
                    swapped = true;
                    if (this.head == current) {
                        this.head = nextNode;
                    }
                } else {
                    current = current.next;
                }
            }

            lastSorted = current;
        } while (swapped);
    }
    
    
    private void swapNodes(Node left, Node right) {
        if (left.prev != null) left.prev.next = right;
        if (right.next != null) right.next.prev = left;
    
        left.next = right.next;
        right.prev = left.prev;
    
        right.next = left;
        left.prev = right;
    }
    


    // Selection sort

    public Node findMin(Node head){
        
        if(head ==null){
            return null;
        }
        Node min=head;

        while(head.next!=null){
            head = head.next;
            if(min.val > head.val){
                min = head;
            }

        }
        return min;
    }

    public void selectionSort() {
        if (head == null || head.next == null) return; // No need to sort if 0 or 1 elements
    
        Node currentNode = head;
    
        while (currentNode != null) {
            Node miNode = findMin(currentNode);
    
            if (currentNode != miNode) {
                swapNodes(currentNode, miNode);
            }
    
            currentNode = currentNode.next;
        }
    }
    

    
 


    public void insertNode(int val, int index) {
        Node newNode = new Node(val);
    
        // Index out of bound
        if (index < 0 || index > this.length()) {
            System.out.println("Index out of bound!");
            return;
        }
    
        // Base case: Empty list, insert at index 0
        if (this.head == null) {
            if (index == 0) {
                this.head = newNode;
                return;
            } else {
                System.out.println("Cannot insert at index " + index + " in an empty list.");
                return;
            }
        }
    
        // Insert at head
        if (index == 0) {
            this.addHead(val);
            return;
        }
    
        // Insert at tail
        if (index == this.length()) {
            this.addTail(val);
            return;
        }
    
        // Traverse to the node before the index
        Node current = this.head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
    
        // Insert newNode in between
        Node temp = current.next;
        current.next = newNode;
        newNode.prev = current;
        newNode.next = temp;
    
        if (temp != null) {
            temp.prev = newNode;
        }
    }
    

    public static void main(String[] args){
        DoubleLinkedList dLL =  new DoubleLinkedList();

        dLL.addTail(10);
        System.out.println("Adding tail with value 10");
        dLL.display();
        System.out.println("Adding tail with value 3");
        dLL.addTail(3);
        dLL.display();
        System.out.println("Adding head with value 15");
        dLL.addHead(15);
        dLL.display();
        System.out.println("Insert at index 1 value 23");
        dLL.insertNode(23, 1);
        dLL.display();
        System.out.println("Insert at index 2 value 13");
        dLL.insertNode(13, 2);
        dLL.display();
        System.out.println("Sort using bubble sort algorithm");
        dLL.bubbleSort();
        dLL.display();
        System.out.println("Search using linear search");
        boolean found = dLL.linearSearch(23);
        String result = found ? "The value has been found" : "The value has not been found in the list";
        System.out.println(result);

        // Binary Search

        System.out.println("Perform binary search now");
        found = dLL.binarySearch(23, dLL.head);
        result = found ? "The value has been found" : "The value has not been found in the list";
        System.out.println(result);

        // Check Length

        System.out.println("Checking DLL length now.");
        System.out.println(dLL.length());

        // Delete at an index

        System.out.println("Delete at index 2");
        System.out.println("Before deleting:");
        dLL.display();
        dLL.deleteAt(2);
        dLL.display();

        // Remove head

        System.out.println("Remove head now.");
        dLL.removeHead();
        dLL.display();

        // Remove Tail/Last now

        System.out.println("Remove tail now.");
        dLL.removeTail();
        dLL.display();

        // Remove List now

        System.out.println("Delete the list now");
        dLL.delete();
        dLL.display();



    }
}