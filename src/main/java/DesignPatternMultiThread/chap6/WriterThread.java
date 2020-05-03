package DesignPatternMultiThread.chap6;

import java.util.Random;

public class WriterThread extends Thread {
    private static final Random random = new Random();
    private final Data data;
    private final String filler;
    private int index = 0;

    public WriterThread(Data data, String filler) {
        this.data = data;
        this.filler = filler;
    }

//    public void run() {
//        try {
//            for (int i = 0; i < this.filler.length(); i++) {
//                data.write(this.filler.charAt(i));
//            }
//        } catch (InterruptedException ignored) {}
//    }

    public void run() {
        try {
            while (true) {
                var c = nextchar();
                data.write(c);
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException ignored) {}
    }

    private char nextchar() {
        var c = filler.charAt(index);
        index++;
        if (index >= filler.length()) {
            index = 0;
        }
        return c;
    }
}
