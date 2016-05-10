public class Solution {
    public String reverseVowels(String s) {
        //1. define char array for vowel letters;
        char[] vowel = new char[]{'a','e','i','o','u','A','E','I','O','U'}; 
        //2. one pass: get pos indexes with vowel letters --> int[] vPos;
        int[] vPos = new int[s.length()];
        int vi = 0;
        for (int i = 0; i < s.length(); i++) {
        	for (int j = 0; j < vowel.length; j++) {
        		if (s.charAt(i) == vowel[j]) {
        			vPos[vi] = i;
        			vi ++;
        		}
        	}
        }
        //3. two pass in vPos: reserve/exchange the letters (String is inmutable in java, so we need to copy it into a array first.)
        char[] ss = s.toCharArray();
        for (int k = 0; k < vi; k++) {
        	ss[vPos[k]] = s.charAt(vPos[vi-1-k]);
        }
        //4. change a array back to string
        String result = String.valueOf(ss);
        return result;
    }
}