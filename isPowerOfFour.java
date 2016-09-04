//https://discuss.leetcode.com/topic/42860/java-1-line-cheating-for-the-purpose-of-not-using-loops/2
//https://yesteapea.wordpress.com/2013/03/03/counting-the-number-of-set-bits-in-an-integer/
public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num-1)) == 0 && (num & 0x55555555) != 0;
         //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position 
    }
}