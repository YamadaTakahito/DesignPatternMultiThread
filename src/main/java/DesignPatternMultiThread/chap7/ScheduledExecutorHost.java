package DesignPatternMultiThread.chap7;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorHost extends Host {
    private final ScheduledExecutorService scheduledExecutorService;

    public ScheduledExecutorHost(ScheduledExecutorService scheduledExecutorService) {
        this.scheduledExecutorService = scheduledExecutorService;
    }

    @Override
    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        scheduledExecutorService.schedule(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                },
                3L,
                TimeUnit.SECONDS
        );
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
