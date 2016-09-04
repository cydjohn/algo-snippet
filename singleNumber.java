/*Two equal number xor with each other, the result will be 0；
0 xor with any number, the result will be the number itself.
and the point is that xor is commutable!! N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
= 0 ^ 0 ^ ..........^ 0 ^ N
= N*/
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
        	res = res ^ nums[i];
        }
        return res;
    }
}