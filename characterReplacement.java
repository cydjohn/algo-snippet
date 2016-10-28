public class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int st = 0, maxCnt = 0, n = s.length(), res = 0;
        for (int i = 0; i < n; i++) {
        	cnt[s.charAt(i)-'A']++;
        	if (maxCnt < cnt[s.charAt(i)-'A']) maxCnt = cnt[s.charAt(i)-'A'];
        	if (i - st - maxCnt + 1 > k) {
        		cnt[s.charAt(st)-'A']--;
        		st++;
        		for (int j = 0; j < 26; j++) {
        			maxCnt = Math.max(maxCnt, cnt[j]);
        		}
        	}
        	res = Math.max(res, i - st + 1);
        }
        return res;
    }
}