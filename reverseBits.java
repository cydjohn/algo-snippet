public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
        	res <<= 1;//left shift before add the current val, or there will be abundant left shift and cause overstack.
        	if ((n & 1) == 1) res++;	
        	n >>= 1;
        }
        return res;
    }
}