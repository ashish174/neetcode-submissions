class Solution {
    public int climbStairs(int n) {
        int[] memoization = new int[n+1];
        return climb(n, memoization);        
    }

    public int climb(int n, int[] memoization) {
        if(n==0 || n==1) {
            return 1;
        }
        if(memoization[n]==0) {
           memoization[n] =  climbStairs(n-1) + climbStairs(n-2);
        }
        return memoization[n];
    }

}
