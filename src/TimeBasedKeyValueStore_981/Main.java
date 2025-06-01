package TimeBasedKeyValueStore_981;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        TimeMap2 obj = new TimeMap2();
        obj.set("foo", "bar", 1);
        String param_1 = obj.get("foo", 1);
        String param_2 = obj.get("foo",  3);
        obj.set("foo", "bar2", 4);
        String param_3 = obj.get("foo", 4);
        String param_4 =  obj.get("foo", 5);


        long start1 = System.currentTimeMillis();

        TimeMapStressTest.stressTest_largeVolume(TimeMap1.class);
        long end1 = System.currentTimeMillis();
        System.out.println("Time: " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();

        TimeMapStressTest.stressTest_largeVolume(TimeMap2.class);
        long end2 = System.currentTimeMillis();
        System.out.println("Time: " + (end2 - start2) + "ms");


    }
}
