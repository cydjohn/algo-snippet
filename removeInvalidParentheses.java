/*给定String，去除invalid括号，输出所有结果集。一开始想的是DFS + Backtracking，没有坚持下去。后来在Discuss里发现了jeantimex大神的BFS方法非常好，于是搬过来借鉴。方法是我们每次去掉一个"("或者")"，然后把新的string加入到Queue里，继续进行计算。要注意的是需要设置一个boolean foundResult，假如在这一层找到结果的话，我们就不再继续进行下面的for循环了。这里应该还可以继续剪枝一下，比如记录当前这个结果的长度len，当queue里剩下的string长度比这个len小的话，我们不进行验证isValid这一步。

Time Complexity - O(n * 2^n)， Space Complexity - O(2^n)*/
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
    	List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>(); 
        Set<String> failed = new HashSet<>();
        boolean found = false;
        q.offer(s);
        while (!q.isEmpty()) {
        	String cur = q.poll();
        	if (isValid(cur)) {
        		res.add(cur);
        		found = true;
        	}
        	if (found) continue;
        	for (int i = 0; i < cur.length(); i++) {
        		if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
        			String sub = cur.substring(0, i) + cur.substring(i+1, cur.length());
        			if (!failed.contains(sub)) {
        				q.offer(sub);
        				failed.add(sub);
        			}
        		}
        	}
        }
        return res;
    }
    private boolean isValid(String s) {
    	int cnt = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (s.charAt(i) == '(') cnt++;
    		else if (s.charAt(i) == ')') cnt--;
    		if (cnt < 0) return false;
    	}
    	return cnt == 0;
    }
}