package DesignPatternMultiThread.chap6;

import DesignPatternMultiThread.chap6.practice.AssignThread;
import DesignPatternMultiThread.chap6.practice.Database;
import DesignPatternMultiThread.chap6.practice.RetrieveThread;

public class Chap6 {
    public static void main() {
//        var data = new Data(10);
//        for (int i = 0; i < 6; i++) {
//            new ReaderThread(data).start();
//        }
//        new WriterThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
//        new WriterThread(data, "abcdefghijklmnopqrstuvwxyz").start();

        var database = new Database<String, String>();

        new AssignThread(database, "Alice", "Alaska").start();
        new AssignThread(database, "Alice", "Australia").start();
        new AssignThread(database, "Bobby", "Brazil").start();
        new AssignThread(database, "Bobby", "Bulgaria").start();

        for (int i = 0; i < 100; i++) {
            new RetrieveThread(database, "Alice").start();
            new RetrieveThread(database, "Bobby").start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {}

        System.exit(0);
    }
}
