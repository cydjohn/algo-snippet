/*In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find. Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1') in the XOR result. Find
out an arbitrary set bit (for example, the rightmost set bit).

In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups. XOR numbers in each group, we can find a number in either group.*/
public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
        	diff ^= num;
        }
        diff &= ~(diff - 1);// Get its last set bit
        int n1 = 0, n2 = 0;
        for (int num : nums) {
        	if ((num & diff) == 0) n1 ^= num;//the bit is unset
        	else n2 ^= num; //the bit is set
        }
        return new int[]{n1, n2};
    } 
}