public class Solution {
    public int strStr(String haystack, String needle) {
        //return haystack.indexOf(needle);
        if (haystack == null || needle == null) return -1;
        int lh = haystack.length();
        int ln = needle.length();
        for (int i = 0; i <= lh-ln; i++) {
        	int count = 0;
        	while (count < ln && haystack.charAt(i+count) == needle.charAt(count)) count++;
        	if (count == ln) return i;
        }
        return -1;
    }
}