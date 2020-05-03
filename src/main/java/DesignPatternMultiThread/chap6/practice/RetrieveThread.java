package DesignPatternMultiThread.chap6.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class RetrieveThread extends Thread {
    private final Database<String, String> database;
    private final String key;
    private static final AtomicInteger atomicCounter = new AtomicInteger(0);

    public RetrieveThread(
            Database<String, String> database, String key) {
        this.database = database;
        this.key = key;
    }

    public void run() {
        while (true) {
            var count = atomicCounter.incrementAndGet();
            var val = database.retrieve(this.key);
            System.out.println(count + ":" + key + " => " + val);
        }
    }
}
