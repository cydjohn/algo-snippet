//https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
        	int same = a & b; //获得同时为1的位，该位需要向前进位
        	a = a ^ b; //获取相异的位
        	b = same << 1; //向前进一位
        }
        return a;
    }
}