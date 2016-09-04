//Deque O(n)
//In Java, Priority Queue is implemented using Heap Data Structure and Heap has O(log(n)) time complexity to insert and delete element. To chieve linear-time complexity, we can't use PQ here.
/*
遍历数组nums，使用双端队列deque维护滑动窗口内有可能成为最大值元素的数组下标
由于数组中的每一个元素至多只会入队、出队一次，因此均摊时间复杂度为O(n)
记当前下标为i，则滑动窗口的有效下标范围为[i - (k - 1), i]
若deque中的元素下标＜ i - (k - 1)，则将其从队头弹出，deque中的元素按照下标递增顺序从队尾入队。
这样就确保deque中的数组下标范围为[i - (k - 1), i]，满足滑动窗口的要求。
当下标i从队尾入队时，顺次弹出队列尾部不大于nums[i]的数组下标（这些被弹出的元素由于新元素的加入而变得没有意义）
deque的队头元素即为当前滑动窗口的最大值*/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < k || k == 0) return new int[0];
        int[] res = new int[nums.length - (k - 1)];
        Deque<Integer> dq = new LinkedList();
        for (int i = 0; i < nums.length; i++) {
        	if (!dq.isEmpty() && dq.getFirst() < i - (k - 1)) dq.removeFirst();//频繁删减dq，需要每次检查dq是否为空
        	while (!dq.isEmpty() && nums[dq.getLast()] < nums[i]) dq.removeLast();
        	dq.addLast(i);
        	if (i >= k - 1) res[i - (k - 1)] = nums[dq.getFirst()];
        }
        return res;
    }
}