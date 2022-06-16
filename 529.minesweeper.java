import java.util.*;

/*
 * @lc app=leetcode id=529 lang=java
 *
 * [529] Minesweeper
 */

// @lc code=start
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        switch (board[x][y]) {
            case 'M':
                board[x][y] = 'X';
                break;
            case 'E':
                dfs(board, x, y);
                break;
            default:
                break;
        }
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
            return;
        }
        int count = adjMines(board, x, y);
        if (count > 0) {
            board[x][y] = Character.forDigit(count, 10);
        } else {
            board[x][y] = 'B';
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i == x && j == y) {
                        continue;
                    }
                    dfs(board, i, j);
                }
            }
        }
    }

    public int adjMines(char[][] board, int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length
                        && (board[i][j] == 'M' || board[i][j] == 'X')) {
                    count++;
                }
            }
        }
        return count;
    }
}
// @lc code=end
