class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    // O(log n)
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap<>());
        map.get(key).put(timestamp, value);
    }
    
    // O(log n)
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) 
            return "";

        TreeMap<Integer, String> tree = map.get(key);
        Integer floorKey = tree.floorKey(timestamp);

        if (floorKey == null) 
            return ""; 

        return tree.get(floorKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */