class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int turn = 1;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (empty()) {
       
            queue2.add(x);
        } else if (turn == 1) {
            queue1.clear();
            queue1.add(x);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.poll());
            }
            turn = 2;
        } else {
            queue2.clear();
            queue2.add(x);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.poll());
            }
            turn = 1;
        }

    }

    public int pop() {
        if (empty()) {
            return 0;
        } else if (turn == 1) {
            return queue2.poll();
        } else {
            return queue1.poll();
        }
    }

    public int top() {
        if (empty()) {
            return 0;
        } else if (turn == 1) {
            return queue2.peek();
        } else {
            return queue1.peek();
        }
    }

    public boolean empty() {
        return (queue1.isEmpty() && queue2.isEmpty());
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