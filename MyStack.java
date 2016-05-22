class MyStack {
	private Queue<Integer> queue;
	public MyStack() {
		queue = new LinkedList();
	}
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> temp = new LinkedList();
        while (queue.size() > 1) {
        	temp.offer(queue.poll());
        }
        queue = temp;
    }

    // Get the top element.
    public int top() {
        Queue<Integer> temp = new LinkedList(queue);
        int ans = 0;
        while (!temp.isEmpty()) {
        	ans = temp.poll();
        }
        return ans;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }


}