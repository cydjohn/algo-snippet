/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//time: O(nlogn) --> O(n^2) worst case
//space: O(logn)
public class Solution {
	int cnt = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        inPathSum(root, sum);//以该点为起点
        //不以该点为起点
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return cnt;
    }
    private void inPathSum(TreeNode root, int sum) {
    	if (root == null) return;
        if (sum == root.val) cnt++;
        inPathSum(root.left, sum - root.val);
        inPathSum(root.right, sum - root.val);
    }
}

//time O(n)
//space O(logn) -- O(n)
//hashtable -- two sum的思想
public class Solution {
    HashMap<Integer, Integer> map = new HashMap();
    public int pathSum(TreeNode root, int sum) {
        return countPathSum(root, sum, 0);
    }
    private int countPathSum(TreeNode root, int target, int curSum) {
        if (root == null) return 0;
        curSum += root.val;
        //如果diff曾经出现在hashtable中，则有这样的target成立
        int diff = curSum - target;
        int cnt = map.getOrDefault(diff, 0);
        //需要讨论相减为0的情况，因为hashtable中没有包括0的结果
        if (curSum == target) cnt++;
        if (!map.containsKey(curSum)) map.put(curSum, 1);
        else map.put(curSum, map.get(curSum)+1);
        //节点的值可能为负，所以即使已经找到结果，还需要继续便利，因为后面可能还有结果
        cnt += countPathSum(root.left, target, curSum);
        cnt += countPathSum(root.right, target, curSum);
        map.put(curSum, map.get(curSum)-1);//当遍历完一支时，取消其在hashtable中的结果，以免被其他枝干使用
        return cnt;
    }
}







