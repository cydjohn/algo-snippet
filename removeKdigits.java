/*思路：其基本思想是利用栈尽量维持一个递增的序列，也就是说将字符串中字符依次入栈，如果当前字符串比栈顶元素小，并且还可以继续删除元素，那么就将栈顶元素删掉，这样可以保证将当前元素加进去一定可以得到一个较小的序列．也可以算是一个贪心思想．最后我们只取前len-k个元素构成一个序列即可，如果这样得到的是一个空串那就手动返回０．还有一个需要注意的是字符串首字符不为０*/
public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        for (char c : num.toCharArray()) {
        	while (k > 0 && !stack.empty() && c < stack.peek()) {
        		k--;
        		stack.pop();
        	}
        	stack.push(c);
        }
        while (!stack.empty() && k > 0) {
            stack.pop();
            k--;
        }
        String res = "";
        while (!stack.empty()) res = stack.pop() + res;
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') i++;
        res = res.substring(i);
        return res.length() == 0 ? "0" : res;
    }
}