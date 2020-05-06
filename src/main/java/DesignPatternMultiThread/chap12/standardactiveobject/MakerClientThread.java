package DesignPatternMultiThread.chap12.standardactiveobject;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class MakerClientThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillchar;

    public MakerClientThread(String name, ActiveObject activeObject, char fillchar) {
        super(name);
        this.activeObject = activeObject;
        this.fillchar = fillchar;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                var future = activeObject.makeString(i, fillchar);
                Thread.sleep(10);
                var val = future.get();
                System.out.println(Thread.currentThread().getName() + ": value = " + val);
            }
        } catch (ExecutionException | CancellationException | InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ":" + e);
        }
    }
}
