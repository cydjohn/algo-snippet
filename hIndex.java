//O(nlogn)
public class Solution {
    public int hIndex(int[] citations) {
    	if (citations.length == 0) return 0;
        Arrays.sort(citations);
        int len = citations.length;
        int p = 0; //p用来计算当前大于等于c[i]的paper数目
        for (int i = 0; i <= citations[len-1]; i++) {
        	while (i > citations[p]) p++; //to avoid duplicate
        	if (i > len - p) return i - 1;
        }
        return citations[len-1];
    }
}
/*
0. 改进：hIndex受文章数目的限制，最多不超过citations.length，可以减少循环；循环过程check是否满足hIndex的定义
1. 循环继续的条件：c[i] > len - i; 不等号右边为大于等于c[i]的paper数目。
2.为什么返回len-i? 临界值为c[i] == len-i; 到达相等时，hIndex的定义仍然成立，然而再向右执行必有c[i] > len - i, 因为i增加则不等号右边减小，而c[i]增大或保持不变（因为array是sorted的）；
    此时必有c[i-1] <= len-i <= c[i]; 第一个不等号成立的原因是c[i-1] < len - (i-1) (循环已检查);
    所以len-i是安全的临界值。*/
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < len; i++) {
        	if (citations[i] >= len - i) return len - i;
        }
        return 0;
    }
}

//改进：用hash式的array代替sort, O(n), 58%;
public class Solution {
    public int hIndex(int[] citations) {
    	int len = citations.length;
    	int[] idx = new int[len+1];
    	for (int c : citations) {
    		if (c >= len) idx[len]++;
    		else idx[c]++;
    	}
    	int sum = 0, i = len;
    	while (i > 0) {
    		sum += idx[i];
    		if (i <= sum) return i; //第一个符合hIndex的i就是最大的hIndex
    		i--;
    	}
    	return 0;
    }
}



