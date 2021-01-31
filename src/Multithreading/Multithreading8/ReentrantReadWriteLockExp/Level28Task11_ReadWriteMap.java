package Multithreading.Multithreading8.ReentrantReadWriteLockExp;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Level28Task11_ReadWriteMap<K, V> {
    private final Map<K, V> map;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock;
    private final Lock writeLock;

    public Level28Task11_ReadWriteMap(Map<K, V> map) {
        readLock = lock.readLock();
        writeLock = lock.writeLock();
        this.map = map;
    }

    public V put(K key, V value) {
        try {
            writeLock.lock();
            return map.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public V get(K key) {
        try {
            readLock.lock();
            return map.get(key);
        } finally {
            readLock.unlock();
        }
    }
}
