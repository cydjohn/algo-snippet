//O(n) hashtable + two pointers
/*采用哈希的思想，记录字母出现次数。
大小写字母的ASCII码不大于256，这样array['A']=3指A出现3次，array['B']=1指B出现了一次，以此类推，不能用常规意义上的定义array[0]=3表示A出现3次，这样就多了一层映射！故而数组的长度设置为256即可存放所有的字母。

首先预处理target，用256大小的整数数组tHash存储里面每个char出现的个数；
然后给定两个指标beg和end，一个移动start，也用一个256长的整数数组sHash记录从beg到end的这段字符串里面每个char出现的个数。如果sHash大于等于tHash，也就是说sHash里的每一位大于等于tHash里相应位置的值，找到当前start位置，为符合要求子串的起点，记录当前beg和end的长度，如果比已经记录的小，那么我们就选这个位最小窗口。记录beg和end。然后让start往前走一位。寻找下一个子串。*/
public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        int[] sHash = new int[256];
        int[] tHash = new int[256];
        for (char i : t.toCharArray()) {
        	tHash[i]++;
        }
        int found = 0, minLen = Integer.MAX_VALUE;
        int start = 0, beg = -1, end = -1;
        for (int i = 0; i < s.length(); i++) {
        	char cur = s.charAt(i);
        	sHash[cur]++;
        	/*更新当前找到的字符个数*/  
        	if (sHash[cur] <= tHash[cur]) found++; 
        	/*判断是否找到所有字符*/ 
        	if (found == t.length()) {
        		/*将源串开头未出现在目标串的字符以及多余的重复字符跳过*/  
        		while (sHash[s.charAt(start)] > tHash[s.charAt(start)]) {
        			sHash[s.charAt(start)]--;
        			start++;
        		}
        		/*找到符合要求子串的首尾位置start 与 i*/  
        		if (i - start < minLen) {
        			minLen = i - start;
        			beg = start;
        			end = i;
        		}
        		/*跳过该子串的开头位置，寻找下一个子串*/  
        		sHash[s.charAt(start++)]--;
        		found--;
        	}
        }
        if (minLen == Integer.MAX_VALUE) return "";
        else return s.substring(beg, end + 1);
    }
}



// Time Limit Exceeded O(n^2log(n)) -- BinarySearch
public class Solution {
    public String minWindow(String s, String t) {
    	String res = new String();
    	int ls = s.length(), lt = t.length();
        if (ls < lt) return res;
        if (ls == lt) {
        	if (containsALL(s, t)) return s;
        	else return res;
        }
        for (int i = 0; i < ls-lt+1; i++) {
        	int start = i+lt-1, end = ls-1;
        	while (start <= end) {
        		int mid = (start + end)/2;
        		String str = s.substring(i, mid+1);
        		if (containsALL(str, t)) {
        			end = mid - 1;
        			if (res.length() == 0 || res.length() > str.length()) res = str;
        		}
        		else start = mid + 1;
        	}
        }
        return res;
    }
    private boolean containsALL(String s, String t) {
    	String copy = s;
        for (int i = 0; i < t.length(); i++) {
        	int idx = copy.indexOf(t.charAt(i));
        	if ( idx < 0) return false; 
        	else copy = copy.substring(0, idx) + copy.substring(idx+1);
        }
        return true;
    }
}


