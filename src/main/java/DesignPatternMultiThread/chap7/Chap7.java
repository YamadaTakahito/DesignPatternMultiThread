package DesignPatternMultiThread.chap7;

import java.util.concurrent.Executors;

public class Chap7 {
    public static void main() {
//        System.out.println("main BEGIN");
////        var host = new Host();
//        var host = new RunnableHost();
//        host.request(10, 'A');
//        host.request(20, 'B');
//        host.request(30, 'C');
//        System.out.println("main END");

//        System.out.println("main BEGIN");
//        var host = new ThreadFactoryHost(
//                new ThreadFactory() {
//                    @Override
//                    public Thread newThread(Runnable r) {
//                        return new Thread(r);
//                    }
//                }
//        );
//        var host = new ThreadFactoryHost(
//                Executors.defaultThreadFactory()
//        );
//        var host = new ExecutorHost(
//                new Executor() {
//                    @Override
//                    public void execute(Runnable command) {
//                        new Thread(command).start();
//                    }
//                }
//        );
//        host.request(10, 'A');
//        host.request(20, 'B');
//        host.request(30, 'C');
//        System.out.println("main END");

        System.out.println("main BEGIN");
//        var executorService = Executors.newCachedThreadPool();
        var executorService = Executors.newScheduledThreadPool(5);
//        var host = new ExecutorHost(executorService);
        var host = new ScheduledExecutorHost(executorService);
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            executorService.shutdown();
            System.out.println("main END");
        }
    }
}
