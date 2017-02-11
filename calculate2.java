public class Solution {
    public int calculate(String s) {
        int len = s.length(); 
        int lastSign = 1; 
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < len; i++) {
        	if (Character.isDigit(s.charAt(i))) {
        		int num = s.charAt(i) - '0';
        		while (i < len-1 && Character.isDigit(s.charAt(i+1))) {
        			num = num * 10 + (s.charAt(i+1) - '0');
        			i++;
        		}
        		if (lastSign == -3) stack.push(num * stack.pop());
        		else if (lastSign == -4) stack.push(stack.pop() / num);
        		else stack.push(num);
        		lastSign = 1;
        	}
        	else if (s.charAt(i) == '+') stack.push(1);
        	else if (s.charAt(i) == '-') stack.push(-1);
        	else if (s.charAt(i) == '*') lastSign = -3;
        	else if (s.charAt(i) == '/') lastSign = -4;
        }
        int res = 0;
        while (stack.size() > 1) {
        	res += stack.pop() * stack.pop();
        }
        res += stack.pop();
        return res;
    }
}

//方法2: 不使用stack版本
public class Solution {
    public int calculate(String s) {
        int len = s.length(); 
        int lastSign = 1; 
        int lastNum = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i < len-1 && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + (s.charAt(i+1) - '0');
                    i++;
                }
                if (lastSign == 3) {
                    sum = sum - lastNum + lastNum * num;
                    lastNum = lastNum * num;
                }
                else if (lastSign == 4) {
                    sum = sum - lastNum + lastNum / num; 
                    lastNum = lastNum / num;
                }
                else if (lastSign == 1) {
                    sum += num;
                    lastNum = num;
                }
                else {
                    sum -= num;
                    lastNum = -num;
                }
            }
            else if (s.charAt(i) == '+') lastSign = 1;
            else if (s.charAt(i) == '-') lastSign = 2;
            else if (s.charAt(i) == '*') lastSign = 3;
            else if (s.charAt(i) == '/') lastSign = 4;
        }
        return sum;
    }
}