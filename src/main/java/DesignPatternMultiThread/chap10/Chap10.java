package DesignPatternMultiThread.chap10;

public class Chap10 {
    public static void main() {
        System.out.println("main: START");
        try {
            var t = new CountupThread();
            t.start();

            Thread.sleep(10000);

            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            System.out.println("main: join");

            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        Thread.setDefaultUncaughtExceptionHandler(
//                (t, e) -> {
//                    System.out.println("****");
//                    System.out.println("UncaughtExceptionHandler:BEGIN");
//                    System.out.println("currentThread = " + Thread.currentThread().getName());
//                    System.out.println("thread = " + t);
//                    System.out.println("exception = " + e);
//                    System.out.println("UncaughtExceptionHandler:END");
//                }
//        );
//
//        Runtime.getRuntime().addShutdownHook(
//                new Thread(() -> {
//                    System.out.println("****");
//                    System.out.println("shutdown hook:BEGIN");
//                    System.out.println("currentThread = " + Thread.currentThread());
//                    System.out.println("shutdown hook:END");
//                })
//        );
//
//        new Thread(() -> {
//            System.out.println("MyThread:BEGIN");
//
//            System.out.println("MyThread:SLEEP...");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException ignored) {
//            }
//
//            System.out.println("MyThread:DIVIDE");
//            int x = 1 / 0;
//
//            System.out.println("MyThread:END");
//        }, "MyThread").start();
//        System.out.println("main: END");

//        System.out.println("BEGIN");
//        var service = Executors.newFixedThreadPool(5);
//        var doneLatch = new CountDownLatch(10);
//
//        try {
//            for (int i = 0; i < 10; i++) {
//                service.execute(new MyTask(doneLatch, i));
//            }
//
//            System.out.println("AWAIT");
//            doneLatch.await();
//        } catch (InterruptedException ignored) {
//        } finally {
//            service.shutdown();
//            System.out.println("END");
//        }
//        System.out.println("END");

//        System.out.println("BEGIN");
//        var THREADS = 3;
//        var service = Executors.newFixedThreadPool(THREADS);
//        var barrierAction = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Barrier Action!");
//            }
//        };
//
//        var phaseBarrier = new CyclicBarrier(THREADS, barrierAction);
//        var doneLatch = new CountDownLatch(THREADS);
//
//        try {
//            for (int i = 0; i < THREADS; i++) {
//                service.execute(new MyTaskByCyclic(phaseBarrier, doneLatch, i));
//            }
//
//            System.out.println("AWAIT");
//            doneLatch.await();
//        } catch (InterruptedException ignored) {
//        } finally {
//            service.shutdown();
//            System.out.println("END");
//        }
//        System.out.println("END");
    }

}
