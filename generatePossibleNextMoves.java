public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
    	List<String> res = new ArrayList();
        if (s.length() == 0) return res;
        for (int i = 0; i < s.length() - 1; i++) {
            //s.charAt(i) == '+' && s.charAt(i + 1) == '+' can be shorten as s.startsWith("++", i)
        	if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
        		String flip = s.substring(0, i) + "--" + s.substring(i+2);
        		res.add(flip);
        	}
        }
        return res;
    }
}