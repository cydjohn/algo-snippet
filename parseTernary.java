 //recursion O(n^2)
public class Solution {
    public String parseTernary(String s) {
        char[] chs = s.toCharArray();
        if (s.length() == 5) return calculate(chs, 0);
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'T' || chs[i] == 'F') {
                if (isValid(chs, i)) {
                    String c = calculate(chs, i);
                    if (!c.equals("T") && !c.equals("F") && i+5 < chs.length && chs[i+5] == '?') continue;
                    String str = s.substring(0, i) + c + s.substring(i+5);
                    System.out.println(str);
                    return parseTernary(str);
                }
            }
        }
        return "";
    }
    private boolean isValid(char[] chs, int i) {
        return chs[i+1]=='?' && chs[i+3] == ':';
    }
    private String calculate(char[] chs, int i) {
        if (chs[i] == 'T') return Character.toString(chs[i+2]);
        else return Character.toString(chs[i+4]);
    }
}

public class Solution {
    public String parseTernary(String expression) {
        while (expression.length() > 1) {
            int i = expression.lastIndexOf("?");
            char tmp;
            if (expression.charAt(i-1) == 'T') {
                tmp = expression.charAt(i+1);
            } else {
                tmp = expression.charAt(i+3);
            }
            expression = expression.substring(0, i-1) + tmp + expression.substring(i+4);
        }
        return expression;
    }
}