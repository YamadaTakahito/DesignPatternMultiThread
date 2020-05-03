package DesignPatternMultiThread.chap7;

import DesignPatternMultiThread.chap7.practice.Blackhole;

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

//        System.out.println("main BEGIN");
////        var executorService = Executors.newCachedThreadPool();
//        var executorService = Executors.newScheduledThreadPool(5);
////        var host = new ExecutorHost(executorService);
//        var host = new ScheduledExecutorHost(executorService);
//        try {
//            host.request(10, 'A');
//            host.request(20, 'B');
//            host.request(30, 'C');
//        } finally {
//            executorService.shutdown();
//            System.out.println("main END");
//        }

//        System.out.println("main BEGIN");
////        var host = new NonThreadPerMessageHost();
//        var host = new NonAnonymousClassHost();
//        host.request(10, 'A');
//        host.request(20, 'B');
//        host.request(30, 'C');
//        System.out.println("main END");

//        new MyFrame();

//        try {
//            new MiniServer(8888).execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("BEGIN");
        var obj = new Object();
        Blackhole.enter(obj);
        System.out.println("END");
    }
}
