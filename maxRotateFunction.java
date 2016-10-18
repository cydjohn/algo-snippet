public class Solution {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) return 0;
        int n = A.length;
        //calculate sum except the ith pos
        int[] sum = new int[n];
        for (int i = 1; i < n; i++) {
        	sum[i] = sum[i-1] + A[i-1]; 
        }
        int rightSum = 0;
        for (int i = n-2; i >= 0; i--) {
            rightSum += A[i+1];
        	sum[i] += rightSum;
        }
        int cur = 0;
        for (int i = 0; i < n-1; i++) {
        	cur += (i+1)*A[i];
        }
        int max = cur;
        for (int i = n-2; i >= 0; i--) {
        	cur += sum[i] - (n-1) * A[i];
        	if (cur > max) max = cur;
        }
        return max;
    }
}