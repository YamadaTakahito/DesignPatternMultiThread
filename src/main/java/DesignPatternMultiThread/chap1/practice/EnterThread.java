package DesignPatternMultiThread.chap1.practice;

public class EnterThread extends Thread {
    private String name;
//    private final Tool lefthand;
//    private final Tool righthand;
//
//    public EnterThread(String name, Tool lefthand, Tool righthand) {
//        this.name = name;
//        this.lefthand = lefthand;
//        this.righthand = righthand;
//    }

    private final Pair pair;

    public EnterThread(String name, Pair pair) {
        this.name = name;
        this.pair = pair;
    }

    public void run() {
        while (true) {
            this.eat();
        }
    }

//    public synchronized void eat() {
//        synchronized (this.lefthand) {
//        System.out.println(this.name + " takes up " + lefthand + " (left).");
//
//            synchronized (this.righthand) {
//        System.out.println(this.name + " takes up " + righthand + " (right).");
//        System.out.println(this.name + " is eating now, yum yum.");
//        System.out.println(this.name + " put down " + this.righthand + " (right).");
//            }
//        System.out.println(this.name + " put down " + this.lefthand + " (left).");
//    }
//    }

    public synchronized void eat() {
        synchronized (this.pair) {
            System.out.println(this.name + " takes up " + this.pair + ".");
            System.out.println(this.name + " is eating now, yum yum.");
            System.out.println(this.name + " puts down " + this.pair + ".");
        }
    }
}
