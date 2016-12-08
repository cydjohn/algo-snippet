/*这道题关键在于找出所有的数字, 至于顺序问题采用排序或者先用数组保存最后再拼接都可以.

先遍历一次输入字符串, 记录每个字母的出现次数, 然后用贪心法逐个找出每个单词的出现次数, 只要组成这个单词的所有字母的剩余个数都不为0, 那么就可以组成这个单词. 但是如果采用0-9的顺序来依次搜索单词的话, one这个单词中的o, n和e可能都不是one中的, 可能是从其他单词中"拿来的", 这就会导致结果错误. 所以要以特定的顺序来遍历0-9. 如果一个单词中有"独特的"字母, 也就是只在这个单词中出现的字母, 那么它就不可能从其他的单词中"拿来"组成这个单词的所有字母, zero中的z, two中的w, four中的u, six中的x, eight中的g都是唯一的, 因此要把它们放在前面来搜索, 在剩下的单词中继续寻找"唯一的"字母. 这样就可以得到一个0-9的序列, 比如0246875319, 按照这个顺序来搜索单词就可以得到正确答案.*/
public class Solution {
    public String originalDigits(String s) {
        String[] words = {"zero", "two", "four", "six", "eight", "seven", "five", "three", "one", "nine"};
        int[] digits = {0,2,4,6,8,7,5,3,1,9};
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
        		cnt[c-'a']++;
        }
        List<Integer> res = new ArrayList();
        for (int i = 0; i < words.length; i++) {
        	String w = words[i];
        	while (true) {//可能有多个0
	        	boolean hasW = true;
	        	for (char c : w.toCharArray()) {
	        		if (cnt[c-'a'] == 0) {
	        			hasW = false;
	        			break;
	        		}
	        	}
	        	if (!hasW) break;
	        	for (char c : w.toCharArray()) {
	        		cnt[c-'a']--;
	        	}
	        	res.add(digits[i]);
        	}       	
        }
        Collections.sort(res);
        StringBuilder sb = new StringBuilder();
        for (int r : res) sb.append(r);
        return sb.toString();
    }
}