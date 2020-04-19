package DesignPatternMultiThread.chap1.practice;

import DesignPatternMultiThread.chap1.Gate;

public class NewGate extends Gate {
    private int count = 0;
    private String name = "Nobody";
    private String address = "Nowhere";
    private final Mutex mutex = new Mutex();

    @Override
    public void pass(String name, String address) {
        mutex.lock();
        try {
            this.count++;
            this.name = name;
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ignored) {}
            this.address = address;
            this.check();
        } finally {
            mutex.unlock();
        }
    }

    @Override
    public String toString() {
        String s = null;
        mutex.lock();
        s = "No." + this.count + ": " + "," + this.address;
        mutex.unlock();
        return s;
    }

    private void check() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("******* BROKEN **********" + this.toString());
        }
    }
}
