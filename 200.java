// This code is written by davidsqf.
// Runtime: 1 ms, faster than 99.98% of Java online submissions for Number of Islands.
// Memory Usage: 41.2 MB, less than 5.07% of Java online submissions for Number of Islands.
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isIsland(grid, i, j)) {
                    num += 1;
                    grid = eraseIsland(grid, i, j);
                }
            }
        }
        return num;
    }
    private char[][] eraseIsland(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        int m = grid.length;
        int n = grid[0].length;
        if (i + 1 < m) {
            if (isIsland(grid, i + 1, j)) grid = eraseIsland(grid, i + 1, j);
        }
        if (i - 1 >= 0) {
            if (isIsland(grid, i - 1, j)) grid = eraseIsland(grid, i - 1, j);
        }
        if (j + 1 < n) {
            if (isIsland(grid, i, j + 1)) grid = eraseIsland(grid, i, j + 1);
        }
        if (j - 1 >= 0) {
            if (isIsland(grid, i, j - 1)) grid = eraseIsland(grid, i, j - 1);
        }
        return grid;
    }
    private boolean isIsland(char[][] grid, int i, int j) {
        return grid[i][j] == '1';
    }
}
