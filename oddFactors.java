import java.io.*;
import java.util.*;

public class Solution {
    public static int oddFactors(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += oddSum(n);
        }
        return sum;
    }
    public static int oddSum(int n) {
        int sum = 0;
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                if (i*i != n && n/i%2 != 0) sum += n/i;
                if (i%2 != 0) sum += i; 
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] nums = {1, 5, 7, 9, 6};
        System.out.println(oddFactors(nums));
    }
}

