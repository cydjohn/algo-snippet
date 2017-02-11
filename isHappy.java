//循环之后不一定出现sum == n，所以需要hashset存储之前出现过的数
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> old = new HashSet();
        while(!old.contains(n)) {
            old.add(n);
            int sum = 0;
            while (n != 0) {
                sum += (int)(Math.pow(n % 10, 2));
                n /= 10;
            }
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }
}
