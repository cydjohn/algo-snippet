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