//dp O(n^2)--O(1)space
/*dp[i][j]表示以(i, j)为右下点的最大的square的边长，观察发现只有当num[i][j], dp[i-1][j-1], dp[i][j-1], dp[i-1][j]为1时才有可能形成边长为2的square,如果其中一个为0，则dp[i][j] = 0; 引申思考，当nums[i][j] = 1时，dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j])+1; 当3者中有一个为0时，dp[i][j]仍为1，所以该方法也直接作用在num数组上，不适用extra space，但是当前输入的类型为char，在计算中有麻烦的转化，所以可以使用新的int数组来做dp,runtime会更好一些。*/
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (i > 0 && j > 0 && matrix[i][j] == '1') 
        			matrix[i][j] = (char)(Math.min(matrix[i-1][j-1] - '0', Math.min(matrix[i][j-1] - '0', matrix[i-1][j] - '0')) + 1 + '0');
        		if (matrix[i][j] - '0' > max) max = matrix[i][j] - '0';
        	}
        }
        return max * max;
    }
}

//older version:
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int maxLen = 0;
        int[][] dp = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
        	dp[i][0] = (matrix[i][0] == '1') ? 1 : 0;
        	if (maxLen < dp[i][0]) maxLen = dp[i][0];
        }
        for (int j = 0; j < colLen; j++) {
        	dp[0][j] = (matrix[0][j] == '1') ? 1 : 0;
        	if (maxLen < dp[0][j]) maxLen = dp[0][j];
        }  
        
        for (int i = 1; i < rowLen; i++) {
        	for (int j = 1; j < colLen; j++) {
        		if (matrix[i][j] == '1' && dp[i-1][j-1] > 0) {
        			int k = 1;
        			while (k <= dp[i-1][j-1]) {
        				if (matrix[i-k][j] == '0' || matrix[i][j-k] == '0') break;
        				k ++;
        			}
        			dp[i][j] = k;
        		}
        		else dp[i][j] = (matrix[i][j] == '1') ? 1 : 0;
        		if (maxLen < dp[i][j]) maxLen = dp[i][j];
        	}
        }    
        return maxLen* maxLen;
    }
}

