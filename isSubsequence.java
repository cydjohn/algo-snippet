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

//follow up:
/*If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
we could use a hashmap<char, List<Integer>> to store the character positions in t, and check everytime if current char of s is in t and has an index bigger s's prev char, if yes, we use the smallest index as cur's corresponding index in t. something like greedy here.*/


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