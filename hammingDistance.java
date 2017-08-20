//method 1
class Solution {
    public int hammingDistance(int x, int y) {
        int res = 0;
        while (x != 0 || y != 0) {
            int cx = 0, cy = 0;
            if (x != 0) cx = x % 2;
            if (y != 0) cy = y % 2;
            res += (cx == cy) ? 0 : 1;
            x /= 2;
            y /= 2;
        }
        return res;
    }
}

//methdod 2: bit manipulation
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += (xor >> i) & 1;
        }
        return res;
    }
}
