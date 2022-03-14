import java.util.Stack;

class MyQueue {
//    public static void main(String[] args) {
//        MyQueue myQueue = new MyQueue();
//        myQueue.push(1);
//        myQueue.push(2);
//        myQueue.push(3);
//        myQueue.push(4);
//        myQueue.push(5);
//        System.out.println(myQueue.peek());
//        System.out.println(myQueue.pop());
//
//        System.out.println(myQueue.peek());
//        System.out.println(myQueue.pop());
//
//        System.out.println(myQueue.peek());
//        System.out.println(myQueue.pop());
//
//        System.out.println(myQueue.peek());
//        System.out.println(myQueue.pop());
//
//        System.out.println(myQueue.peek());
//        System.out.println(myQueue.pop());
//        System.out.println(myQueue.empty());
//    }

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        this.popStack = new Stack<>();
        this.pushStack = new Stack<>();
    }

    public void push(int x) {
        if(popStack.isEmpty()){
            pushStack.add(x);
        }else{
            int sz = popStack.size();
            for(int i=0; i<sz; i++){
                pushStack.push( popStack.pop() );
            }
            pushStack.add(x);
        }
    }

    public int pop() {
        if(pushStack.isEmpty()){
           return popStack.pop();
        }else{
            int sz = pushStack.size();
            for(int i=0; i<sz; i++){
                popStack.add( pushStack.pop());
            }
            this.pushStack.clear();
            return popStack.pop();
        }
    }

    public int peek() {
        if(pushStack.isEmpty()){
            return popStack.peek();
        }else{
            int sz = pushStack.size();
            for(int i=0; i<sz; i++){
                popStack.add( pushStack.pop());
            }

            this.pushStack.clear();
            return popStack.peek();
        }
    }

    public boolean empty() {
        return (popStack.isEmpty() && pushStack.isEmpty());
    }
}

/*
*
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
*/
