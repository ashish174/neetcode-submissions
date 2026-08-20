class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n==0 || edges.length != n-1){
            return false;
        }
        int graphVertexCount = 0;
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();
        for(int[] edge : edges){
            //add edge to adj list of u
            if(!adjListMap.containsKey(edge[0])){
                adjListMap.put(edge[0], new ArrayList<>());
            }
            adjListMap.get(edge[0]).add(edge[1]);

            //add edge to adj list of v
            if(!adjListMap.containsKey(edge[1])){
                adjListMap.put(edge[1], new ArrayList<>());
            }
            adjListMap.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        graphVertexCount++;
        while(!queue.isEmpty()){
            int u = queue.remove();
            if(adjListMap.containsKey(u)){
                for(int v : adjListMap.get(u)) {
                    if(!visited[v]){
                        queue.add(v);
                        visited[v] = true;
                        graphVertexCount++;
                    }
                }    
            }
        }
        return graphVertexCount==n;

    }
}
