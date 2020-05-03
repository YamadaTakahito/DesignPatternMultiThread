package DesignPatternMultiThread.chap7;

import java.util.concurrent.Executor;

public class ExecutorHost extends Host {
    private final Executor executor;

    public ExecutorHost(Executor executor) {
        this.executor = executor;
    }

    @Override
    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        executor.execute(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        );
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
