package DesignPatternMultiThread.chap4;

import java.util.concurrent.TimeoutException;

public class Host {
    private final long timeout;
    private boolean ready = false;

    public Host(long timeout) {
        this.timeout = timeout;
    }

    public synchronized void setExecutable(boolean on) {
        this.ready = on;
        notifyAll();
    }

    public synchronized void execute() throws InterruptedException, TimeoutException {
        var start = System.currentTimeMillis();
        while (!this.ready) {
            var now = System.currentTimeMillis();
            var rest = this.timeout - (now - start);
            if (rest <= 0) {
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " call doExecute");
    }
}
