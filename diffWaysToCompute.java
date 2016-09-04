public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList();
        for (int i = 0; i < input.length(); i++) {
        	char op = input.charAt(i);
        	if (op == '+' || op == '-' || op == '*') {// 以每一个算符为分割, 分割为[左边所有可能结果] + 这个算符 + [右边所有可能结果]
        		List<Integer> left = diffWaysToCompute(input.substring(0, i));
        		List<Integer> right = diffWaysToCompute(input.substring(i+1));
        		for (int lt : left) {
        			for (int rt : right) {
        				int ans = 0;
        				if (op == '+') ans = lt + rt;
        				else if (op == '-') ans = lt - rt;
        				else ans = lt * rt;
        				res.add(ans);
        			}
        		}
        	}
        }
        if (res.size() == 0) {// base case, a single number
        	res.add(Integer.parseInt(input));
        }
        return res;
    }
}