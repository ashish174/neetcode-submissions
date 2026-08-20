class Solution {
    private int[][] directions = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    private int INF = 2147483647;
    private int rows, columns;

    public void islandsAndTreasure(int[][] grid) {
        if(grid==null || grid.length==0){
            return;
        }
        rows = grid.length;
        columns = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int r=0; r < rows; r++){
            for(int c=0; c < columns; c++){
                if(grid[r][c]==0){
                    queue.add(new int[] {r, c});
                }
            }
        }
        if(queue.isEmpty()){
            return;
        }
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int column = cell[1];

            // Explore all 4 neighbors
            for(int[] dir : directions){
                int nextRow = row + dir[0];
                int nextColumn = column + dir[1];
                //Boundary check
                if(nextRow<0 || nextRow >=rows || nextColumn <0 || nextColumn >= columns){
                    continue;
                }
                // Only update land cells that are still INF
                // If it's water (-1) or already has a shorter distance, skip
                if(grid[nextRow][nextColumn] != INF) {
                    continue;
                }
                grid[nextRow][nextColumn] = grid[row][column] + 1;
                //Add neighbor to queue to continue BFS
                queue.add(new int[] {nextRow, nextColumn});
            }
        }
        

    }
}
