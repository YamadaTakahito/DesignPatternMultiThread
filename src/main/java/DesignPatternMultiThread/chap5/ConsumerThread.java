package DesignPatternMultiThread.chap5;

import java.util.Random;
import java.util.concurrent.Exchanger;

public class ConsumerThread extends Thread {
    private final Exchanger<char[]> exchanger;
    private char[] buffer = null;
    private final Random random;

    public ConsumerThread(Exchanger<char[]> exchanger, char[] buffer, long seed) {
        super("ConsumerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": BEFORE exchange");
                this.buffer = this.exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + ": AFTER exchange");

                for (int i = 0; i < this.buffer.length; i++) {
                    System.out.println(Thread.currentThread().getName() + ": -> " + this.buffer[i]);
                    Thread.sleep(random.nextInt(1000));
                }
            }
        } catch (InterruptedException ignored) {}
    }
}
