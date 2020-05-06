package DesignPatternMultiThread.chap12.standardactiveobject;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ActiveObjectImpl implements ActiveObject {
    private final ExecutorService service = Executors.newSingleThreadExecutor();

    @Override
    public Future<String> makeString(int count, char fillchar) {
        var callable = new Callable<String>() {
            @Override
            public String call() {
                var buffer = new char[count];

                for (int i = 0; i < count; i++) {
                    buffer[i] = fillchar;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ignored) {
                    }
                }
                return new String(buffer);
            }
        };
        return service.submit(callable);
    }

    @Override
    public void displayString(String string) {
        var runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("displayString: " + string);
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {
                }
            }
        };
        service.execute(runnable);
    }

    @Override
    public void shutdown() {
        service.shutdown();
    }
}
