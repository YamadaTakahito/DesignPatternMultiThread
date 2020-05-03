package DesignPatternMultiThread.chap7;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryHost extends Host {
    private final ThreadFactory threadFactory;

    public ThreadFactoryHost(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        threadFactory.newThread(() -> helper.handle(count, c)).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
