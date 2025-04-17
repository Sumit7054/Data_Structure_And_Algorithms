package Stack;

class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
        this.next = null;

    }

}

// Dynamic Stack with LL
public class StackLinkedList {
    Node top;

    public StackLinkedList(){
        this.top = null;
    }

    public void push(int val){
        Node newNode = new Node(val);
        if(this.isEmpty()){
            this.top = newNode;
        }
        else{
            newNode.next = this.top;
            this.top = newNode;
        }
    }

    public boolean isEmpty(){
        return this.top==null;
    }


    public int pop(){
        if(this.isEmpty()){
            System.out.println("Stack underflow");
            return -1;
        }
        else{
            int temp = this.top.val;
            this.top = this.top.next;
            return temp;
        }
    }

    public int peek(){
        if(this.isEmpty()){
            return -1;
        }
        return this.top.val;
    }

    public static void main(String args[]){
        StackLinkedList stack = new StackLinkedList();
        System.out.println("Pushing 3 into the stack:");
        stack.push(3);
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
    
}
