class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int COLUMN = matrix[0].length;
        int ROW = matrix.length;
        int l=0;
        int r = ROW-1;
        int rowToCheck = -1;

        // Check if the target is within the range of the matrix
        if (target < matrix[0][0] || target > matrix[ROW - 1][COLUMN - 1]) {
            return false;
        }

        while(l<=r){
            int mid = (l+r)/2;
            // check target is between Row mid & mid+1
            if(matrix[mid][0]<= target && target <= matrix[mid][COLUMN-1]){
                rowToCheck = mid;
                break;
            } else if(target < matrix[mid][0]){
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        if(rowToCheck==-1){
            return false;
        }
        //Search rowToCheck Row
        int cl = 0;
        int cr = COLUMN-1;
        while(cl<=cr){
            int mid = (cl+cr)/2;
            if(matrix[rowToCheck][mid]==target){
                return true;
            } else if(matrix[rowToCheck][mid]>target){
                cr = mid-1;
            } else{
                cl = mid+1;
            }
        }
        return false;

    }
        
}
