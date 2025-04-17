public class LinkedList {
    Node head;
    public LinkedList()
    {
        this.head = null;
    }

    public void addHead(int value)
    {
        Node new_node = new Node(value);
        if (this.head ==null) {
            this.head = new_node;
        }

        else {
            Node temp_node = this.head; // temp -- Head
            this.head = new_node;       // head update new_node    New_node(Head) --> temp node --> node 2 --> None
            this.head.next = temp_node; // 

            new_node.next = this.head;
            this.head = new_node;
        }
    }


    public void addTail(int value)
    {
        Node new_node = new Node(value);
        if (this.head ==null) {
            this.head = new_node;
        }

        else {
            Node temp_node = this.head;
            while(temp_node.next != null)
            {
                temp_node = temp_node.next;
            }

            temp_node.next = new_node;
        }
    }

    public void display(){
        if(this.head == null)
        {
            return;
        }
        Node currNode = this.head;
        StringBuilder sb = new StringBuilder();

        while(currNode !=null)
        {
            sb.append(currNode.data);
            sb.append("-->");
            currNode = currNode.next;
        }

        System.out.println(sb.toString()+"None");

    }

    public void addAtIndex(int data, int index)
    {
        if (this.head == null)
        {
            System.out.println("The linkedlist is empty");
            return;
        }

        else {

            Node currentNode = this.head;
            Node newNode = new Node(data);

            if ((index <= -1) || (index> this.Length())){

                System.out.println("Index out of bound!");
                return;

            }

            if(index==0)
            {
                this.addHead(data);
                return;
            }

            for(int i=0; i<index-1; i++)
            {
                currentNode = currentNode.next;

            }

            Node temp_node = currentNode.next;

            currentNode.next = newNode;
            newNode.next = temp_node;
        }

    }

    public void updateHead(int newData)
    {

        // Base case

        if(this.head == null)
        {
            System.out.println("There is no data in the linked list!");
            return;
        }


        this.head.data = newData;
        System.out.println("The head has been updated!");
        return;
    }

    public boolean searchList(int target) // O(n)
    {  


        if(this.head ==null)
        {
            System.out.println("The linked list is empty");
            return false;
        }


        Node currentNode = this.head; // O(1)

        while(currentNode.next !=null)  // O(n)
        {
            if(currentNode.data == target) // O(1)
            {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;

    }

    public void updateTail(int newData)
    {

        if(this.head == null)
        {
            System.out.println("There is no data in the linked list!");
            return;
        }

        Node currentNode = this.head;
         while(currentNode.next !=null)
         {
            currentNode = currentNode.next;
         }

         currentNode.data = newData;
         System.out.println("The tail has been updated!");
         return;

    }


    public void bubbleSort() {
        if (head == null || head.next == null) {
            return; // No need to sort if list is empty or has only one element
        }

        boolean swapped;
        Node ptr1;
        Node last = null; // Marks the end of the sorted portion

        do {
            swapped = false;
            ptr1 = head;

            while (ptr1.next != last) {
                if (ptr1.data > ptr1.next.data) {
                    // Swap values
                    int temp = ptr1.data;
                    ptr1.data = ptr1.next.data;
                    ptr1.next.data = temp;
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            last = ptr1; // Reduce the range for the next iteration
        } while (swapped);
    }

    

    public Node findMid(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) slow = slow.next;
        }
        
        return slow;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head; // ✅ Corrected
        }

        Node mid = findMid(head);
        Node right = mid.next;
        mid.next = null; // Split the list into two halves

        Node leftSorted = mergeSort(head);
        Node rightSorted = mergeSort(right);

        return merge(leftSorted, rightSorted);
    }

    public Node merge(Node first, Node last) {
        if (first == null) return last;
        if (last == null) return first;

        Node dummy = new Node(-1);
        Node temp = dummy;

        while (first != null && last != null) {
            if (first.data < last.data) {
                temp.next = first;
                first = first.next;
            } else {
                temp.next = last;
                last = last.next;
            }
            temp = temp.next;
        }

        temp.next = (first != null) ? first : last;

        return dummy.next;
    }

    public boolean binarySearch(Node head, int target){
        Node mid = findMid(head);
        if (mid == null){
            return false;
        }

        
        if(mid.next == null && mid.data != target){
            return false;
        }

        if(mid.data == target ){
            return true;
        }
        else if(mid.data<target){
            return binarySearch(mid.next, target);
        }
        else if(mid.data>target){
            Node temp = mid.next;
            mid.next = null; 
            boolean result = binarySearch(head, target);
            this.head = merge(head, temp);
            return result;
        }

        else{
            return false;
        }

    }

    public void makeCycle(int pos){
        if(this.head == null){
            return;
        }
        Node temp = this.head;
        for(int j=0; j<pos; j++){
            temp = temp.next;
        }
        Node current = this.head;
        while(current.next != null)
        {
            current = current.next;
        }

        current.next = temp;
    }

    public boolean checkCycle(int pos){

        if(this.head == null){
            return false;
        }

        if (this.Length() < pos+1){
            return false;
        }

        Node temp = this.head;
        for(int j=0; j<pos; j++){
            temp = temp.next;
        }

        Node current = this.head;
        while(current.next != null)
        {
            current = current.next;
        }

        if(current.next == temp)
        {
            return true;
        }
        else{
            return false;
        }

    }




    public int Length()
    {
        if (this.head ==null)
        {
            return 0;

        }

        else{
            Node currentNode = this.head;

            int len = 1;

            while(currentNode.next !=null)
            {
                currentNode = currentNode.next;
                len +=1;
            }

            return len;
        }
    }
    
}
