package TimeBasedKeyValueStore_981;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// 1 вариант, медленный цикл
class TimeMap1 implements TimeMap{
    private final Map<String, Map<Integer, String>> hashMap = new HashMap<>();

    public TimeMap1() {

    }

    // O(1)
    public void set(String key, String value, int timestamp) {
        Map<Integer, String> linkedHashMap;

        if (hashMap.containsKey(key)) {
            linkedHashMap = hashMap.get(key);
        } else {
            linkedHashMap = new LinkedHashMap<>();
        }
        linkedHashMap.put(timestamp, value);
        hashMap.put(key, linkedHashMap);
    }

    // O(n)
    public String get(String key, int timestamp) {
        if (hashMap.containsKey(key)) {
            Map<Integer, String> linkedHashMap = hashMap.get(key);
            if (linkedHashMap.containsKey(timestamp)) {
                return linkedHashMap.get(timestamp);
            } else {
                Map.Entry<Integer, String> lastEntry = null;
                for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
                    if (entry.getKey() > timestamp) {
                        break;
                    }
                    lastEntry = entry;
                }

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