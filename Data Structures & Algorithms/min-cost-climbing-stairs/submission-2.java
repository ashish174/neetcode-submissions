class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memoization = new int[n+1];
        return Math.min(minCost(cost, n, memoization), minCost(cost, n-1, memoization));
    }

    int minCost(int[] cost, int n, int[] memoization){
        if(n==1 || n==2) {
            return cost[n-1];
        }
        if(memoization[n]==0) {
            memoization[n] = cost[n-1] + Math.min(minCost(cost, n-1, memoization), minCost(cost, n-2, memoization));
        }
        return memoization[n];
    }
}
