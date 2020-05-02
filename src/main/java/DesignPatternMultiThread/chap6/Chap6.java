package DesignPatternMultiThread.chap6;

public class Chap6 {
    public static void main() {
        var data = new Data(10);
        for (int i = 0; i < 6; i++) {
            new ReaderThread(data).start();
        }
        new WriterThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
        new WriterThread(data, "abcdefghijklmnopqrstuvwxyz").start();
    }
}
