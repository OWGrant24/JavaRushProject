package JavaRush.Java_Collections.Collections4.GarbageCollector.PhantomReferenceExp.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private final Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here +

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
        if (cache.get(key) != null) {
            return cache.get(key);
        } else {
            Class<?> clazzNew = Class.forName(clazz.getName());
            return (V) clazzNew.getDeclaredConstructor().newInstance();
        }

    }

    public boolean put(V obj) {
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            Object result = method.invoke(obj);
            return cache.put((K) result, obj) != null;

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        //TODO add your code here
        return false;
    }

    public int size() {
        return cache.size();
    }
}