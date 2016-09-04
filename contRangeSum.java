//Fenwick Tree
//https://discuss.leetcode.com/topic/33749/an-o-n-log-n-solution-via-fenwick-tree
//Merge Sort
//https://discuss.leetcode.com/topic/33738/share-my-solution/2
//http://www.cnblogs.com/grandyang/p/5162678.html
/*求出和，然后离散化，接着从右向左扫描，对每个i 查询满足在[ lower + sum[i – 1], upper + sum[i – 1] ]范围内的个数（用线段树或者Fenwick Tree）*/
public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        List<Long> cand = new ArrayList<>();
        cand.add(Long.MIN_VALUE); // make sure no number gets a 0-index.
        cand.add(0L);
        long[] sum = new long[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            cand.add(sum[i]);
            cand.add(lower + sum[i - 1] - 1);
            cand.add(upper + sum[i - 1]);
        }
        Collections.sort(cand); // finish discretization

        int[] bit = new int[cand.size()];
        for (int i = 0; i < sum.length; i++) plus(bit, Collections.binarySearch(cand, sum[i]), 1);
        int ans = 0;
        for (int i = 1; i < sum.length; i++) {
            plus(bit, Collections.binarySearch(cand, sum[i - 1]), -1);
            ans += query(bit, Collections.binarySearch(cand, upper + sum[i - 1]));
            ans -= query(bit, Collections.binarySearch(cand, lower + sum[i - 1] - 1));
        }
        return ans;
    }

    private void plus(int[] bit, int i, int delta) {
        for (; i < bit.length; i += i & -i) bit[i] += delta;
    }

    private int query(int[] bit, int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) sum += bit[i];
        return sum;
    }
}