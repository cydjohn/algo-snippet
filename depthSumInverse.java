/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
	int max = 0;
	List<NestedLevel> temp = new ArrayList();
	class NestedLevel {
		int val;
		int level;
		public NestedLevel(int val, int level) {
			this.val = val;
			this.level = level;
		}
	}
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int sum  = 0;
        dfs(nestedList, 1);
        for (NestedLevel t : temp) {
        	sum += t.val * (max - t.level + 1);
        }
        return sum;
    }
    private void dfs(List<NestedInteger> list, int depth) {
    	if (list.size() == 0) return;
    	if (depth > max) max = depth;
    	for (NestedInteger i : list) {
    		if (i.isInteger()) {
    			NestedLevel node = new NestedLevel(i.getInteger(), depth);
    			temp.add(node);
    		}else {
    			dfs(i.getList(), depth+1);
    		}
    	}
    }
}

