/*
 * @lc app=leetcode id=695 lang=java
 *
 * [695] Max Area of Island
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rols = grid.length;
        int columns = grid[0].length;
        int max = 0;
        for (int i = 0; i < rols; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));

                }
            }
        }

        return max;

    }

    private int dfs(int[][] grid, int i, int j) {
        int rols = grid.length;
        int columns = grid[0].length;

        if (i < 0 || j < 0 || i >= rols || j >= columns || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j - 1);
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i, j + 1);

        return count;
    }
}
// @lc code=end
