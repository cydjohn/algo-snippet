public class TicTacToe {
    int[] rows;
    int[] cols;
    int dg, adg, n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        dg = 0;
        adg = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int dif = 1;
        if (player == 2) dif = -1;
        rows[row] += dif;
        cols[col] += dif;
        if (row == col) adg += dif;
        if (row + col == n-1) dg += dif;
        if (rows[row] == n || cols[col] == n || adg == n || dg == n) return 1;
        else if (rows[row] == -n || cols[col] == -n || adg == -n || dg == -n) return 2;
        else return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */