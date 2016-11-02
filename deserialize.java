/*
利用栈（Stack）数据结构

遍历字符串s，记当前字符为c

如果c为'-'，则将符号变量negmul置为-1

如果c为0-9，则利用变量sigma存储数字的值

如果c为'['，则新建一个类型为列表的NestedInteger并压栈

如果c为']'或者','：

  若sigma非空，则将sigma * negmul加入栈顶元素；

  将栈顶元素弹出记为top；若此时栈非空，将top加入栈顶元素；否则返回top
*/
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
    public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack();
        int sign = 1;//pitfall:数字string转化为int，注意正负号的讨论
        Integer num = null;
        for (int i = 0; i < s.length(); i++) {
        	char cur = s.charAt(i);
        	if (cur == '-') sign = -1;
        	else if (cur >= '0' && cur <= '9') num = (num == null ? 0 : num) * 10 + (cur - '0'); //pitfall：不能在此压栈，因为可能是corner case只有数字的，战中没有peek的nestedInteger，会导致报错
        	else if (cur == '[') {
        		stack.push(new NestedInteger());
        	}
        	else {
        		if (num != null) {
        			stack.peek().add(new NestedInteger(num * sign));
        			sign = 1; //pitfall: 注意重置sign和num
        			num = null;
        		}
        		if (cur == ']') {
        			NestedInteger top = stack.pop();
        		    if (!stack.empty()) {
        			    stack.peek().add(top);
        		    }else {
        			    return top;
        		    }
        		}
        	}
        }
        return new NestedInteger(num * sign);//pitfall: 如果没有［］只有数字，则应该返回数字
    }
}