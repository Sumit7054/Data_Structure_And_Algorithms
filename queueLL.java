package queue;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
        this.next = null;
    }
}
public class queueLL {
    Node front, rear;
    int size;
    queueLL(int size){
        this.front = null;
        this.rear = null;
        this.size = size;
    }
    public boolean isFull()
    {
      Node current=this.rear;
      int count=1;
      while(current.next!=null){
          current=current.next;
          count +=1;
      }
      if(this.size <= count){
          return true;
      }
      return false;
    }

    public void enqueue(int val)
    {
        Node newNode = new Node(val);
        if(rear == null){
            front = rear = newNode;
            return;
        }
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        newNode.next = this.rear;
        this.rear = newNode;
        return;
    }
    public int dequeue()
    {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        Node current = this.rear;
        while(current.next != front){
            current = current.next;
        }
        int dequeuedValue = front.val;
        current.next = null;
        this.front = current;
        return dequeuedValue;
    }
    public int peek()
    {
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return front.val;
    }

    public boolean isEmpty()
    {
        return this.front == null;
    }

    public static void main(String[] args) {
        queueLL q = new queueLL(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Front element is: " + q.peek());
        System.out.println("Dequeued element is: " + q.dequeue());
        System.out.println("Front element is: " + q.peek());
    }
}

