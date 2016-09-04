public class Solution {
    public int calculate(String s) {
    	int len = s.length(); int sign = 1; int res = 0;
    	Stack<Integer> stack = new Stack();
    	for (int i = 0; i < len; i++) {
    		if (Character.isDigit(s.charAt(i))) {
    			int num = s.charAt(i) - '0';
    			while (i < len-1 && Character.isDigit(s.charAt(i+1))) {
    				num = num * 10 + (s.charAt(i+1) - '0');
    				i++;
    			}
    			res += num * sign;
    		}
    		else if (s.charAt(i) == '+') sign = 1;
    		else if (s.charAt(i) == '-') sign = -1;
    		else if (s.charAt(i) == '(') {
    			stack.push(res);
    			stack.push(sign);
    			res = 0;
    			sign = 1;
    		}
    		else if (s.charAt(i) == ')') res = res * stack.pop() + stack.pop();
    	}
    	return res;
    }
}