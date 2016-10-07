public class Solution {
    public int longestPalindrome(int x, int[] arr) {
    	int max = Integer.MIN_VALUE;
    	Priority<Integer> q = new PriorityQueue();
        for (int i = 0; i < arr.length; i++) {
        	if (i < x) q.add(x);
        	else {
        		if (max < q.peek()) max = q.peek();
        		q.remove(arr[i - x]);
        		q.add(arr[i]);
        	}  
        }
        return max;
    }
}