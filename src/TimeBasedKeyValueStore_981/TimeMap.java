package TimeBasedKeyValueStore_981;

public interface TimeMap {
    void set(String key, String value, int timestamp);
    String get(String key, int timestamp);
}
