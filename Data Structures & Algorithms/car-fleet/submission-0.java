class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length==0){
            return 0;
        }
        float[][] remainingDistanceAndTime = new float[position.length][2];
        for(int i=0; i< position.length; i++){
            //remaining distance from target
            remainingDistanceAndTime[i][0] = target - position[i];
            //remaining time from target
            remainingDistanceAndTime[i][1] = remainingDistanceAndTime[i][0] / speed[i];
        }
        //Sort by remainingDistance, i.e. who is in front first
        Arrays.sort(remainingDistanceAndTime, Comparator.comparingDouble(rowElem -> rowElem[0]));

        Stack<Float> timeUpperBoundForFleet = new Stack<>();
        timeUpperBoundForFleet.push(remainingDistanceAndTime[0][1]);
        for(int l=0; l<remainingDistanceAndTime.length; l++){
            if(remainingDistanceAndTime[l][1] > timeUpperBoundForFleet.peek()){
                timeUpperBoundForFleet.push(remainingDistanceAndTime[l][1]);
            }
        }
        return timeUpperBoundForFleet.size();
        
    }
}
