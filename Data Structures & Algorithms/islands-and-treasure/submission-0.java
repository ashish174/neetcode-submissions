class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid==null || grid.length==0){
            return;
        }
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[i].length; j++){
                if(grid[i][j]== 0){
                    dfs(grid, i, j, 0);
                }
            }
        }        
    }

    void dfs(int[][] grid, int i, int j, int nearestIslandDistance){
        if(j < 0 || j >= grid[0].length || i < 0 || i >= grid.length || grid[i][j] == -1){
            return;
        }
        if(grid[i][j]==0){
            // treasure
            nearestIslandDistance = 0;
        } else {
            // land
            if(grid[i][j] <= nearestIslandDistance){
                return;
            }
            grid[i][j] = nearestIslandDistance;
        }
        //traverse left
        dfs(grid, i, j-1, nearestIslandDistance+1);

        //traverse right
        dfs(grid, i, j+1, nearestIslandDistance+1);

        //traverse top 
        dfs(grid, i-1, j, nearestIslandDistance+1);

        //traverse down
        dfs(grid, i+1, j, nearestIslandDistance+1);

    }
}
