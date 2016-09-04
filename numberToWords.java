public class Solution {
private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int p = 0;
        String res = "";
        while (num != 0) {
        	if (num % 1000 != 0) res = helper(num % 1000) + " " + THOUSANDS[p] + " " + res;
        	num /= 1000;
        	p++;
        }
        return res.trim();
    }
    private String helper(int num) {
    	String str = new String();
    	if (num == 0) str = "";
    	else if (num < 20) str = LESS_THAN_20[num];
    	else if (num < 100) str = TENS[num / 10] + " " + helper(num % 10);
    	else str = LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100); 
    	return str.trim();
    }
}