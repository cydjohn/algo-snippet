//https://discuss.leetcode.com/topic/8894/clean-java-solution-hashmap-bits-manipulation/9
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList();
        HashSet<Integer> once = new HashSet();
        HashSet<Integer> twice = new HashSet();
        char[] map = new char[26];
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        for (int i = 0; i < s.length()-9; i++) {
        	int strBit = 0;
        	for (int j = i; j < i + 10; j++) {
        		strBit <<= 2;
        		strBit |= map[s.charAt(j)-'A'];
        	}
        	if (!once.add(strBit) && twice.add(strBit)) {//the !words.add(v) will first be executed and only when duplicate it becomes true and will execute the second add and see the result.
        		res.add(s.substring(i, i+10));
        	}
        }
        return res;
    }
}