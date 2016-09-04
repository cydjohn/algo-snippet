/*boolean hashset.add():Adds the specified element to this set if it is not already present. More formally, adds the specified element e to this set if this set contains no element e2 such that (e==null ? e2==null : e.equals(e2)). If this set already contains the element, the call leaves the set unchanged and returns false.*/
public class Solution {
    public boolean containsDuplicate(int[] nums) {
    if (nums.length == 0) return false;
    HashSet<Integer> set = new HashSet();
    for (int i : nums) {
    	if (!set.add(i)) return true;
    } 
    return false;
    }
}

//older version
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

