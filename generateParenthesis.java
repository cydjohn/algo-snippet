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
    	    if (!stack.empty()) return;
    		res.add(String.valueOf(c));
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

//backtrack without stack
public class Solution {
	List<String> res = new ArrayList();
	char[] a;
	boolean[] vis;
    public List<String> generateParenthesis(int n) {
        a = new char[n*2];
        vis = new boolean[n*2];
        search(0, n*2, n, n);
        return res;
    }
    private void search(int cur, int n, int lt, int rt) {
    	if (cur == n) res.add(String.valueOf(a));
    	else {
    		for (int i = 0; i < 2; i++) {
    			boolean ok = true;
    			int j = -1;
    			a[cur] = (i == 0 ? '(' : ')');
    			if (i == 0) lt--;
    			else rt--;
    			if (lt == -1 || rt == -1) ok = false;
    			else if (i == 1) {
    				j = cur - 1;
    				for (; j >= 0; j--) {
    					if (a[j] == '(' && !vis[j]) {
    						vis[j] = true;
    						break;
    					}
    				}
    				if (j == -1) ok = false;
    			}
    			if (ok) search(cur+1, n, lt, rt);
    			if (j > -1) vis[j] = false;
    			if (i == 0) lt++;
    			else rt++;
    		}
    	}
    }
}

