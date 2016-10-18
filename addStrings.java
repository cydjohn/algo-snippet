public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int p1 = num1.length()-1, p2 = num2.length()-1;
        int sum = 0;
        while (p1 >= 0 || p2 >= 0) {
        	if (p1 >= 0) sum += num1.charAt(p1--) - '0';
        	if (p2 >= 0) sum += num2.charAt(p2--) - '0';
        	sb.insert(0, sum % 10);
        	sum /= 10;
        }
        if (sum == 1) sb.insert(0, 1);
        return sb.toString();
    }
}