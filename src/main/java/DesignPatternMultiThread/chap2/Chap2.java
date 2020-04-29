package DesignPatternMultiThread.chap2;

import java.util.concurrent.CopyOnWriteArrayList;

public class Chap2 {
    public static void main() {
//        Person alice = new Person("Alice", "Alaska");
//        new PrintPersonThread(alice).start();
//        new PrintPersonThread(alice).start();
//        new PrintPersonThread(alice).start();

//        List<Integer> list = new ArrayList<>();
//        var list = Collections.synchronizedList(new ArrayList<Integer>());
        var list = new CopyOnWriteArrayList<Integer>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
