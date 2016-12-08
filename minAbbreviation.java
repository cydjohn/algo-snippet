/*X. Brute Force
http://www.cnblogs.com/grandyang/p/5935836.html
这道题实际上是之前那两道Valid Word Abbreviation和Generalized Abbreviation的合体，我们的思路其实很简单，首先找出target的所有的单词缩写的形式，然后按照长度来排序，小的排前面，我们用优先队列来自动排序，里面存一个pair，保存单词缩写及其长度，然后我们从最短的单词缩写开始，跟dictionary中所有的单词一一进行验证，利用Valid Word Abbreviation中的方法，看其是否是合法的单词的缩写，如果是，说明有冲突，直接break，进行下一个单词缩写的验证
https://discuss.leetcode.com/topic/61327/brute-force-solution-just-check-every-possible-abbreviation/3
Use the approach of “320. Generalized Abbreviation” to generate all abbreviations of “target”;
Put all the abbreviations into a PriorityQueue according to the length of the abbreviations;
With each abbreviation, check whether it’s an abbreviation of any word in the dictionary using the approach of “408. Valid Word Abbreviation”.*/
public class Solution {
public class Abbreviation{
        public String abbr;
        public int len;
        
        public Abbreviation(String abbr, int len){
            this.abbr = abbr;
            this.len = len;
        }
    }
    
    public String minAbbreviation(String target, String[] dictionary) {
        if(dictionary.length == 0) return Integer.toString(target.length());
        PriorityQueue<Abbreviation> q = new PriorityQueue<Abbreviation>(new Comparator<Abbreviation>(){
           public int compare(Abbreviation a1, Abbreviation a2){
               return a1.len - a2.len;
           } 
        });
        generateAbbrs(q, target, "", 0, 0, false);
        while(!q.isEmpty()){
            String abbr = q.poll().abbr;
            boolean notMatch = true;
            for(int i=0; i<dictionary.length; i++){
                if(isValidAbbr(dictionary[i], abbr)){
                    notMatch = false;
                    break;
                }
            }
            if(notMatch) return abbr;
        }
        return "";
    }
    
    private void generateAbbrs(PriorityQueue<Abbreviation> q, String target, String path, int start, int len, boolean prevAbbr){
        if(start == target.length()){
            q.offer(new Abbreviation(path, len));
            return;
        }
        generateAbbrs(q, target, path+target.charAt(start), start+1, len+1, false);
        if(!prevAbbr){//prevAbbr用来防止相邻部分重复压缩，结果中不能出现相邻的数字
            for(int i=start; i<target.length(); i++){
                String str = target.substring(start, i+1);
                generateAbbrs(q, target, path+Integer.toString(str.length()), i+1, len+1, true);
            }
        }
    }
    
    private boolean isValidAbbr(String word, String abbr){
        int index = 0, i = 0;
        while(i < abbr.length()){
            if(!Character.isDigit(abbr.charAt(i))){
                if(index >= word.length() || word.charAt(index) != abbr.charAt(i)) return false;
                index++; i++;
            }else{
                int start = i;
                while(i < abbr.length() && Character.isDigit(abbr.charAt(i))) i++;
                int number = Integer.parseInt(abbr.substring(start, i));
                index += number;
            }
        }
        return index == word.length();
    }
}



//TLE
public class Solution {
    public class Pair {
    	String s;
    	int len;
    	public Pair(String s, int len) {
    		this.s = s;
    		this.len = len;
    	}
    }
    public String minAbbreviation(String target, String[] dictionary) {
        Set<Pair> set = new HashSet();
        for (String d : dictionary) {
        	if (d.length() != target.length()) continue;
        	getAbbr(d, 0, 0, 0, "", set);
        }

        PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>(){
        	public int compare(Pair a, Pair b) {
        		return a.len - b.len;
        	}
        });
        getAbbr(target, 0, 0, 0, "", pq);
        while (!pq.isEmpty()) {
        	String cur = pq.poll().s;
        	if (!set.contains(cur)) return cur;
        }
        return null;
    }
    private void getAbbr(String s, int cur, int cnt, int len, String tmp, Set<Pair> set) {
    	if (cur == s.length()) {
    		if (cnt > 0) {
    		    tmp += cnt;
    		    len++;
    		}
    		set.add(new Pair(tmp, len));
    		return;
    	}
    	getAbbr(s, cur+1, cnt+1, len, tmp, set);
    	getAbbr(s, cur+1, 0, len + (cnt > 0 ? 2 : 1), tmp + (cnt > 0 ? cnt : "") + s.charAt(cur), set);
    }
    private void getAbbr(String s, int cur, int cnt, int len, String tmp, PriorityQueue<Pair> pq) {
    	if (cur == s.length()) {
    		if (cnt > 0) {
    		    tmp += cnt;
    		    len++;
    		}
    		pq.add(new Pair(tmp, len));
    		return;
    	}
    	getAbbr(s, cur+1, cnt+1, len, tmp, pq);
    	getAbbr(s, cur+1, 0, len + (cnt > 0 ? 2 : 1), tmp + (cnt > 0 ? cnt : "") + s.charAt(cur), pq);
    }
}