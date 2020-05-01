package DesignPatternMultiThread.chap4;

import java.io.IOException;

public class ServerThread extends Thread {
    private final Data data;

    public ServerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            while (true) {
                this.data.save();
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
