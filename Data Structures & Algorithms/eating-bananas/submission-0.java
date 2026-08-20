class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles.length>h){
            return -1;
        }
        int maxK = findMax(piles);
        //Now k value will go from 1..maxK
        // We have to find the minimum K
        //Do binary search to find the min value between 1..maxK
        int l = 1;
        int r = maxK;
        int minK=maxK;
        int maxTimeTaken = 0;
        while(l<=r){
            int mid = (l+r)/2;
            int timeTaken = getTimeTaken(piles, mid);
            if(timeTaken <= h){
                //some candidate for k found
                minK = Math.min(minK, mid); 
                r = mid-1;
            } else{
                l = mid+1;
            }
        }
        return minK;
    }

    int findMax(int[] piles){
        int max=0;
        for(int heapSize: piles){
            max = Integer.max(max, heapSize);
        }
        return max;
    }

    int getTimeTaken(int[] piles, int speed){
        int timeTaken = 0;
        for(int heapSize: piles){
            timeTaken= timeTaken + (int) Math.ceil((double) heapSize/speed);
        }
        return timeTaken;
    }


}
