class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int islandCount = 0;
        int islandMaxSize = 0;
        int[] islandSize = new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, islandSize);
                    islandCount++;
                    islandMaxSize = Integer.max(islandMaxSize, islandSize[0]);
                    islandSize[0] = 0;
                }
            }
        }
        return islandMaxSize;    
    }

    private void dfs(int[][] grid, int i, int j, int[] islandSize) {
        // Boundary checks and base case
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        // Mark as visited by changing '1' to '0'
        grid[i][j] = 0;
        islandSize[0] += 1;


        // Explore all 4 directions
        dfs(grid, i - 1, j, islandSize); // up
        dfs(grid, i + 1, j, islandSize); // down
        dfs(grid, i, j - 1, islandSize); // left
        dfs(grid, i, j + 1, islandSize); // right
  }
}
