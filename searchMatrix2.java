//BS O(nlogn)
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length == 0) return false;
    	int row = colBS(matrix, 0, matrix.length-1, target);
        if (row < 0) return false;
        boolean found = false;
        for (int i = 0; i <= row; i++) { //target might appear in 0-row row
        	found = found || rowBS(matrix, i, 0, matrix[0].length-1, target);
        }  
        return found;     
    }
    private int colBS(int[][] matrix, int start, int end, int target) {
    	if (start > end) return start-1;
    	int mid = start + (end - start)/2;
    	if (target == matrix[mid][0]) return mid;
    	if (target < matrix[mid][0]) return colBS(matrix, start, mid-1, target);
    	else return colBS(matrix, mid+1, end, target);
    }
    private boolean rowBS(int[][] matrix, int row, int start, int end, int target) {
    	if (start > end) return false;
    	int mid = start + (end - start)/2;
    	if (target == matrix[row][mid]) return true;
    	if (target < matrix[row][mid]) return rowBS(matrix, row, start, mid-1, target);
    	else return rowBS(matrix, row, mid+1, end, target);	
    }
}

//类似BS O9m+n
/*We start search the matrix from top right corner, initialize the current position to top right corner, if the target is greater than the value in current position, then the target can not be in entire row of current position because the row is sorted, if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too. We can rule out one row or one column each time, so the time complexity is O(m+n).*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if (matrix.length == 0 || matrix[0].length == 0) return false;
        int i = 0, j = matrix[0].length - 1;
        while (j >= 0 && i < matrix.length) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }
}