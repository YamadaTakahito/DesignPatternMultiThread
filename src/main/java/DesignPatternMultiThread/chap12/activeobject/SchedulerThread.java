package DesignPatternMultiThread.chap12.activeobject;

public class SchedulerThread extends Thread {
    private final ActivationQueue queue;

    public SchedulerThread(ActivationQueue queue) {
        this.queue = queue;
    }

    public void invoke(MethodRequest request) {
        this.queue.putRequest(request);
    }

    public void run() {
        while (true) {
            var request = this.queue.takeRequest();
            request.execute();
        }
    }
}
