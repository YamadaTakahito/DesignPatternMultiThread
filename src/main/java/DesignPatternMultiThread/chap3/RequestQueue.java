package DesignPatternMultiThread.chap3;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<Request>();

    public synchronized Request getRequest() {
        var name = Thread.currentThread().getName();
        while (this.queue.peek() == null) {
            try {
//                System.out.println("thread: " + name + " starts to wait");
                wait();
//                System.out.println("thread: " + name + " finished to wait");
            } catch (InterruptedException ignored) {
                throw new RuntimeException(ignored);
            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request) {
        var name = Thread.currentThread().getName();
        queue.offer(request);
        notifyAll();
//        System.out.println("thread: " + name + " notified");
    }
//
//    private final BlockingQueue<Request> queue = new LinkedBlockingDeque<Request>();
//
//    public Request getRequest() {
//        Request req = null;
//        try {
//            req = queue.take();
//        } catch (InterruptedException ignored) {}
//        return req;
//    }
//
//    public void putRequest(Request request) {
//        try {
//            queue.put(request);
//        } catch (InterruptedException ignored) {}
//    }
}
