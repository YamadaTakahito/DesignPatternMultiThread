package DesignPatternMultiThread.chap8;

import java.util.Random;

public class ClientThread extends Thread {
    private final Channel channel;
    private static final Random random = new Random();
    private volatile boolean terminated = false;

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        for (int i = 0; !terminated; i++) {
            try {
                var req = new Request(getName(), i);
                channel.putRequest(req);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ignored) {
                terminated = true;
            }
        }
    }

    public void stopThread() {
        terminated = true;
        this.interrupt();
    }
}
