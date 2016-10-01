//binary search nlog(n)
public class MedianFinder {
	List<Integer> list = new ArrayList();
    // Adds a number into the data structure.
    public void addNum(int num) {
        int left = 0, right = list.size()-1;
        while (left <= right) {
        	int mid = left + (right - left) / 2;
        	if (num <= list.get(mid)) {
        		right = mid - 1;
        	} else {
        		left = mid + 1;
        	}
        }
        list.add(left, num);//what is the complexity?
    }

    // Returns the median of current data stream
    public double findMedian() {
    	int size = list.size();
        if (size % 2 == 0) {
        	return (list.get(size/2) + list.get(size/2-1))/2.0;
        }else {
        	return list.get(size/2);
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();