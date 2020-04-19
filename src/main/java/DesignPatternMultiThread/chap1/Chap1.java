package DesignPatternMultiThread.chap1;

import DesignPatternMultiThread.chap1.practice.NewGate;

public class Chap1 {
    public static void main() {
//        System.out.println("Testing Gate, hit CRL+C to exit.");
//        var gate = new Gate();
//
//        new UserThread(gate, "Allice", "Alaska").start();
//        new UserThread(gate, "Bobby", "Brazil").start();
//        new UserThread(gate, "Chris", "Canada").start();

//        var resource = new BoundedResource(3);
//
//        for (int i = 0; i < 10; i++) {
//            new SemaphoreUserThread(resource).start();
//        }

        System.out.println("Testing Gate, hit CRL+C to exit.");
        var gate = new NewGate();

        new UserThread(gate, "Allice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();

//        System.out.println("Testing EaterThread, hit CTRL+C to exit");
//        var spoon = new Tool("spoon");
//        var fork = new Tool("fork");
//        var pair = new Pair(spoon, fork);
//        new EnterThread("Alice", pair).start();
//        new EnterThread("Bobby", pair).start();
    }
}
