class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(grid, visited, i, j));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length 
            || grid[i][j] == 0 || visited[i][j]) return 0;

        visited[i][j] = true;

        int area = 1;
        area += dfs(grid, visited, i + 1, j);
        area += dfs(grid, visited, i - 1, j);
        area += dfs(grid, visited, i, j + 1);
        area += dfs(grid, visited, i, j - 1);

        return area;
    }
}