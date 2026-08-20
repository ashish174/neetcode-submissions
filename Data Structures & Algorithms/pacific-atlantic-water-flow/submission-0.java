class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights==null || heights.length==0){
            return null;
        }
        int ROWS = heights.length;
        int COLUMNS = heights[0].length;
        boolean[][] pacific = new boolean[ROWS][COLUMNS];
        boolean[][] atlantic = new boolean[ROWS][COLUMNS];
        for(int c=0; c < COLUMNS; c++ ) {
            //Top row for pacific
            dfs(0, c, pacific, heights);
            //Bottom row for atlantic
            dfs(ROWS-1, c, atlantic, heights);
        }
        for(int r=0; r < ROWS; r++ ) {
            //Left coulmn for pacific
            dfs(r, 0, pacific, heights);
            //Right column for atlantic
            dfs(r, COLUMNS-1, atlantic, heights);
        }
        List<List<Integer>> finalList = new ArrayList<>();
        for(int r=0; r < ROWS; r++){
            for(int c=0; c < COLUMNS; c++) {
                if(pacific[r][c] && atlantic[r][c]) {
                    finalList.add(Arrays.asList(r,c));
                }
            }
        }
        return finalList;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        ocean[r][c] = true;
        for(int[] dir : directions){
            int nextRow = r + dir[0];
            int nextColumn = c + dir[1];
            if(nextRow >= 0 && nextRow < heights.length 
                && nextColumn >=0 && nextColumn < heights[0].length 
                && !ocean[nextRow][nextColumn]
                && heights[nextRow][nextColumn]>=heights[r][c]){
                    dfs(nextRow, nextColumn, ocean, heights);
                }
        }

    }
}
