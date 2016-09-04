class MyQueue {
	private Stack<Integer> stack = new Stack();
    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> temp = new Stack();
        while (!stack.empty()) temp.push(stack.pop());
        stack.push(x);
        while (!temp.empty()) stack.push(temp.pop());
    }

    // Removes the element from in front of queue.
    public void pop() {
        stack.pop();
    }

    // Get the front element.
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty();
    }
}

