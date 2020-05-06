package DesignPatternMultiThread.chap11;

import java.util.concurrent.Executors;

public class Chap11 {
    public static void main() {
//        System.out.println("BEGIN");
//        for (int i = 0; i < 10; i++) {
//            Log.println("main: i = " + i);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ignored) {}
//        }
//        Log.close();
//        System.out.println("END");

//        new ClientThread("Alice").start();
//        new ClientThread("Bobby").start();
//        new ClientThread("Chris").start();

        int TASKS = 10;
        var service = Executors.newFixedThreadPool(3);
        try {
            for (int i = 0; i < TASKS; i++) {
                var printTask = new Runnable() {
                    @Override
                    public void run() {
                        Log.println("Hello!");
                        Log.close();
                    }
                };
                service.execute(printTask);
            }
        } finally {
            service.shutdown();
        }
    }
}
