package DesignPatternMultiThread.chap12.activeobject;

public class Servant implements ActiveObject {
    public Result<String> makeString(int count, char fillchar) {
        var buffer = new char[count];

        for (int i = 0; i < count; i++) {
            buffer[i] = fillchar;
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
        return new RealResult<String>(new String(buffer));
    }

    public void displayString(String string) {
        try {
            System.out.println("displayString: " + string);
            Thread.sleep(10);
        } catch (InterruptedException ignored) {

        }
    }
}
