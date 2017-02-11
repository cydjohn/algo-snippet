//backtrack
//在backtrack的过程中纪录计算器的计算结果，避免在获得了string后在调用计算器API进行计算，节省了再一次traverse的时间以及stack的空间。
public class Solution {
    public List<String> addOperators(String num, int target) {
    	List<String> res = new ArrayList<String>();
        backtrack(res, num, "", target, 0, 0, 0);
        return res;
    }
    public void backtrack(List<String> res, String num, String path, int target, int cur, long value, long prev) {
    	if (cur == num.length()) {
    		if (value == target) res.add(path);
    		return;
    	}
    	for (int i = cur; i < num.length(); i++) {
    		if (i != cur && num.charAt(cur) == '0') break;
    		long curNum = Long.parseLong(num.substring(cur, i+1));
    		if (cur == 0) {
    			backtrack(res, num, path + curNum, target, i+1, curNum, curNum);
    		} else {
    			backtrack(res, num, path + '+' + curNum, target, i+1, value + curNum, curNum);
    			backtrack(res, num, path + '-' + curNum, target, i+1, value - curNum, -curNum);
    			backtrack(res, num, path + '*' + curNum, target, i+1, value - prev + prev * curNum, prev * curNum);
    		}
    	}
    }
}

//超时，空间不足
public class Solution {
    char[] ops = {'+', '-', '*'};
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        backtrack(num, res, new ArrayList<Character>(), target, 0);
        return res;
    }
    public void backtrack(String num, List<String> res, List<Character> temp, int target, int cur) {
        if (cur == num.length()) {
            if (calculate(temp, target)) {
                StringBuilder sb = new StringBuilder();
                for (char t : temp) {
                    sb.append(t);
                }
                res.add(sb.toString());
            }
            return;
        }
        temp.add(num.charAt(cur));
        if (cur < num.length()-1) {
            for (int i = 0; i < 3; i++) {
                temp.add(ops[i]);
                backtrack(num, res, temp, target, cur+1);
                temp.remove(temp.size()-1);
            }
            backtrack(num, res, temp, target, cur+1);
        } else backtrack(num, res, temp, target, cur+1);
        temp.remove(temp.size()-1);
    }
    public boolean calculate(List<Character> s, int target) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i) == '*') {
                int num = 0; i++;
                while (i < s.size() && s.get(i) > '0' && s.get(i) < '9') {
                    num = num * 10 + s.get(i++) - '0';
                }
                int product = num * stack.pop();
                stack.push(product);
                i--;
            } else if (s.get(i) == '+') {
                stack.push(1);
            } else if (s.get(i) == '-') {
                stack.push(-1);
            } else {
                int num = 0; 
                while (i < s.size() && s.get(i) > '0' && s.get(i) < '9') {
                    num = num * 10 + s.get(i++) - '0';
                }
                stack.push(num);
                i--;
            }
        }
        int res = 0;
        while (stack.size() > 1) {
            res += stack.pop() * stack.pop();
        }
        res += stack.pop();
        return res == target;
    }
}