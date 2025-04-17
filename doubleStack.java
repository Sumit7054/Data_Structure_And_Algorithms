package Stack;

class doubleStack {
    int size;
    int arr[];
    int topf;
    int topb;

    public doubleStack(int size){
        this.size = size;
        this.arr = new int[size];
        this.topf=-1;
        this.topb = size;
    }

    public boolean isEmpty(){
        return (this.topf==-1 || this.topb==this.size);
    }
    
    
    public boolean isFull(){
        return this.topf >= this.topb-1;
    }


    public void pushf(int val){
        if(this.isFull()){
            System.out.println("Stackoverflow.");
            return;
        }

        this.topf +=1;
        this.arr[this.topf] = val;
    }

    public void pushb(int val){
        if(this.isFull()){
            System.out.println("Stackoverflow.");
            return;
        }
        this.topb -=1;
        this.arr[this.topb] = val;

    }
    
    public int peekf(){
        return this.arr[this.topf];
    }

    public int peekb(){
        return this.arr[this.topb];
    }

    public void popf(){
        if(this.isEmpty()){
            return;
        }
        this.topf -=1;
    }

    public void popb(){
        if(this.isEmpty()){
            return;
        }
        this.topb +=1;
    }

    public static void main(String args[]){
        doubleStack stack = new doubleStack(5);

        stack.pushf(1);
        stack.pushb(2);  
        stack.pushf(3);
        stack.pushf(4);
        stack.pushb(5);
        stack.pushb(7);
        System.out.println("Top elements top and bottom now looks like this!");
        System.out.println(stack.peekf());
        System.out.println(stack.peekb());
        System.out.println("The stack now looks like this aftering poping!");
        stack.popf();
        stack.popb();
        stack.popf();
        stack.popb();
        stack.popb();
        System.out.println("All elements are removed.");
    }
    
}