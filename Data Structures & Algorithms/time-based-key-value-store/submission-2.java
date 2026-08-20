class TimeMap {
    Map<String, List<ValueNode>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        ValueNode node =  new ValueNode(value, timestamp);
        List<ValueNode> nodeList = null;
        if(!timeMap.containsKey(key)){
            nodeList = new ArrayList<>();
            nodeList.add(node);
            timeMap.put(key, nodeList);
        } else {
            timeMap.get(key).add(node);
        }   
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)){
            return "";
        }
        List<ValueNode> nodeList = timeMap.get(key);
        int l = 0;
        int r = nodeList.size() -1;
        ValueNode maxValueLessThanTS = new ValueNode("", 0) ;
        //1, 4, 7, 9 ,10 
        // Search for 6 -> 4
        while(l <= r){
            int mid = (l+r)/2;
            if(nodeList.get(mid).timeStamp > timestamp){
                r = mid-1;
            } else {
                maxValueLessThanTS = nodeList.get(mid).timeStamp > maxValueLessThanTS.timeStamp
                    ? nodeList.get(mid)
                    : maxValueLessThanTS;
                l = mid+1;
            }
        }
        return maxValueLessThanTS.value;
        
    }

    class ValueNode{
        String value;
        int timeStamp;

        public ValueNode(String value, int timeStamp){
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }
}
