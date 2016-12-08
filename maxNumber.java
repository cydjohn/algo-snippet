/*问了一下CJL的思路~其实都差不多。我是直接原串找当前符合条件的最大的值，然后递归，他是枚举长度，然后找符合长度的。。。

第7个AC~哈哈~

我A这题的时候。。。这题一共 7个AC，410+次提交。。。通过率1%…  难度medium，现在改成hard了。。。

枚举第一个数组A的个数i，那么数组B的个数就确定了 k -i。

然后枚举出A和B长度分别为i和k-i的最大子数组，（可以用栈，类似leetcode Remove Duplicate Letters）

最后组合看看哪个大。

组合的过程类似合并排序，看看哪个数组大，就选哪个。

枚举数组长度复杂度O(k)，找出最大子数组O(n)，合并的话O(k^2)

而k最坏是m+n,所以总的复杂度就是O((m+n)^3)*/
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = Math.max(k-nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
        	int[] res1 = getMaxSubArray(nums1, i);
        	int[] res2 = getMaxSubArray(nums2, k - i);
        	int[] res = new int[k];
        	int p1 = 0, p2 = 0, p = 0;
        	while (p1 < res1.length || p2 < res2.length) {
        		res[p++] = greater(res1, p1, res2, p2) ? res1[p1++] : res2[p2++];
        	}
        	if (!greater(ans, 0, res, 0)) ans = res;
        }
        return ans;
    }
    private boolean greater(int[] nums1, int p1, int[] nums2, int p2) {
    	for (; p1 < nums1.length && p2 < nums2.length; p1++, p2++) {
    		if (nums1[p1] > nums2[p2]) return true;
    		if (nums1[p1] < nums2[p2]) return false;
    	}
    	return p1 != nums1.length;
    }
    private int[] getMaxSubArray(int[] nums, int k) {
    	int[] res = new int[k];
    	int len = 0;
    	for (int i = 0; i < nums.length; i++) {
    		while (len > 0 && len + nums.length - i > k && res[len-1] < nums[i]) {
    			len--;
    		}
    		if (len < k) res[len++] = nums[i];
    	}
    	return res;
    }
}

//wrong answer due to treatment of equal element
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int m = nums1.length, n = nums2.length;
        for (int i = 0; i <= k; i++) {
        	int k1 = Math.min(i, m);
        	int k2 = k - k1;
        	List<Integer> list1 = removeToLargest(nums1, m - k1);
        	List<Integer> list2 = removeToLargest(nums2, n - k2);
        	int p1 = 0, p2 = 0;
        	int[] res = new int[k];
        	for (int j = 0; j < k; j++) {
        		if (p1 < list1.size() && p2 < list2.size()) {
        			if (list1.get(p1) < list2.get(p2)) {
        				res[j] = list2.get(p2++);
        		    } else {
        		    	res[j] = list1.get(p1++);
        		    }
        		} else if (p1 < list1.size()) {
        			res[j] = list1.get(p1++);
        		} else {
        			res[j] = list2.get(p2++);
        		}
        	}
        }
        return res;
    }
    private List<Integer> removeToLargest(int[] nums, k) {
    	Stack<Integer> stack = new Stack();
    	for (int i = 0; i < nums.length; i++) {
    		if (stack.empty() || nums[i] < stack.peek()) {
    			stack.push(nums[i]);
    		} else {
    			while (!stack.empty() && k > 0 && nums[i] > stack.peek()) {
    				k--;
    				stack.pop();
    			}
    		}
    	}
    	while (k > 0) {
    		k--;
    	    stack.pop();
    	}
    	List<Integer> res = new ArrayList();
    	while (!stack.empty()) {
    		res.add(0, stack.pop());
    	}
    	return res;
    }
}