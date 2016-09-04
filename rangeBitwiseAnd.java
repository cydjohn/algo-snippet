//The little trick is to return the left common parts of two numbers. When not equal, move right for 1 bit, util equal, return the common parts.
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int step = 0;
        while (m != n) {
        	m >>= 1;
        	n >>= 1;
        	step++;
        }
        return m << step;
    }
}