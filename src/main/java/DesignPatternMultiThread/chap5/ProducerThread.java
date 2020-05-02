package DesignPatternMultiThread.chap5;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ProducerThread extends Thread {
    private final Exchanger<char[]> exchanger;
    private char[] buffer = null;
    private char index = 0;
    private final Random random;

    public ProducerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ProducerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = this.nextChar();
                    System.out.println(Thread.currentThread().getName() + ": " + buffer[i]);
                }

                System.out.println(Thread.currentThread().getName() + ": BEFORE exchange");
                this.buffer = this.exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + ": AFTER exchange");
            }
        } catch (InterruptedException ignored) {}
    }

    private char nextChar() throws InterruptedException {
        char c = (char) ('A' + this.index % 26);
        this.index++;
        Thread.sleep(random.nextInt(1000));
        return c;
    }
}
