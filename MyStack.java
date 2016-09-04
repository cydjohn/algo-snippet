class MyStack {
	private Queue<Integer> queue = new LinkedList();
    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> temp = new LinkedList();
        temp.offer(x);
        while (!queue.isEmpty()) temp.offer(queue.poll());
        queue = temp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}