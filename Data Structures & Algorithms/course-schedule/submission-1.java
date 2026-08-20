class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // check if graph has cycle (deadlock)
        // use DFS, if visited node come again in stack path, then there is a cycle
        
        Map<Integer, List<Integer>> coursePrequisiteMap = new HashMap<>();
        int[] visited = new int[numCourses];  
        for(int[] preq : prerequisites){
            if(!coursePrequisiteMap.containsKey(preq[0])){
                coursePrequisiteMap.put(preq[0], new ArrayList<>());                 
            }
            coursePrequisiteMap.get(preq[0]).add(preq[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(visited[i]==0){
                if(!dfs(i, visited, coursePrequisiteMap)){
                    return false;
                }
            }
        } 
        return true;   
    }


    private boolean dfs(int crs, int[] visited, Map<Integer, List<Integer>> coursePrequisiteMap){
        visited[crs] = 1;
        //If preReq not exist for a course
        if(!coursePrequisiteMap.containsKey(crs) || coursePrequisiteMap.get(crs).isEmpty()){
            visited[crs] = 2;
            return true;
        }
        for(int preq : coursePrequisiteMap.get(crs)){
            //Check for back edge/cycle
            if(visited[preq]==1) {
                return false;
            }
            if(!dfs(preq, visited, coursePrequisiteMap)) {
                return false;
            }
        }
        //No longer in recursion stack
        visited[crs] = 2;
        return true;
    }
}
