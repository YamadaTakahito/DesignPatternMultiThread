package DesignPatternMultiThread.chap10.practice;

public class Service {
    private static GracefulThread thread = null;

    public synchronized static void service() {
        System.out.print("Service");
        if (thread != null && thread.isAlive()) {
            System.out.println("is balked");
            return;
        }

        thread = new DotThread();
        thread.start();
    }

    public static void cancel() {
        if (thread != null) {
            System.out.println("cancel.");
            thread.shutdownRequest();
        }
    }
}
