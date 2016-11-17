//backtrack ＋ memorization
//time complexity?
public class Solution {
    Set<Integer> set = new HashSet();
    public boolean wordBreak(String s, Set<String> wordDict) {
         if (s.length() == 0) return false;
         return backtract(s, wordDict, 0);
    }
    private boolean backtract(String s, Set<String> wordDict, int cur) {
        if (cur == s.length()) return true;
        //the only trick is to memorize already checked strings, return false when you meet them in the second time since they didn't have a right answer in the first time.
        if (set.contains(cur)) return false;
        for (int i = cur; i < s.length(); i++) {
            String tmp = s.substring(cur, i+1);
            if (wordDict.contains(tmp) && backtract(s, wordDict, i+1)) {
                return true;
            }
        }
        set.add(cur);
        return false;
    }
}
//将fail的结果加到set可以在判断set是否包含cur之后加，也可以在return false之前，因为对于这道题，只要找到一个结果，如果return true就退出程序啦，所以只有fail的结果是会在继续访问的。