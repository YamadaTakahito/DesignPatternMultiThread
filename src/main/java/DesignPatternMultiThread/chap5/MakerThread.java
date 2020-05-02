package DesignPatternMultiThread.chap5;

import java.util.Random;

public class MakerThread extends Thread {
    private final Random random;
    private final Table table;
    private static int id = 0;

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.random = new Random(seed);
        this.table = table;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                var cake = "[ Cake No." + nextId() + " by " + this.getName() + " ]";
                this.table.put(cake);
            }
        } catch (InterruptedException ignored) {}
    }

    private static synchronized int nextId() {
        return id++;
    }
}
