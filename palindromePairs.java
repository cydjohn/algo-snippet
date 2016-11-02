//https://discuss.leetcode.com/topic/39585/o-n-k-2-java-solution-with-trie-structure-n-total-number-of-words-k-average-length-of-each-word
//if (two parts of a palindorme "left" and "right" are of the same length) --> hashmap
//else (we found the reverse of a part should be the prefix of another part) --> prefix stuff --> trie
//--> store the words reversely into a trie
//--> search the words "i" in the trie to find if (1)(there is a word is a prefix of i, and the rest part of i is also a palindrome) or (2)(if i is the prefix of some word, and the rest part of this word is a palindrome)

//tricky part:
//how to check palindrome in (2), based on the trie struceture, when we want to check if the rest part of a node is palindrome, (3) we need to keep track the path till the end, and then check the string we get; (4) or we could check it when we build the tree, by adding an extra field to the trie node, and add the index to this list, when we found the rest part is palindrome.
//the tradeoff is the input is small and the function is not called very frequently, we could use (3), since we don't to check those words which are not prefix of the input; but if the intput is large, it make sense to do some reprocessing work for a earliser life in the future.
//Time complexity: O(n * k * n) add/search n words with a maximum length of k, each one needs to check palindrome in O(n)
class TrieNode {
    int val;
    TrieNode[] next;
    //the list will record the indices of all words satisfying the following two conditions: 
    //1. each word has a suffix represented by the current Trie node; 
    //2.the rest of the word forms a palindrome.
    List<Integer> list;
    public TrieNode() {
    	val = -1;
    	next = new TrieNode[26];
    	list = new ArrayList();
    }
}

public class Solution {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
        	put(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
        	get(words, i, root);
        }
        return res;
    }
    private void put(TrieNode x, String key, int val) {
    	for (int i = key.length()-1; i >= 0; i--) {
    		char c = key.charAt(i);
            //initiate a new node if it don't exist
    		if (x.next[c-'a'] == null) x.next[c-'a'] = new TrieNode();
            //check if the rest part is parlindrome, if yes, add to list
    		if (isPalindrome(key, 0, i)) x.list.add(val);
            //add to the next level
    		x = x.next[c-'a'];
    	}
        ////for corner cases: if the rest part is empty, it is also considered palindrome
    	x.list.add(val);
        //we need to ensure the the word didn't find itself as the another of palindrome, so use this index as a mask for end of word, so that we could check the index for equalience.
    	x.val = val;
    }
    private void get(String[] words, int i, TrieNode x) {
    	for (int j = 0; j < words[i].length(); j++) {
            //(1) if we find a reversed word is the prefix of words[i], then check if the rest part of words[i] is palindrome.
            //这个单词不能为words[i]本身
    		if (x.val >= 0 && x.val != i && isPalindrome(words[i], j, words[i].length()-1)) {
    			res.add(Arrays.asList(i, x.val));
    		}
    		x = x.next[words[i].charAt(j) - 'a'];
    		if (x == null) return;
    	}
        //(2) if words[i] is suffix of some words, then check if the rest part of the words are palindrome
    	for (int j : x.list) {
    		if (i == j) continue;
    		res.add(Arrays.asList(i, j));
    	}
    }
    private boolean isPalindrome(String s, int i, int j) {
    	while (i < j) {
    		if (s.charAt(i++) != s.charAt(j--)) return false;
    	}
    	return true;
    }
}

/*Understand the problem:
The brute-force solution to this problem is very simple. For each word, we search all the others and see if it can form a palindrome. Assume that the ave. length of each word is m and there are totally n words in the list, the time complexity would be O(n^2 * m). 

Solution:
1. Put all the reversed order of the input string into a Map. The key is the reversed order of the string, and the value is the indices of the word
2. For each word, get all its prefixes, If the prefix is in the map AND the rest of the string is a palindrome, then we can find a pair where the first half is the current word, and the second half is the reversed order of prefix.
3. For each word, get all its postfixes. If the postfix is in the map AND the first half of the string is palindrome, then we can find a pair where the reversed order of the postfix is the first part, and the word is the second part of the pair. 

The reason why we need to track the position of each word is to avoid the situation like ["c"], i.e. the word itself is a palindrome. Then we may mistakely concatenate a "cc" as a palindrome. So we can concatenate two words IFF
1. The key in the map is different from the current word
2. If they are the same, they must have different indices.*/

import java.io.*;
import java.util.*;
 
class TrieNode {
    int val;
    TrieNode[] next;
    //the list will record the indices of all words satisfying the following two conditions: 
    //1. each word has a suffix represented by the current Trie node; 
    //2.the rest of the word forms a palindrome.
    List<Integer> list;
    public TrieNode() {
        val = -1;
        next = new TrieNode[26];
        list = new ArrayList<>();
    }
}

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            put(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            get(words, i, root);
        }
        return res;
    }
    private void put(TrieNode x, String key, int val) {
        for (int i = key.length()-1; i >= 0; i--) {
            char c = key.charAt(i);
            //initiate a new node if it don't exist
            if (x.next[c-'a'] == null) x.next[c-'a'] = new TrieNode();
            //check if the rest part is parlindrome, if yes, add to list
            if (isPalindrome(key, 0, i)) x.list.add(val);
            //add to the next level
            x = x.next[c-'a'];
        }
        ////for corner cases: if the rest part is empty, it is also considered palindrome
        x.list.add(val);
        //we need to ensure the the word didn't find itself as the another of palindrome, so use this index as a mask for end of word, so that we could check the index for equalience.
        x.val = val;
    }
    private void get(String[] words, int i, TrieNode x) {
        for (int j = 0; j < words[i].length(); j++) {
            //(1) if we find a reversed word is the prefix of words[i], then check if the rest part of words[i] is palindrome.
            //这个单词不能为words[i]本身
            if (x.val >= 0 && x.val != i && isPalindrome(words[i], j, words[i].length()-1)) {
                res.add(Arrays.asList(i, x.val));
            }
            x = x.next[words[i].charAt(j) - 'a'];
            if (x == null) return;
        }
        //(2) if words[i] is suffix of some words, then check if the rest part of the words are palindrome
        for (int j : x.list) {
            if (i == j) continue;
            res.add(Arrays.asList(i, j));
        }
    }
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    Solution solution = new Solution();
    String[] input = new String[]{"abc", "cba", "c", "c"};
     
    List<List<Integer>> result = solution.palindromePairs(input);
     
    for (List<Integer> r : result) {
      System.out.println(r.get(0) + " " + r.get(1));
    }
  }
}

