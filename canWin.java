//backtrack O(n!!)
/*The idea is try to replace every "++" in the current string s to "--" and see if the opponent can win or not, if the opponent cannot win, great, we win!

For the time complexity, here is what I thought, let's say the length of the input string s is n, there are at most n - 1 ways to replace "++" to "--" (imagine s is all "+++..."), once we replace one "++", there are at most (n - 2) - 1 ways to do the replacement, it's a little bit like solving the N-Queens problem, the time complexity is (n - 1) x (n - 3) x (n - 5) x ..., so it's O(n!!), double factorial.*/
public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) return false;
        for (int i = 0; i < s.length()-1; i++) {
        	if (s.startsWith("++", i)) {
        		String t = s.substring(0, i) + "--" + s.substring(i+2);
        		/*if the opponent can't win then we win*/
        		if (!canWin(t)) return true;
        	}
        }
        return false;
    }
}