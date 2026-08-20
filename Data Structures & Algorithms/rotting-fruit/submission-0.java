class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0){
            return -1;
        }
        int[][] directions = {{0,-1}, {0,1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        int[][] minRottingTimeMatrix = new int[grid.length][grid[0].length];
        int minRottingTime = 0;
        // find all rotten banana and do multi BFS
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cell = queue.remove();
            int r = cell[0];
            int c = cell[1];
            
            // check all directions
            for(int[] dir : directions){
                int nextRow = r + dir[0];
                int nextColumn = c + dir[1];
                //check boundaries
                if(nextRow < 0 || nextRow >= grid.length || nextColumn < 0 || nextColumn >= grid[0].length){
                    continue;
                }
                // Skip for anything other than banana
                if(grid[nextRow][nextColumn] != 1) {
                    continue;
                }
                //If neighbour has banana
                if(grid[nextRow][nextColumn]==1 && minRottingTimeMatrix[nextRow][nextColumn] == 0) {
                    grid[nextRow][nextColumn] = 2;
                    minRottingTimeMatrix[nextRow][nextColumn] = minRottingTimeMatrix[r][c] + 1;
                    minRottingTime = Integer.max(minRottingTime, minRottingTimeMatrix[nextRow][nextColumn]);
                    queue.add(new int[]{nextRow, nextColumn});
                }
            }

        }
        // Check if there is any good banana left
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return minRottingTime;     
    }
}
