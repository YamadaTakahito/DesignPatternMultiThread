package DesignPatternMultiThread.chap6.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Database<K, V> {
    private final Map<K, V> map = new HashMap<K, V>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public synchronized void clear() {
        verySlowly();
        map.clear();
    }

    public synchronized void assign(K key, V value) {
        verySlowly();
        map.put(key, value);
    }

    public synchronized V retrieve(K key) {
        slowly();
        return map.get(key);
    }

//    public void clear() {
//        writeLock.lock();
//        try {
//            verySlowly();
//            map.clear();
//        } finally {
//            writeLock.unlock();
//        }
//    }
//
//    public void assign(K key, V value) {
//        writeLock.lock();
//        try {
//            verySlowly();
//            map.put(key, value);
//        } finally {
//            writeLock.unlock();
//        }
//    }
//
//    public V retrieve(K key) {
//        readLock.lock();
//        try {
//            slowly();
//            return map.get(key);
//        } finally {
//            readLock.unlock();
//        }
//    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ignored) {}
    }

    private void verySlowly() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}
    }
}
