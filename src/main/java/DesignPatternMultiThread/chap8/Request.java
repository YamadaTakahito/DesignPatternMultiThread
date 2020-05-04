package DesignPatternMultiThread.chap8;

import java.util.Random;

public class Request {
    private final String name;
    private final int number;
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException ignored) {}
    }

    @Override
    public String toString() {
        return "Reuqest{" +
               "name='" + name + '\'' +
               ", number=" + number +
               '}';
    }
}
