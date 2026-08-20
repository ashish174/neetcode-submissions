class Solution {
    public int numIslands(char[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        int[] islandCount = new int[1];
        for(int i = 0; i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j]=='1' && visited[i][j]==0) {
                    islandCount[0] += 1;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return islandCount[0];
    }

    void dfs(int i, int j, char[][] grid, int[][] visited){
        if(grid[i][j]=='1' && visited[i][j]==0) {
                visited[i][j] = 1; 
                //check left
                if(j-1 >=0 && grid[i][j-1] == '1'){
                    dfs(i, j-1, grid, visited);
                }
                //check right
                if(j+1 < grid[0].length && grid[i][j+1] == '1'){
                    dfs(i, j+1, grid, visited);
                }
                //check up
                if(i-1 >=0  && grid[i-1][j] == '1') {
                    dfs(i-1, j, grid, visited);
                }
                //checkdown
                if(i+1 < grid.length  && grid[i+1][j] == '1') {
                    dfs(i+1, j, grid, visited);
                }

        }
        return;
    }
}
