//Using InnerClass and Binary Search Approach;
class TimeMap {
    
    class Pair {
        int timestamp;
        String value;
        
        Pair(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }
    }
    
    Map<String, List<Pair>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        int result = search(map.get(key), timestamp);
        return result == -1 ? "" : map.get(key).get(result).value;
    }
    
    int search(List<Pair> pairList, int target){
        int index = -1;
        int start = 0;
        int end = pairList.size()-1;
        int mid = 0;
        while(start <= end){
            mid = start + (end-start)/2;
            
            if(pairList.get(mid).timestamp <= target){
                index = mid;
                start = mid+1;
            } else{
                end = mid - 1;
            }
        }
        return index;
    }
}


/*
//Using TreeMap Approach;
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
*/

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */