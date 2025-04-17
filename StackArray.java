package Stack;

public class StackArray{
    int size;
    int top;
    int arr[];

    StackArray(int size){
        this.size =  size;
        arr =  new int[size];
        top =-1;
    }
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isFull(){
        if(top==this.size-1){
            return true;
        }
        else{
            return false;
        }
    }

    public void push(int val){
        if(this.isFull()){
            System.out.println("The stack is oveflow!");
            return;
        }
        else{
            this.top +=1;
            this.arr[this.top] = val;
        }
    }
    public void pop(){
        if(this.isEmpty()){
            System.out.println("Stack underflow");
            return;
        }
        else{
            this.top -=1;
        }
    }

    public int peek(){

        if(this.isEmpty()){
            System.out.println("Stack underflow!");
            return 0;
        }
        else{
            System.out.println(this.arr[this.top]);
            return this.arr[this.top];
        }


    }

    public void display(){
        if(this.isEmpty()){
            System.out.println("Nothing to display");
            return;
        }
        else{
            System.out.println("The stack now looks like this!");
            for(int j=top; j>=0;j--){
                System.out.println(this.arr[j]);
            }
        }
    }

    public static void main(String args[]){
        StackArray stack = new StackArray(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("The stack now looks like this!");
        stack.display();
        System.out.println("Top element now looks like this!");
        stack.peek();
        System.out.println("The stack now looks like this aftering poping!");
        stack.pop();
        stack.display();
        stack.pop();
        stack.display();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.display();


    }



}