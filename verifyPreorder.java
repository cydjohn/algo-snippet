public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int min = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < min) return false;
            //当找到比当前的数要更大的数，说明这是一个右孩子，或者祖先节点的右孩子，同时也是后续节点的左孩子或者root，可将其更新为最小店节点
            while (!path.empty() && p > path.peek()) {
                min = path.pop();
            }
            path.push(p);
        }
        return true;
    }
}