package SCL;

public class CLL {
    Node last;

    public CLL(){
        this.last = null;
    }

    public void addTail(int val){
        Node newNode = new Node(val);
        if(this.last==null){
            this.last = newNode;
            this.last.next = newNode;
        }
        else{
            Node head = this.last.next;
            this.last.next = newNode;
            newNode.next = head;
        }
    }

    public void addHead(int val){
        Node newNode = new Node(val);
        if(this.last==null){
            addTail(val);
            return;
        }
        else{
            Node head = this.last.next;
            this.last.next = newNode;
            newNode.next = head;
        }
    }

    public void delTail(){
        if(this.last ==null){
            System.out.println("Empty singly circular node can't be deleted");
            return;
        }
        else if(this.last == this.last.next){
            this.last = null;
            return;
        }
        else{
            Node lastNode = this.last;
            Node headNode = this.last.next;
            Node current = this.last.next;
            while(current.next!= lastNode){
                current = current.next;
            }
            current.next = headNode;
            this.last = current;
        }
    }

    public void dispaly(){
        if(this.last==null){
            System.out.println("The CLL is empty");
        }
        else{
            Node head = this.last.next;
            Node current = head;
            while (current !=head.next) {
                System.out.print(current.data+"-->");
                current = current.next;
            }
        }
    }

    public static void main(String[] args){
        CLL cLL = new CLL();
        cLL.addTail(2);
        cLL.dispaly();
        cLL.addHead(5);
        cLL.dispaly();
        cLL.addHead(15);
        cLL.dispaly();
        System.out.println("Deleting tails one by one now...");
        cLL.delTail();
        cLL.dispaly();
        cLL.delTail();
        cLL.dispaly();
        cLL.delTail();
        cLL.dispaly();

}
}
