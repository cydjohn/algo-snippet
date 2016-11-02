/*简单但超时的方法是window ＋ hashmap, 这里需要两个指针i和start，刚开始i和start都指向0，然后i开始向右走遍历数组，如果i和start之差大于k，且map中有nums[start]，则删除并start加一。这样保证了map中所有的数的下标之差都不大于k，然后检查存在hashmap中是否存在重复与当前元素距离为t以内的数，但是该方法对每一个数字都需要便利一遍当前的hashmap，复杂度为o(n^2)*/
/*改进第二步使用treeset, treeset类似heap会保持元素的顺序，但是他有更多功能，类似获取比当前元素小或者大的下一个元素，每一次我们能够利用这一性质比较实际顺序上相邻元素之间的距离，如果相邻的两元素的距离都小于t,则找到答案。*/
//floor(E e) Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
//ceiling(E e) Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer low = set.floor(nums[i]);
            Integer high = set.ceiling(nums[i]);
            //数可能是负的，会溢出
            if ((low != null && (long) nums[i] - low <= t) || (high != null && (long) high - nums[i] <= t)) return true;
            set.add(nums[i]);
            if (i >= k) set.remove(nums[i-k]);
        }
        return false;
    }
}