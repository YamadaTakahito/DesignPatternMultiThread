package DesignPatternMultiThread.chap3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class RequestQueue {
//    private final Queue<Request> queue = new LinkedList<Request>();
//
//    public synchronized Request getRequest() {
//        while (this.queue.peek() == null) {
//            try {
//                wait();
//            } catch (InterruptedException ignored) {
//
//            }
//        }
//        return queue.remove();
//    }
//
//    public synchronized void putRequest(Request request) {
//        queue.offer(request);
//        notifyAll();
//    }

    private final BlockingQueue<Request> queue = new LinkedBlockingDeque<Request>();

    public Request getRequest() {
        Request req = null;
        try {
            req = queue.take();
        } catch (InterruptedException ignored) {}
        return req;
    }

    public void putRequest(Request request) {
        try {
            queue.put(request);
        } catch (InterruptedException ignored) {}
    }
}
