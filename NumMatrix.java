//dp -- this version is more suitable for large amout of call to sumRange function
public class NumMatrix {
    private int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }
        for (int j = 1; j < matrix[0].length; j++) {
            dp[0][j] = dp[0][j-1] + matrix[0][j];
        }       
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) return dp[row2][col2];
        if (row1 == 0) return dp[row2][col2] - dp[row2][col1-1];
        if (col1 == 0) return dp[row2][col2] - dp[row1-1][col2];
        return dp[row2][col2] - dp[row1-1][col2] - dp[row2][col1-1] + dp[row1-1][col1-1];
    }
}

//dp -- not so efficient for large amount of calls
public class NumMatrix {
	private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 1; j < matrix[0].length; j++) {
        		matrix[i][j] += matrix[i][j-1];
        	}
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
        	if (col1 == 0) ans += matrix[i][col2];
        	else ans += matrix[i][col2] - matrix[i][col1-1];
        }
        return ans;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

