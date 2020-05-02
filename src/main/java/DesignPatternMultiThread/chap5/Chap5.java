package DesignPatternMultiThread.chap5;

public class Chap5 {
    public static void main() {
        var table = new Table(3);
        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 92653).start();
        new MakerThread("MakerThread-3", table, 58979).start();
        new EaterThread("EaterThread-1", table, 32384).start();
        new EaterThread("EaterThread-2", table, 62643).start();
        new EaterThread("EaterThread-3", table, 38327).start();

//        var exchanger = new Exchanger<char[]>();
//        var buffer1 = new char[1];
//        var buffer2 = new char[10];
//        new ProducerThread(exchanger, buffer1, 314159).start();
//        new ConsumerThread(exchanger, buffer2, 265358).start();
    }
}
