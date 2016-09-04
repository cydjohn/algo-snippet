//a clearer version
//recurssion
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n-1);
        int cnt = 1; 
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
        	if (i+1 < str.length() && str.charAt(i) == str.charAt(i+1)) cnt++;
        	else {
        		s.append(cnt).append(str.charAt(i));
        		cnt = 1;
        	}
        }
        return s.toString();
    }
}

//older version
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = countAndSay(n-1);
        int cnt = 1; 
        StringBuilder s = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
        	if (str.charAt(i) == str.charAt(i-1)) cnt++;
        	else {
        		s.append(cnt);
        		s.append(str.charAt(i-1));
        		cnt = 1;
        	}
        }
        s.append(cnt);
        s.append(str.charAt(str.length()-1));
        return s.toString();
    }
}
//题意是n=1时输出字符串1；n=2时，数上次字符串中的数值个数，因为上次字符串有1个1，所以输出11；n=3时，由于上次字符是11，有2个1，所以输出21；n=4时，由于上次字符串是21，有1个2和1个1，所以输出1211。依次类推，写个countAndSay(n)函数返回字符串。

