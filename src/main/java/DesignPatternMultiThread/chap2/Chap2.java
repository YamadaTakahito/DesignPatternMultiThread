package DesignPatternMultiThread.chap2;

import DesignPatternMultiThread.chap2.practice.person.CrackerThread;
import DesignPatternMultiThread.chap2.practice.person.MutablePerson;

public class Chap2 {
    public static void main() {
//        Person alice = new Person("Alice", "Alaska");
//        new PrintPersonThread(alice).start();
//        new PrintPersonThread(alice).start();
//        new PrintPersonThread(alice).start();

//        List<Integer> list = new ArrayList<>();
//        var list = Collections.synchronizedList(new ArrayList<Integer>());
//        var list = new CopyOnWriteArrayList<Integer>();
//        new WriterThread(list).start();
//        new ReaderThread(list).start();

//        ComparePerformance.main();

//        var userInfo = new UserInfo("name", "address");
//        System.out.println(userInfo);
//        var info = userInfo.getInfo();
//        info.append("hohoge");
//        System.out.println(userInfo);
//
//        var startPoint = new Point(1, 1);
//        var endPoint = new Point(100, 100);
//        var line = new Line(startPoint, endPoint);
//        System.out.println(line);
//        startPoint.x = 100;
//        startPoint.y = 100;
//        System.out.println(line);

        var mutable = new MutablePerson("start", "start");
        new CrackerThread(mutable).start();
        new CrackerThread(mutable).start();
        new CrackerThread(mutable).start();
        for (int i = 0; true; i++) {
            mutable.setPerson("" + i, "" + i);
        }
    }
}
