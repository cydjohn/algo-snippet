/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
/*因为要调用多次，这里又多了一些corner case：

第一次调用时，如果read4读出的多余字符我们要先将其暂存起来，这样第二次调用时先读取这些暂存的字符
第二次调用时，如果连暂存字符都没读完，那么这些暂存字符还得留给第三次调用时使用
所以，难点就在于怎么处理这个暂存字符。因为用数组和指针控制对第二种情况比较麻烦，且这些字符满足先进先出，所以我们可以用一个队列暂存这些字符。这样，只要队列不为空，就先读取队列。*/
public class Solution extends Reader4 {
	Queue<Character> remain = new LinkedList();
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n && !remain.isEmpty()) {
        	buf[i++] = remain.poll();
        }
        for (; i < n; i += 4) {
        	char[] tmp = new char[4];
        	int len = read4(tmp);
        	if (len > n - i) {
        		System.arraycopy(tmp, 0, buf, i, n - i);
        		for (int j = n - i; j < len; j++) {
        			remain.offer(tmp[j]);
        		}
        	} else {
        		System.arraycopy(tmp, 0, buf, i, len);
        	}
        	if (len < 4) return Math.min(i+ len, n);
        }
        return n;
    }
}