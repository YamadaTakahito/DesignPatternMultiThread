package DesignPatternMultiThread.Intro;

import java.util.concurrent.Executors;

import DesignPatternMultiThread.Intro.practice.Bank;

public class Intro {
    public static void main() {
//        new PrintThread("Good.").start();
//        new PrintThread("Nice.").start();

//        new Thread(new Printer("Good.")).start();
//        new Thread(new Printer("Nice.")).start();

//        var factory = Executors.defaultThreadFactory();
//        factory.newThread(new Printer("Nice.")).start();
//        for (int i = 0; i < 10000; i++) {
//            System.out.print("Good");
//        }

//        for (int i = 0; i < 10; i++) {
//            System.out.print("Good!");
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignored) {
//            }
//        }

//        practice 1.4
        var factory = Executors.defaultThreadFactory();
        var bank = new Bank(1000, "bank");
        for (int i = 0; i < 10; i++) {
            factory.newThread(() -> bank.withdraw(1000)).start();
        }
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException ignore) {
//        }
    }
}
