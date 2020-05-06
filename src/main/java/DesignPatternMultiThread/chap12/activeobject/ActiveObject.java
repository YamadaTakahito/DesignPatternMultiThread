package DesignPatternMultiThread.chap12.activeobject;

public interface ActiveObject {
    public abstract Result<String> makeString(int count, char fillchar);

    public abstract void displayString(String string);
}

