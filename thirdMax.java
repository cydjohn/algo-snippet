public class Solution {
    public int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (int n : nums) {
        	if (n > a) {
        		c = b;
        		b = a;
        		a = n;
        	} else if (n > b && n < a) {
        		c = b;
        		b = n;
        	} else if (n > c && n < b) {
        		c = n;
        	}
        }
        if (c != Long.MIN_VALUE) return (int)c;
        return (int)a;
    }
}

//corner cases:
[1,1,2]
[1,2,-2147483648]