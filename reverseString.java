public class Solution {
    public String reverseString(String s) {
        if (s.length() < 2) return s;
        int i = 0, j = s.length()-1;
        char[] c = s.toCharArray();
        while (i < j) {
        	swap(c, i++, j--);
        }
        return String.valueOf(c);
    }
    private void swap(char[] c, int i, int j) {
    	char temp = c[i];
    	c[i] = c[j];
    	c[j] = temp;
    }
}