package DesignPatternMultiThread.chap4.practice;

import java.util.LinkedList;
import java.util.Queue;

import DesignPatternMultiThread.chap3.Request;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        while (this.queue.peek() == null) {
            try {
                wait(30000);
                throw new LivenessException("exception");
            } catch (InterruptedException ignored) {}
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
    }

}
