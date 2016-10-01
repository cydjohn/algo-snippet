//indexOf (faster than two pointers due to the calling times difference of charAt() and indexOf(), both are O(n))
public class Solution 
{
    public boolean isSubsequence(String s, String t) 
    {
        if(t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1) return false;
            prev++;
        }
        return true;
    }
}

//two pointers
public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        char cs = s.charAt(0), ct = t.charAt(0);
        int ps = 0, pt = 0;
        while (pt < t.length()) {
        	if (cs == ct) {
        	    ps++;
        	    if (ps == s.length()) return true;
        		cs = s.charAt(ps);
        	}
        	pt++;
        	if (pt == t.length()) return false;
        	ct = t.charAt(pt);
        }
        return false;
    }
}