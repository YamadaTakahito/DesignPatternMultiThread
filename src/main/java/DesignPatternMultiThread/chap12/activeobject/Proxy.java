package DesignPatternMultiThread.chap12.activeobject;

public class Proxy implements ActiveObject {
    private final SchedulerThread scheduler;
    private final Servant servant;

    public Proxy(SchedulerThread scheduler, Servant servant) {
        this.scheduler = scheduler;
        this.servant = servant;
    }

    public Result<String> makeString(int count, char fillchar) {
        var future = new FutureResult<String>();
        this.scheduler.invoke(new MakeStringRequest(servant, future, count, fillchar));
        return future;
    }

    public void displayString(String string) {
        this.scheduler.invoke(new DisplayStringRequest(servant, string));
    }
}
