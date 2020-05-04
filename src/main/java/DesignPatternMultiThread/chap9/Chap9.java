package DesignPatternMultiThread.chap9;

public class Chap9 {
    public static void main() {
        System.out.println("main BEGIN");
        var host = new Host();
        var data1 = host.request(10, 'A');
        var data2 = host.request(20, 'B');
        var data3 = host.request(30, 'C');

        System.out.println("main otherJob BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        System.out.println("main otherJob END");

        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());

        System.out.println("main END");
    }
}
