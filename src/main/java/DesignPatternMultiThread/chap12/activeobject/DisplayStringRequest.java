package DesignPatternMultiThread.chap12.activeobject;

public class DisplayStringRequest extends MethodRequest<Object> {
    private final String string;

    public DisplayStringRequest(Servant servant, String string) {
        super(servant, null);
        this.string = string;
    }

    public void execute() {
        this.servant.displayString(string);
    }
}
