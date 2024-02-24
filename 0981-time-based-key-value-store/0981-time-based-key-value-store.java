class TimeMap {
    
    Map<String, TreeMap<Integer, String>> map = new HashMap<>();
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        TreeMap<Integer, String> treemap = map.get(key);
        if(treemap == null){
            return "";
        }
        Integer floorNode = treemap.floorKey(timestamp);
        if(floorNode == null){
            return "";
        }
        return treemap.get(floorNode);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */