class MyQueue {
	Stack<Integer> s1 = new Stack();
	Stack<Integer> s2 = new Stack();
    // Push element x to the back of queue.
    public void push(int x) {
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (s2.empty()) {
        	while (!s1.empty()) s2.push(s1.pop());
        }
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        if (s2.empty()) {
        	while (!s1.empty()) s2.push(s1.pop());
        }
        return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

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



