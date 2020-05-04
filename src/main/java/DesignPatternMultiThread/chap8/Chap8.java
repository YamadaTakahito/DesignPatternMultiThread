package DesignPatternMultiThread.chap8;

public class Chap8 {
    public static void main() {
//        var channel = new Channel(5);
//        channel.startWorkers();
//        new ClientThread("Alice", channel).start();
//        new ClientThread("Bobby", channel).start();
//        new ClientThread("Chris", channel).start();
//
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException ignored) {}
//        System.exit(0);
//
//        var executorService = Executors.newFixedThreadPool(5);
//
//        try {
//            new ClientThread("Alice", executorService).start();
//            new ClientThread("Bobby", executorService).start();
//            new ClientThread("Chris", executorService).start();
//
//            Thread.sleep(5000);
//        } catch (InterruptedException ignored) {
//        } finally {
//            executorService.shutdown();
//        }

//        System.out.println(Thread.currentThread().getName() + " :BEGIN");
//        new MyFrame();
//        System.out.println(Thread.currentThread().getName() + " :END");

        var channel = new Channel(5);
        channel.startWorkers();
        var alice = new ClientThread("Alice", channel);
        var bobby = new ClientThread("Bobby", channel);
        var chris = new ClientThread("Chris", channel);
        alice.start();
        bobby.start();
        chris.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {}
        alice.stopThread();
        bobby.stopThread();
        chris.stopThread();
        channel.stopAllWorkers();
    }
}
