/*主要使用两个指针从前后对向遍历，就跟我们判断String是否是Palindrome一样，假如s.charAt(i) == s.charAt(j)，则j++。走完之后的结果j所在假如是s.length() - 1，则整个String为Palindrome，返回s，否则，j所在的位置及其以后的部分肯定不是Palindrome，这是我们要把这部分翻转并且加到结果的前面。至于 substring(0, j)这部分，我们仍需要使用递归的方法继续判断。非常非常巧妙。其实一开始思考求以s.charAt(0)为起点的方法时，觉得应该有方法可以不用KMP，Manacher，Rabin-Karp等等String Match的方法，这下终于见到了。真厉害。*/
public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
        	if (s.charAt(i) == s.charAt(j)) j++;
        }
        if (j == s.length()) return s;
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
}