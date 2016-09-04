//Binary Search O(nlogn)
/*这道题给定我们一个数组，让我们计算每个数字右边所有小于这个数字的个数，目测我们不能用brute force，OJ肯定不答应，那么我们为了提高运算效率，首先可以使用用二分搜索法，思路是将给定数组从最后一个开始，用二分法插入到一个新的数组，这样新数组就是有序的，那么此时该数字在新数组中的坐标就是原数组中其右边所有较小数字的个数.*/
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
        List<Integer> list = new ArrayList();//new sorted array
        for (int i = nums.length-1; i >= 0; i--) {
        	int start = 0, end = list.size()-1;
        	while (start <= end) {
        		int mid = start + (end - start)/2;
        		if (list.get(mid) >= nums[i]) end = mid - 1; //由于题目要求统计严格小于nums[i]的数，所以如果有重复连续的num（即list.get(mid) == nums[i]），插入的位置应该总是最左边
        		else start = mid + 1;
        	}
        	res.add(0, start);
        	list.add(start, nums[i]);
        }
        return res;
    }
}

//Binary Search Tree O(nlogn)
/*构造一棵二分搜索树，稍有不同的地方是我们需要加一个变量smaller来记录比当前节点值小的所有节点的个数，我们每插入一个节点，会判断其和根节点的大小，如果新的节点值小于根节点值，则其会插入到左子树中，我们此时要增加根节点的smaller，并继续递归调用左子节点的insert。如果节点值大于根节点值，则需要递归调用右子节点的insert并加上根节点的smaller，并加1.*/
public class Solution {
    List<Integer> res = new ArrayList();
	class TreeNode {
		int val, smaller;
		TreeNode left, right;
		public TreeNode(int v, int s) {
			val = v;
			smaller = s;
		}
	}
    public List<Integer> countSmaller(int[] nums) {
        TreeNode root = null;
        for (int i = nums.length-1; i >= 0; i--) {
        	root = insert(root, nums[i], 0);
        }
        return res;
    }
    private TreeNode insert(TreeNode root, int x, int xs) {
    	if (root == null) {
    		root = new TreeNode(x, 0);
    		res.add(0, xs);
    	}
    	else if (root.val > x) {
    		root.smaller++;
    		root.left = insert(root.left, x, xs);
    	}
    	else root.right = insert(root.right, x, xs + root.smaller + (root.val < x ? 1 : 0)) ;
    	return root;
    }
}