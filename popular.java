//给一个sorted array,  定义popular number是array里出现次数>= array_size/4的数，要找最小的popular number，要求时间O(logn).
public class Solution {
	public int popular(int[] arr) {
		if (arr.length == 0) return 0;
		int min = Integer.MAX_VALUE;
		for (int i = arr.length/4 - 1; i < arr.length; i += length/4) {
			int left = leftBS(arr, i);
			int right = rightBS(arr, i);
			if (right - left >= arr.length / 4) min = Math.min(min, arr[i]);
		}
		return min;
	}
	private int leftBS(int[] arr, int i) {
		int l = 0, r = i;
		while (l <= r) {
			int m = l + (r - l)/2;
			if (arr[m] >= arr[i]) r = m - 1;
			else l = m + 1;
		}
		return l;
	}
	private int rightBS(int[] arr, int i) {
		int l = i, r = arr.length - 1;
		while (l <= r) {
			int m = l + (r - l)/2;
			if (arr[m] <= arr[i]) l = m + 1;
			else r = m - 1;
		}
		return r;
	}
}