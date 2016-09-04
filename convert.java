//zigzag index cycling + stringbuilder array
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
        	sb[i] = new StringBuilder();
        }
        int idx = 0, next = 1;
        for (int i = 0; i < s.length(); i++) {
        	sb[idx].append(s.charAt(i));
        	if (idx == 0) next = 1;
        	if (idx == numRows-1) next = -1;
        	idx += next;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder b : sb) {
        	res.append(b);
        }
        return res.toString();
    }
}