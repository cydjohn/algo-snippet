public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, (char)((n - 1) % 26 + 'A'));//需要n-1这里，因为1 -> A而不是 0 -> A
            n = (n - 1) / 26;//注意此处又需要n-1，否则该位如果等于26有可能除出多余的1，但其实他是Z
        }
        return sb.toString();
    }
}