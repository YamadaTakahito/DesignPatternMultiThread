package DesignPatternMultiThread.chap10;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MyTaskByCyclic implements Runnable {
    private static final int PHASE = 5;
    private final CyclicBarrier phaseBarrier;
    private final CountDownLatch doneLatch;
    private final int context;
    private static final Random random = new Random(314159);

    public MyTaskByCyclic(CyclicBarrier phaseBarrier, CountDownLatch doneLatch, int context) {
        this.phaseBarrier = phaseBarrier;
        this.doneLatch = doneLatch;
        this.context = context;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < PHASE; i++) {
                doPhase(i);
                phaseBarrier.await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        } finally {
            doneLatch.countDown();
        }
    }

    protected void doPhase(int phase) {
        var name = Thread.currentThread().getName();
        System.out.println(name + ":MyTask:BEGIN:context = " + context + ", phase =" + phase);
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException ignored) {
        } finally {
            System.out.println(name + ":MyTask:END:context = " + context + ", phase =" + phase);
        }
    }
}
