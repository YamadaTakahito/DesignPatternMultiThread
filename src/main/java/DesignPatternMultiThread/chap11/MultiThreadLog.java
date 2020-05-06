package DesignPatternMultiThread.chap11;

public class MultiThreadLog {
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<TSLog>();

    public static void println(String s) {
        getTSLog().println(s);
    }

    public static void close() {
        getTSLog().close();
    }

    private static TSLog getTSLog() {
        var tsLog = tsLogCollection.get();

        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
            startWatcher(tsLog);
        }
        return tsLog;
    }

    private static void startWatcher(TSLog tsLog) {
        var thread = Thread.currentThread();

        new Thread(() -> {
            System.out.println("startWatcher for " + thread.getName() + " BEGIN");
            try {
                thread.join();
            } catch (InterruptedException ignored) {}
            tsLog.close();
            System.out.println("startWatcher for " + thread.getName() + " END");
        }).start();
    }
}
