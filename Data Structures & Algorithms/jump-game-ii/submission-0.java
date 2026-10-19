class Solution {
    public int jump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int[] parentList = new int[nums.length];
        int numOfSteps;
        int minNumOfSteps;
        Queue<Integer> idxQueue = new LinkedList<>();
        idxQueue.add(0);
        visited[0] = true;
        parentList[0] = -1;
        for(int i=1; i < nums.length; i++){
            int currNodeIdx = idxQueue.remove();
            int stepsAllowed = nums[currNodeIdx];
            int parent = currNodeIdx;
            for(int j=1; j <=stepsAllowed; j++){
                int finalIdx = (i-1)+j;
                if(!visited[finalIdx] && finalIdx < nums.length) {
                    visited[finalIdx] = true;
                    idxQueue.add(finalIdx);
                    parentList[finalIdx] = parent;
                    if(finalIdx==nums.length-1){
                        //output result found
                        return findNumOfJumps(finalIdx, parentList);
                    }
                    
                }
            }
        }
        return 0; 
    }

    int findNumOfJumps(int nodeIdx, int[] parentList){
        int jump = 0;
        while(parentList[nodeIdx]!=-1){
            jump++;
            nodeIdx = parentList[nodeIdx];
        }
        return jump;
    }

    private class NodeWithParent{
        int nodeIdx;
        int parentIdx;

        NodeWithParent(int nodeIdx, int parentIdx){
            this.nodeIdx = nodeIdx;
            this.parentIdx = parentIdx;
        }

    }
}
