class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // find the row number
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        int top = 0, bot = ROWS - 1;
        int row = -1;
        while (top <= bot) {
            row = (top + bot) / 2;
            if (target > matrix[row][COLS - 1]) {
                top = row + 1;
            } else if (target < matrix[row][0]) {
                bot = row - 1;
            } else {
                break;
            }
        }
        // find the item in the row
        if(row != -1) {
            int l = 0, r = COLS-1;
            while(l <= r) {
                int columnMid = (l+r)/2;
                if(matrix[row][columnMid] > target) {
                    r = columnMid - 1;
                } else if (matrix[row][columnMid] < target) {
                    l = columnMid + 1;
                } else {
                    return true; // matrix[mid][columnMid] == target
                }
            }
        }

        return false;
    }
}
