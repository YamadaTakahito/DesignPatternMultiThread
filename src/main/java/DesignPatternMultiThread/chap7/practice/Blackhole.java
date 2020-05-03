package DesignPatternMultiThread.chap7.practice;

public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step2");
        synchronized (obj) {
            System.out.println("Step3 (never reached here");
        }
    }

    public static void magic(Object obj) {
        new Thread() {
            @Override
            public void run() {
                synchronized (obj) {
                    while (true) {}
                }
            }
        }.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}
    }
}
