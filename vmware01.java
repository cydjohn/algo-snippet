/* merger string  :  把俩string merge成一个 ， 规则是一边来一个 剩余的全部append上去  即  abc ,  cdefg->    acbdcefg*/
//two pointers
public class Solution {
    public String merger(String s, String t) {
    	if (s == null || s.length() == 0) return t;
    	if (t == null || t.length() == 0) return s;
    	int i = 0, j = 0;
    	StringBuilder sb = new StringBuilder();
    	while (i < s.length() && j < t.length()) {
    		sb.append(s.charAt(i++));
    		sb.append(t.charAt(j++));
    	}
    	if (i < s.length()) sb.append(s.substring(i));
    	if (j < t.length()) sb.append(t.substring(j));
    	return sb.toString();
    }
}