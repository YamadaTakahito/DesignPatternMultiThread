package DesignPatternMultiThread.chap8.lecture;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public class ClientThread extends Thread {
    private final ExecutorService executorService;
    private static final Random random = new Random();

    public ClientThread(String name, ExecutorService executorService) {
        super(name);
        this.executorService = executorService;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                var req = new Request(getName(), i);
                executorService.execute(req);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException ignored) {} catch (RejectedExecutionException e) {
            System.out.println(getName() + " : " + e);
        }
    }
}
