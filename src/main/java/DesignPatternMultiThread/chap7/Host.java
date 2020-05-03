package DesignPatternMultiThread.chap7;

public class Host {
    final Helper helper = new Helper();

    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new Thread(() -> helper.handle(count, c)).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
