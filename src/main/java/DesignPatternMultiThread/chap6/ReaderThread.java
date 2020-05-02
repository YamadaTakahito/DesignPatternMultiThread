package DesignPatternMultiThread.chap6;

public class ReaderThread extends Thread {
    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    public void run() {
        try {
            while (true) {
                var readbuf = data.read();
                System.out.println(this.getName() + " reads " + String.valueOf(readbuf));
            }
        } catch (InterruptedException ignored) {}
    }
}
