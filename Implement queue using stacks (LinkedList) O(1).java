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
    class Node {
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public MyQueue() {
        size = 0;
    }

    public void push(int x) {
        if(size == 0){
            head = new Node(x);
            tail = head;
            size++;
        }else if(size==1){
            tail = new Node(x);
            head.next = tail;
            size++;
        }else{
            Node temp = new Node(x);
            tail.next = temp;
            tail = temp;
            size++;
        }
    }

    public int pop() {
        if(size==1){
            int val = head.val;
            head = tail = null;
            size--;
            return val;
        }else{
            int val = head.val;
            head = head.next;
            size--;
            return val;
        }
    }

    public int peek() {
        return head.val;
    }

    public boolean empty() {
        return head==null;
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
