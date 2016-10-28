/*Straight forward way to solve the problem in 3 steps:

find the length of the number where the nth digit is from
find the actual number where the nth digit is from
find the nth digit and return*/
public class Solution {
    public int findNthDigit(int n) {
	    int len = 1;
        long cnt = 9;
        int st = 1;
        while(n > len * cnt) {
        	n -= len * cnt;
        	len += 1;
        	cnt *= 10;
        	st *= 10;
        }
        st += (n - 1) / len;
        String s = Integer.toString(st);
        return s.charAt((n - 1) % len) - '0';
    }
}