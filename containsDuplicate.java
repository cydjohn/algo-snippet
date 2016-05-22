public class Solution {
    public boolean containsDuplicate(int[] nums) {
    if (nums.length == 0) return false;
    //create a hashset and use contains method to test duplicate elements.
    HashSet<Integer> h = new HashSet();
    for (int i : nums) {
    	if (h.contains(i)) return true;
    	else h.add(i);
    } 
    return false;
    }
}