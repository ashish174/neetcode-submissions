class Solution {
    //First pass, find all O on borders and their connected Os. Convert these to #
    //Second pass, Remaining O, you can convert to X. Revert # to O.
    final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        //1st pass
        //Traverse across boundary only
        //check for left and right column
        for(int i=0; i < m; i++){
            if(board[i][0]=='O'){
                markConnectedNodes(board, i, 0);
            }
            if(board[i][n-1]=='O'){
                markConnectedNodes(board, i, n-1);
            }
        }
        //check for top and bottom row
        for(int j=0; j < n; j++){
            if(board[0][j]=='O'){
                markConnectedNodes(board, 0, j);
            }
            if(board[m-1][j]=='O'){
                markConnectedNodes(board, m-1, j);
            }
        }

        //2nd pass
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(board[i][j]=='O'){
                    board[i][j]= 'X';
                } else if(board[i][j]=='#'){
                    board[i][j]= 'O';
                }
            }
        } 
    }

    void markConnectedNodes(char[][] board, int i, int j){
        board[i][j] = '#';
        for(int[] dir : dirs){
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x >= 0 && x < board.length && y >=0 && y < board[0].length && board[x][y]=='O'){
                markConnectedNodes(board, x, y);
            }
        }
    }
}
