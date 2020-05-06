package DesignPatternMultiThread.chap12.standardactiveobject;

public class DisplayClientThread extends Thread {
    private final ActiveObject activeObject;

    public DisplayClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                var string = Thread.currentThread().getName() + " " + i;
                activeObject.displayString(string);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ":" + e);
        }
    }
}
