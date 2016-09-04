//利用一个辅助栈，保存当前元素对应栈的最小值。
public class MinStack {
    Stack<Integer> data;
    Stack<Integer> minData;
    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack();
        minData = new Stack();
    }
    
    public void push(int x) {
        data.push(x);
        if (minData.empty() || minData.peek() > x) minData.push(x);
        else minData.push(minData.peek());
    }
    
    public void pop() {
        data.pop();
        minData.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return minData.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */