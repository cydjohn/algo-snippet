//power2 property O(1)
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        return ((n-1) & n) == 0;
    }
}

//bit traversal O(n)
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) cnt++;
            if (cnt > 1) return false;
            n >>= 1;
        }
        return true;
    }
}