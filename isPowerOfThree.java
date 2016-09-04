//without loop
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n>0 && (int)(Math.pow(3, 19)) % n == 0;
    }
}

//with loop
public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n % 3 == 0) n /= 3;
        return n == 1;
    }
}