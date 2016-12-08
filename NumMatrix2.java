//2d version
//https://www.hrwhisper.me/binary-indexed-tree-fenwick-tree/
/*对于节点x，
为左子结点，则父结点的编号是x+lowbit(x)，
为右子结点，则父结点的编号是x-lowbit(x)
设C[i] 为以i结尾的水平长条内的元素之和，如c[6]=a5+a6。

顺着结点I往左走，边走边往上爬，沿途经过的c[i]所对应的长条不重复不遗漏的包含了所有需要累加的元素。
如sum(6) = c[6] + c[4]
如果修改了一个a[i] ,那么从c[i]往右走，边走边网上爬，沿途修改所有结点对应的c[i]即可。
如a[1] + 1 那么 c[1] + 1, c[2]+1,c[4]+1………一直到最大值。*/
/*Time Complexity - O(mnlogm * logn) build,  O(logmn) update， O(logmn) rangeSum， Space Complexity - O(mn)*/
public class NumMatrix {
	private int sum[][];
	private int matrix[][];

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        //Fenwick tree从下标1开始计算，而不是0
        sum = new int[matrix.length + 1][matrix[0].length + 1];
        this.matrix = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		update(i, j, matrix[i][j]);
        	}
        }
    }

    public void update(int row, int col, int val) {
        int delta = val - matrix[row][col];
        matrix[row][col] = val;
        for (int i = row + 1; i < sum.length; i += i & (-i)) {
        	for (int j = col + 1; j < sum[0].length; j += j & (-j)) {
        		sum[i][j] += delta;
        	}
        }
    }

    private int getSum(int row, int col) {
    	int curSum = 0;
    	for (int i = row + 1; i > 0; i -= i & (-i)) {
    		for (int j = col + 1; j > 0; j -= j & (-j)) {
    			curSum += sum[i][j];
    		}
    	}
    	return curSum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row2, col1-1) - getSum(row1-1, col2) + getSum(row1-1, col1-1);
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);