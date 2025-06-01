package TimeBasedKeyValueStore_981;

import java.util.*;

//https://leetcode.com/problems/time-based-key-value-store/solutions/
// 2 вариант, floorEntry
class TimeMap2 implements TimeMap {
    private final Map<String, TreeMap<Integer, String>> hashMap = new HashMap<>();

    public TimeMap2() {

    }

    // O(log n)
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap;

        if (hashMap.containsKey(key)) {
            treeMap = hashMap.get(key);
        } else {
            treeMap = new TreeMap<>();
        }
        treeMap.put(timestamp, value);
        hashMap.put(key, treeMap);
    }

    // O(log n)
    public String get(String key, int timestamp) {
        if (hashMap.containsKey(key)) {
            TreeMap<Integer, String> treeMap = hashMap.get(key);
            if (treeMap.containsKey(timestamp)) {
                return treeMap.get(timestamp);
            } else {
                Map.Entry<Integer, String> lastEntry = treeMap.floorEntry(timestamp);

                if (lastEntry != null) {
                    return lastEntry.getValue();
                } else {
                    return "";
                }
            }
        } else {
            return "";
        }
    }
}