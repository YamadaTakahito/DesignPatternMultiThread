package DesignPatternMultiThread.chap7.practice.quiz5;

public class Service {
    private static volatile boolean working = false;

    public static void service() {
        if (working) {
            System.out.println("is balked");
            return;
        }
        working = true;
        new Thread(() -> doService()).start();
    }

    public static void doService() {
        try {
            for (int i = 0; i < 50; i++) {

                System.out.print(".");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {}
            }

            System.out.println("done");
        } finally {
            working = false;
        }
    }
}
