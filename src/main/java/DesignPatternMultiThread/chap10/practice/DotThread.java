package DesignPatternMultiThread.chap10.practice;

public class DotThread extends GracefulThread {
    private int count = 0;

    @Override
    protected void doWork() throws InterruptedException {
        System.out.print(".");
        Thread.sleep(100);
        count++;
        if (count >= 50) {
            shutdownRequest();
        }
    }

    @Override
    protected void doShutdown() {
        System.out.println("done");
    }
}


