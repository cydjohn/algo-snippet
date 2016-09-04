/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//divide and conquer
/*给定整数n，求输入元素为[1，n]时，所构成的全部二叉查找树；
我们都知道二叉查找树的特点，左子树节点值小于根节点，右子树节点值大于根节点。
对于输入[1，n]，每个值 i 都可以作为根节点，小于i 的元素构成左子树，大于i 的元素构成右子树。
所以，此题的解决办法为二叉树常用递归。*/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
    	if (n == 0) return new ArrayList<TreeNode>();
        return buildTree(1, n);
    }

    private List<TreeNode> buildTree(int st, int en) {
    	List<TreeNode> ret = new ArrayList<TreeNode>();
    	if (en < st) {//if we use st or en as root node, it will generate null child
    		ret.add(null);
    		return ret;
    	}
    	for (int i = st; i <= en; i++) {
    		List<TreeNode> L = buildTree(st, i-1);
    		List<TreeNode> R = buildTree(i+1, en);
    		for (TreeNode l : L) {
    			for (TreeNode r : R) {
    				TreeNode node = new TreeNode(i);
    				node.left = l;
    				node.right = r;
    				ret.add(node);
    			}
    		}
    	}
    	return ret;
    }
}

//DP
public class Solution {
    public List<TreeNode> generateTrees(int n) {
    	List<TreeNode>[] ret = (List<TreeNode>[]) new List[n+1];
    	ret[0] = new ArrayList<TreeNode>();
    	if (n == 0) return ret[0];
    	ret[0].add(null);

    	for (int i = 1; i <= n; i++) {
    		ret[i] = new ArrayList<TreeNode>();
    		for (int j = 1; j <= i; j++) {
    			for (TreeNode l : ret[j-1]) {
    				for (TreeNode r : ret[i-j]) {
    					TreeNode node = new TreeNode(j);
    					node.left = l;
    					node.right = addClone(r, j);
    					ret[i].add(node);
    				}
    			}
    		}
    	}
    	return ret[n];
    }

    private TreeNode addClone(TreeNode x, int diff) {
    	if (x == null) return null;
    	TreeNode newNode = new TreeNode(x.val + diff);
    	newNode.left = addClone(x.left, diff);
    	newNode.right = addClone(x.right, diff);
    	return newNode;
    }
}