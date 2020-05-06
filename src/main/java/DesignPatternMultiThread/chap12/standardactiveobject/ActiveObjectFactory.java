package DesignPatternMultiThread.chap12.standardactiveobject;

public class ActiveObjectFactory {
    public static ActiveObject createActiveObject() {
        return new ActiveObjectImpl();
    }
}
