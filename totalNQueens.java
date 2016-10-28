public class Solution {
    int[] col;
    int cnt = 0;
    public int totalNQueens(int n) {
        col = new int[n];
        search(0, n);
        return cnt;
    }
    private void search(int cur, int n) {
        if (cur == n) {
            cnt++;
            return;
        }
        for (int i = 0; i < n; i++) {
            col[cur] = i;
            int j = 0;
            for (; j < cur; j++) {
                if (col[cur] == col[j] || col[cur] - cur == col[j] - j || col[cur] + cur == col[j] + j) break;
            }
            if (j == cur) search(cur+1, n);
        }
    }
}