class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check Column
        for(int j = 0; j < board.length; j++) {
            Set<Integer> rowIntSet = new HashSet<>();
            for(int i = 0; i < board.length; i++){
                if(!isValid(rowIntSet, board[i][j])){
                    return false;
                }
            }
        }

        // check Row
        for(int i = 0; i < board.length; i++) {
            Set<Integer> columnIntSet = new HashSet<>();
            for(int j = 0; j < board.length; j++){
                if(!isValid(columnIntSet, board[i][j])){
                    return false;
                }
            }
        }

        // check boxes
        for(int m=0; m < 3; m++) {
            for(int n=0; n < 3; n++) {
                Set<Integer> boxIntSet = new HashSet<>();
                for(int i =0 ; i <3; i++){
                    for(int j = 0; j < 3; j++) {
                        if(!isValid(boxIntSet, board[3*m+i][3*n+j])){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    boolean isValid(Set<Integer> intSet, char ch) {
        if(ch != '.') {
            int num = ch - '0';
            if(num < 1 || num > 9 || intSet.contains(num)){
                return false;
            } else {
                intSet.add(num);
            }
        }
        return true; 
    }
}
