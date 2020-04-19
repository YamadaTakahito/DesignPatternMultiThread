package DesignPatternMultiThread.chap1;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Log {
    public static void println(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}

class BoundedResource {
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);

    public BoundedResource(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        this.semaphore.acquire();
        try {
            this.doUse();
        } finally {
            semaphore.release();
        }
    }

    protected void doUse() throws InterruptedException {
        Log.println("BEGIN: used = " + (this.permits - this.semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.println("END: used = " + (this.permits - this.semaphore.availablePermits()));
    }
}

class SemaphoreUserThread extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedResource resource;

    public SemaphoreUserThread(BoundedResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            while (true) {
                this.resource.use();
                Thread.sleep(this.random.nextInt(3000));
            }
        } catch (InterruptedException ignored) {

        }
    }
}
