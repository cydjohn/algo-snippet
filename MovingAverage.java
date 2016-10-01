public class MovingAverage {
	Queue<Integer> q;
	int max;
	double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        q = new LinkedList();
        max = size;
        sum = 0;
    }
    
    public double next(int val) {
        if (max == q.size()) {
        	sum -= q.poll();
        }
        sum += val;
        q.offer(val);
        return sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */