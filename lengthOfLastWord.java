public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int i = s.length()-1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        if (i < 0) return 0;
        int j = i - 1;
        while (j >= 0 && s.charAt(j) != ' ') j--;
        return (i-j);
    }
}

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int len = 0;
        for (int i = s.length()-1; i >= 0; i--) {
        	while (len == 0 && i > 0 && s.charAt(i) == ' ') i--;
        	if (s.charAt(i) == ' ') return len;
        	else len++;
        }
        return len;
    }
}

//corner case: "a ", " "

