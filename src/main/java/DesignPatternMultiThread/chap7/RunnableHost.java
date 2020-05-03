package DesignPatternMultiThread.chap7;

public class RunnableHost extends Host {
    @Override
    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        helper.handle(count, c);
                    }
                }
        ).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
