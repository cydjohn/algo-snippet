public class Solution {
    public int integerReplacement(int n) {
        int cnt = 0;
        while (n != 1) {
        	if ((n & 1) == 0) n >>>= 1; //>>> is unsigned shift. It's needed because all Java types are signed (except char which is also considered an integer type for whatever crazy reason).
        	else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) n--;
        	else n++;
        	cnt++;
        }
        return cnt;
    }
}