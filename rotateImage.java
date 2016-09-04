//https://discuss.leetcode.com/topic/6796/a-common-method-to-rotate-the-image
/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
public class Solution {
    public void rotate(int[][] matrix) {
    	if (matrix.length == 0 || matrix[0].length == 0) return;
    	int n = matrix.length;
        for (int i = 0; i < n/2; i++) {
        	for (int j = 0; j < n; j++) {
        		swap(matrix, i, j, n-1-i, j);
        	}
        }
        for (int i = 0; i < n; i++) {
        	for (int j = 0; j < i; j++) {
        		swap(matrix, i, j, j, i);
        	}
        }
    }
    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
    	int temp = matrix[x1][y1]; 
    	matrix[x1][y1] = matrix[x2][y2];
    	matrix[x2][y2] = temp;
    }
}