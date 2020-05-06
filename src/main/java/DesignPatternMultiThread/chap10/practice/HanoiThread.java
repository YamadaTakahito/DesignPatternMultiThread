package DesignPatternMultiThread.chap10.practice;

public class HanoiThread extends Thread {
    private volatile boolean shutdownRequested = false;
    private volatile long requestedTimeMilis = 0;

    public void shutdownRequest() {
        requestedTimeMilis = System.currentTimeMillis();
        shutdownRequested = true;
        interrupt();
    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    public void run() {
        try {
            for (int i = 0; !isShutdownRequested(); i++) {
                System.out.println("==== LEVEL " + i + " ====");
                doWork(i, 'A', 'B', 'C');
                System.out.println("");
            }
        } finally {
            doShutdown();
        }

    }

    private void doWork(int level, char posA, char posB, char posC) {
        if (isShutdownRequested()) {
            return;
        }

        if (level > 0) {
            doWork(level - 1, posA, posC, posB);
            System.out.print(posA + "->" + posB + " ");
            doWork(level - 1, posC, posB, posA);
        }
    }

    private void doShutdown() {
        var time = System.currentTimeMillis() - requestedTimeMilis;
        System.out.println("doShutdown: Latency = " + time + " msec.");
    }
}
