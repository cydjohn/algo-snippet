/*A question before this is the Nested List Weight Sum, and it requires recursion to solve. As it carries to this problem that we will need recursion to solve it. But since we need to access each NestedInteger at a time, we will use a stack to help.

In the constructor, we push all the nestedList into the stack from back to front, so when we pop the stack, it returns the very first element. Second, in the hasNext() function, we peek the first element in stack currently, and if it is an Integer, we will return true and pop the element. If it is a list, we will further flatten it. This is iterative version of flatting the nested list. Again, we need to iterate from the back to front of the list.*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack = new Stack();
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size()-1; i >= 0; i--) {
        	stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
        	NestedInteger cur = stack.peek();
        	if (cur.isInteger()) return true;
        	stack.pop();
        	for (int i = cur.getList().size()-1; i >= 0; i--) {
        		stack.push(cur.getList().get(i));
        	}
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */