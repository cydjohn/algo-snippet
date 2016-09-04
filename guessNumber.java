/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= n) {
        	int m = l + (r - l)/2;
        	int g = guess(m);
        	if (g == 0) return m;
        	if (g == 1) l = m + 1;
        	else r = m - 1;
        }
        return -1;
    }
}