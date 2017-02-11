//计算机：实现+-／*（）同时计算
public class Solution {
    public int calculate(String s) {
        int len = s.length(); 
        int lastSign = 1; 
        int lastNum = 0;
        int sum = 0;
        Stack<Integer> stack = new Stack();
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
        	else if (s.charAt(i) == '(') {
        	    stack.push(sum);
        	    stack.push(lastNum);
        	    stack.push(lastSign);
        	    sum = 0;
        	    lastSign = 1;
        	    lastNum = 0;
        	} 
        	else if (s.charAt(i) == ')') {
        	    int sign = stack.pop();
        	    int last = stack.pop();
        	    if (sign == 1) {
        	        lastNum = sum;
        	        sum += stack.pop();
        	    }
        	    else if (sign == 2) {
        	        lastNum = -sum;
        	        sum = stack.pop() - sum;
        	    }
        	    else if (sign == 3) {
        	        lastNum = last * sum;
        	        sum = stack.pop() - last + last * sum;
        	    }
        	    else {
        	        lastNum = last / sum;
        	        sum = stack.pop() - last + last / sum;
        	    }
        	}
        }
        return sum;
    }
}