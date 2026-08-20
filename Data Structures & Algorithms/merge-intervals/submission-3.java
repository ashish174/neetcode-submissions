class Solution {
    
    // 
    public int[][] merge(int[][] intervals) {
        //merge by interval start time
        Arrays.sort(intervals, (o1, o2) -> {
            return Integer.compare(o1[0], o2[0]);
        });
        List<int[]> intervalList = new ArrayList<>();
        int[] curr_interval = intervals[0];
        for(int i=1; i < intervals.length; i++){
            //No overlap
            if(curr_interval[1] < intervals[i][0]){
                intervalList.add(curr_interval);
                curr_interval = intervals[i];
            } else{
                //Merge
                curr_interval[1] = Integer.max(curr_interval[1], intervals[i][1]);
            }
        }
        //add last remaining
        intervalList.add(curr_interval);
        return intervalList.toArray(int[][]::new);
    }
} 
