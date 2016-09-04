//Hashset contains + two pointers O(n)
public class Solution {
    public String reverseVowels(String s) {
        //need to use "Character" instead of "character"
        Character[] vowel = {'a','e','i','o','u','A','E','I','O','U'};
        //create set from array
        HashSet<Character> set = new HashSet(Arrays.asList(vowel));
        char[] c = s.toCharArray();
        int l = 0, r = s.length()-1;
        while (l < r) {
        	while (l < r && !set.contains(c[l])) l++;
        	while (l < r && !set.contains(c[r])) r--;
        	swap(c, l++, r--);
        } 
        return String.valueOf(c);        
    }
    private void swap(char[] c, int l, int r) {
    	char temp = c[l];
    	c[l] = c[r];
    	c[r] = temp;
    }
}

//O(n^2)
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

