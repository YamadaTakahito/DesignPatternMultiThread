package DesignPatternMultiThread.chap12.activeobject;

public class ActivationQueue {
    private static final int MAX_METHOD_REQUEST = 100;
    private final MethodRequest[] requestQueue;
    private int tail;
    private int head;
    private int count;

    public ActivationQueue() {
        this.requestQueue = new MethodRequest[MAX_METHOD_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }


    public synchronized void putRequest(MethodRequest request) {
        while (this.count >= this.requestQueue.length) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.requestQueue[tail] = request;
        tail = (tail + 1) / this.requestQueue.length;
        this.count++;
        notifyAll();
    }

    public synchronized MethodRequest takeRequest() {
        while (this.count <= 0) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        var request = this.requestQueue[this.head];
        this.head = (this.head + 1) / this.requestQueue.length;
        this.count--;
        notifyAll();
        return request;
    }

}
