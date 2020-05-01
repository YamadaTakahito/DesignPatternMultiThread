package DesignPatternMultiThread.chap4.practice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

import DesignPatternMultiThread.chap3.Request;

public class LinkedRequestQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingDeque<Request>();

    public synchronized Request getRequest() {
        Request req = null;
        try {
            req = queue.poll(30L, TimeUnit.SECONDS);
            if (req == null) {
                throw new LivenessException("");
            }
        } catch (InterruptedException ignored) {}
        return req;
    }

    public synchronized void putRequest(Request request) {
        try {
            var canOffer = queue.offer(request, 30L, TimeUnit.SECONDS);
            if (!canOffer) {
                throw new LivenessException("");
            }
        } catch (InterruptedException ignored) {}
    }

}
