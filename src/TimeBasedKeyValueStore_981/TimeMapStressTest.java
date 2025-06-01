package TimeBasedKeyValueStore_981;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TimeMapStressTest {

    public static <T extends TimeMap> void stressTest_largeVolume(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        T timeMap = clazz.getDeclaredConstructor().newInstance();

        Random random = new Random(42); // фиксируем seed для воспроизводимости

        int numKeys = 10000;
        int entriesPerKey = 1000;
        int totalSets = numKeys * entriesPerKey;
        int totalGets = 100_000;

        // Подготовим ключи
        List<String> keys = new ArrayList<>();
        for (int i = 0; i < numKeys; i++) {
            keys.add("key" + i);
        }

        // SET: генерируем записи
        for (String key : keys) {
            int baseTime = 1;
            for (int i = 0; i < entriesPerKey; i++) {
                int timestamp = baseTime + i * 10; // гарантированно возрастающие
                String value = "val_" + key + "_" + timestamp;
                timeMap.set(key, value, timestamp);
            }
        }

        // GET: делаем много запросов
        for (int i = 0; i < totalGets; i++) {
            String key = keys.get(random.nextInt(numKeys));
            int timestamp = random.nextInt(entriesPerKey * 15); // может быть и вне диапазона

            String result = timeMap.get(key, timestamp);

            // Мы не проверяем конкретное значение, но важно, чтобы метод просто работал быстро и без исключений
        }
    }
}
