package DesignPatternMultiThread.chap4;

import DesignPatternMultiThread.chap4.practice.TestThread;

public class Chap4 {
    public static void main() {
//        var data = new Data("data.txt", "(empty)");
//        new ChangerThread("ChangerThread", data).start();
//        new ServerThread("ServerThread", data).start();
//
//        var host = new Host(10000);
//        try {
//            System.out.println("execute BEGIN");
//            host.execute();
//        } catch (TimeoutException | InterruptedException e) {
//            e.printStackTrace();
//        }

        var thread = new TestThread();
        while (true) {
            thread.start();
        }
    }
}
