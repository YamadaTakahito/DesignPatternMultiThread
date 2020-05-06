package DesignPatternMultiThread.chap12.activeobject;

public class MakeStringRequest extends MethodRequest<String> {
    private final int count;
    private final char fillchar;

    public MakeStringRequest(Servant servant, FutureResult<String> future, int count, char fillchar) {
        super(servant, future);
        this.count = count;
        this.fillchar = fillchar;
    }

    public void execute() {
        var result = this.servant.makeString(this.count, this.fillchar);
        this.future.setResult(result);
    }
}
