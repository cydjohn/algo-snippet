class MyQueue {
    private Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack<Integer> ans = new Stack();
        while(!stack.empty()) {
            ans.push(stack.pop());
        }
        ans.pop();
        while(!ans.empty()) {
            stack.push(ans.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack<Integer> ans = new Stack();
        while(!stack.empty()) {
            ans.push(stack.pop());
        }
        int ret = ans.peek();
        while(!ans.empty()) {
            stack.push(ans.pop());
        }
        return ret;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}