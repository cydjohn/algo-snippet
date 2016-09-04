//http://www.programcreek.com/2013/02/leetcode-palindrome-number-java/
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        //determine how many digits in x
        int div = 1;
        while (x / div >= 10) {
        	div *= 10;
        }
        while (x != 0) {
        	int left = x / div;
        	int right = x % 10;
        	if (left != right) return false;
        	x = (x % div) / 10;
        	div /= 100;
        }
        return true;
    }
}