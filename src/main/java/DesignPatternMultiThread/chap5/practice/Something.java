package DesignPatternMultiThread.chap5.practice;

public class Something {
    public static void method(long x) throws InterruptedException {
        if (x != 0) {
            var obj = new Object();
            synchronized (obj) {
                obj.wait(x);
            }
        }
    }
}
