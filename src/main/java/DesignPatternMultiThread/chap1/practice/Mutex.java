package DesignPatternMultiThread.chap1.practice;

public class Mutex {
    private int locks = 0;
    private Thread owner = null;

    public synchronized void lock() {
        var me = Thread.currentThread();
        while (this.locks > 0 && this.owner != me) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }
        this.locks++;
        this.owner = me;
    }

    public synchronized void unlock() {
        var me = Thread.currentThread();
        if (this.locks == 0 || this.owner != me) {
            return;
        }

        this.locks--;
        if (this.locks == 0) {
            this.owner = null;
            notifyAll();
        }
    }
}
