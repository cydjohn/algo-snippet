//two pointers O(n)
//Q: Is 'a' and 'A' palindrome? Yes.
//Q: Have you consider that the string might be empty? 
//Q: Have you consider overOfRange error while using while loop to skip duplicates?
public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int p1 = 0, p2 = s.length() - 1;
        while (p1 < p2) {
        	while (p1 < p2 && !isAN(s.charAt(p1))) p1++;
        	while (p1 < p2 && !isAN(s.charAt(p2))) p2--;
        	if (s.charAt(p1) == s.charAt(p2) || s.charAt(p1) == toDiffCase(s.charAt(p2))) {
        		p1++; p2--;
        	}
        	else return false;
        }
        return true;
    }
    private boolean isAN(char ch) {
    	return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
    }
    private char toDiffCase(char ch) {
        //大写字母转成小写字母加上32
    	if (ch >= 'a' && ch <= 'z') return (char)(ch-32);
    	else if (ch >= 'A' && ch <= 'Z') return (char)(ch+32);
    	else return ch;
    }
}