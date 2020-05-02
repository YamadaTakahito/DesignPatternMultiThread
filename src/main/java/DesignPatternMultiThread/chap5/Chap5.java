package DesignPatternMultiThread.chap5;

import DesignPatternMultiThread.chap5.practice.LazyThread;

public class Chap5 {
    public static void main() {
//        var table = new Table(3);
//        new MakerThread("MakerThread-1", table, 31415).start();
//        new MakerThread("MakerThread-2", table, 92653).start();
//        new MakerThread("MakerThread-3", table, 58979).start();
//        new EaterThread("EaterThread-1", table, 32384).start();
//        new EaterThread("EaterThread-2", table, 62643).start();
//        new EaterThread("EaterThread-3", table, 38327).start();

//        var exchanger = new Exchanger<char[]>();
//        var buffer1 = new char[1];
//        var buffer2 = new char[10];
//        new ProducerThread(exchanger, buffer1, 314159).start();
//        new ConsumerThread(exchanger, buffer2, 265358).start();

//        var table = new Table(3);
//        Thread[] threads = {
//                new MakerThread("MakerThread-1", table, 31415),
//                new MakerThread("MakerThread-2", table, 92653),
//                new MakerThread("MakerThread-3", table, 58979),
//                new EaterThread("EaterThread-1", table, 32384),
//                new EaterThread("EaterThread-2", table, 62643),
//                new EaterThread("EaterThread-3", table, 38327)
//        };
//
//        for (Thread t : threads) {
//            t.start();
//        }
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException ignored) {}
//
//        for (Thread t : threads) {
//            var current = System.currentTimeMillis();
//            t.interrupt();
//            System.out.println((current - System.currentTimeMillis()) + " milis passed");
//        }

//        var executor = new Thread() {
//            public void run() {
//                System.out.println("Host.execute BEGIN");
//                try {
//                    Host.execute(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("Host.execute END");
//            }
//        };
//
//        executor.start();
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException ignored) {
//        }
//
//        System.out.println("****** interrupt *******");
//        executor.interrupt();

        var table = new Table(3);
        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 92653).start();
        new MakerThread("MakerThread-3", table, 58979).start();
        new EaterThread("EaterThread-1", table, 32384).start();
        new EaterThread("EaterThread-2", table, 62643).start();
        new EaterThread("EaterThread-3", table, 38327).start();
        for (int i = 0; i < 6; i++) {
            new LazyThread("LazyThread-" + i, table).start();
        }
    }
}
