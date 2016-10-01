//48. Rotate Image
//layer exchange
public class Solution {
    public void rotate(int[][] matrix) {
        for (int layer = 0; layer < matrix.length/2; layer++) {
        	int st = layer;
        	int end = matrix[0].length - layer - 1;
        	for (int i = st; i < end; i++) {
        	    int diff = i - st;//end-diff is the last last node of current layer's row
        		int top = matrix[st][i];
        		matrix[st][i] = matrix[end-diff][st];
        		matrix[end-diff][st] = matrix[end][end-diff];
        		matrix[end][end-diff] = matrix[i][end];
        		matrix[i][end] = top;
        	}
        }
    }
}

public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0, j = n - 1; i < j; i++, j--) {
                swap(matrix, k, i, k , j);
            }
        }
    }
    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
}