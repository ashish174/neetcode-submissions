class Solution {
    //[1,2] [2, 3] [3,4] [4,5], 
    public int eraseOverlapIntervals(int[][] intervals) {
        int minIntervalToRemove = 0;
        //sort by end & then start
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1]).thenComparingInt(a -> a[0]));
        int[] current = intervals[0];
        for(int i=1; i < intervals.length; i++){
            //No overlap case
            if(current[1] <= intervals[i][0]){
                current = intervals[i];
            } else {
                //overlap case
                minIntervalToRemove++;
            }
        }
        return minIntervalToRemove;
        
    }
}
