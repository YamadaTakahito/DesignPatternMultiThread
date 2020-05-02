package DesignPatternMultiThread.chap5;

import java.util.Arrays;

public class Table {
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;

    public Table(int count) {
        this.buffer = new String[count];
        this.tail = 0;
        this.head = 0;
        this.count = count;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (this.count >= this.buffer.length) {
//            System.out.println(Thread.currentThread().getName() + " waiting in put");
            wait();
        }

        this.buffer[this.tail] = cake;
        this.tail = (this.tail + 1) % this.buffer.length;
        this.count++;
//        notifyAll();
        notify();
    }

    public synchronized String take() throws InterruptedException {
        while (this.count <= 0) {
//            System.out.println(Thread.currentThread().getName() + " waiting in take");
            wait();
        }
        var cake = this.buffer[head];
        this.head = (this.head + 1) % this.buffer.length;
        this.count--;
//        notifyAll();
        notify();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }

    public synchronized void clear() {
        Arrays.fill(this.buffer, null);
        this.count = this.buffer.length;
        this.tail = 0;
        this.head = 0;
        notifyAll();
    }
}
