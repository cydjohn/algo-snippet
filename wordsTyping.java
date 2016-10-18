/*
理论上说每一个单词都有可能作为某一行的开头，我们要计算一下如果以某个单词开头，会是什么结果。结果包括两部分：
1）这一行能塞多少个句子。
2）下一行开头会以什么单词开头。
知道这2个情况之后，以此塞满所有ROWS就行了。
*/
//O(len(sentence) * cols + rows), since rows >> len(sentence), it will not got TLE
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
    	int n = sentence.length;
    	int[] capacity = new int[n];
    	int[] nextSt = new int[n];
    	for (int i = 0; i < n; i++) {
    		int sum = 0;
    		int p = i;
    		int cnt = 0;
    		while (sum + sentence[p].length() <= cols) {
    			sum += sentence[p++].length() + 1;
    			if (p == n) {
    				p = 0;
    				cnt++;
    			}
    		}
    		capacity[i] = cnt;
    		nextSt[i] = p;
    	}
    	int res = 0;
    	int next = 0;
    	for (int i = 0; i < rows; i++) {
    		res += capacity[next];
    		next = nextSt[next];
    	}
    	return res;
    }
}


//TLE O(rows * cols)
//when the word is very short and duplicated a lot, it will take a lot of time to travel through the whole space
public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence.length == 0) return 0;
        int cnt = 0, n = sentence.length;
        for (int i = 0; i < rows; i++) {
        	int sum = 0;
        	while (sum + sentence[cnt % n].length() <= cols) {
        		sum += sentence[cnt++ % n].length() + 1;
        	}
        }
        return cnt / n;
    }
}