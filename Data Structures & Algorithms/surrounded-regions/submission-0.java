class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0){
            return;
        }
        int ROWS = board.length;
        int COLUMNS = board[0].length;
        boolean[][] cornerReachable = new boolean[ROWS][COLUMNS];
        for(int r=0; r < ROWS; r++) {
            //
            if(board[r][0]=='O'){
                dfs(r, 0, board, cornerReachable);
            }
            if(board[r][COLUMNS-1]=='O'){
                dfs(r, COLUMNS-1, board, cornerReachable);
            }
        }

        for(int c=0; c < COLUMNS; c++) {
            if(board[0][c]=='O'){
                dfs(0, c, board, cornerReachable);
            }
            if(board[ROWS-1][c]=='O'){
                dfs(ROWS-1, c, board, cornerReachable);
            }
        }

        for(int r=0; r<ROWS; r++){
            for(int c=0; c < COLUMNS; c++){
                if(board[r][c]=='O' && !cornerReachable[r][c]){
                    board[r][c] = 'X';
                }
            }
        }
        
    }

    // dfs to find all 0s reachable from corner 0
    void dfs(int r, int c,  char[][] board, boolean[][] cornerReachable){
        cornerReachable[r][c] = true;
        int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        for(int[] dir : directions) {
            int nextRow = r + dir[0];
            int nextColumn = c + dir[1];
            // check boundaries
            if(nextRow<0 || nextRow >= board.length || nextColumn <0 || nextColumn >= board[0].length){
                continue;
            }
            if(board[nextRow][nextColumn]=='O' && !cornerReachable[nextRow][nextColumn]){
                dfs(nextRow, nextColumn, board, cornerReachable);
            }
        }

    }
}
