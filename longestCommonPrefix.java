//Q: what do you need to consider when you chompare the s and e?
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        Arrays.sort(strs);
        String s = strs[0], e = strs[strs.length-1];
        int i = 0, len = Math.min(s.length(), e.length()); 
        while (i < len && s.charAt(i) == e.charAt(i)) i++;
        return s.substring(0, i);
    }
}