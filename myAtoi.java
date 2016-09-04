public class Solution {
    public int myAtoi(String str) {
    	if (str.length() == 0) return 0;
        long res = 0; int i = 0; 
        boolean nega = false;
        while (i < str.length() && str.charAt(i) == ' ') i++;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
        	nega = (str.charAt(i) == '-');
        	i++;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
        	res = res * 10 + (str.charAt(i++) - '0');
        	if (!nega && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        	else if (nega && -res < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        if (nega) res = -res;
        return (int)res;
    }
}