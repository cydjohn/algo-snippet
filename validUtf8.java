public class Solution {
    public boolean validUtf8(int[] data) {
        if (data.length == 0) return true;
        for (int i = 0; i < data.length; i++) {
            int j = 7;
            while (((data[i] >> j) & 1) == 1) j--;
            int n = 7 - j;
            if (n == 1) return false;
            if (n > 1) {
                for (int k = i + 1; k < i + n; k++) {
                   if (k >= data.length) return false;
                   if (((data[k] >> 7) & 1) == 0 || ((data[k] >> 6) & 1) == 1) return false;
                }
            }
            i = (n == 0 ? i : i+n-1);
        }
        return true;
    }
}
