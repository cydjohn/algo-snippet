//backtrack without stack
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] temp = new char[n*2];
        backtrack(res, temp, 0, n, n, 0);
        return res;
    }
    public void backtrack(List<String> res, char[] temp, int cur, int lt, int rt, int curLt) {
        if (cur == temp.length) {
            res.add(String.valueOf(temp));
            return;
        }
        if (lt > 0) {
            temp[cur] = '(';
            backtrack(res, temp, cur+1, lt-1, rt, curLt+1);
        }
        if (rt > 0 && curLt > 0) {
            temp[cur] = ')';
            backtrack(res, temp, cur+1, lt, rt-1, curLt-1);
        }
    }
}


//backtrack with stack
public class Solution {
	Stack<Character> stack = new Stack();
	List<String> res = new ArrayList();
	char[] c;
    public List<String> generateParenthesis(int n) {
        c = new char[2*n];
        backtrack(0, 2*n);
        return res;
    }
    private void backtrack(int cur, int n) {
    	if (cur == n) {
    	    if (!stack.empty()) res.add(String.valueOf(c));
    		return;
    	}
    	for (int i = 0; i < 2; i++) {
    		char ch = (i == 0) ? '(' : ')';
    		if (ch == '(') stack.push(ch);
    		else if (!stack.empty() && stack.peek() == '(') stack.pop();
    		else continue;
    		c[cur] = ch;
    		backtrack(cur+1, n);
    		/*restore the previous state*/
    		if (ch == '(') stack.pop();
    		else stack.push('(');
    	} 
    }
}



