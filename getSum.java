//https://discuss.leetcode.com/topic/49771/java-simple-easy-understand-solution-with-explanation
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {//b==0时不再有相同的位需要进位，此时的亦或就是和
        	int same = a & b; //获得同时为1的位，该位需要向前进位
        	a = a ^ b; //获取相异的位,赋给a
        	b = same << 1; //向前进位,赋给b，继续下一轮
        }
        return a;
    }
}