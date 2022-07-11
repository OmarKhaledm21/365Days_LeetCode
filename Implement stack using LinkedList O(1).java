class MyStack {

     LinkedList<Integer> list_stack;
  

    public MyStack() {
        list_stack = new LinkedList<>();
    }

    public void push(int x) {
       list_stack.push(x);
    }

    public int pop() {
        if(!empty()){
            return list_stack.pop();
        }
        return 0;
    }

    public int top() {
        if(!empty()) {
            return list_stack.peek();
        }
        return 0;
    }

    public boolean empty() {
        return list_stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */