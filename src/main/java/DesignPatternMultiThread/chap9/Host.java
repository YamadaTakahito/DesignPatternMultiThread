package DesignPatternMultiThread.chap9;

import java.util.concurrent.Callable;

public class Host {
//    public Data request(int count, char c) {
//        System.out.println("      request(" + count + ", " + c + ") BEGIN");
//
//        var future = new FutureData();
//
//        new Thread(() -> {
//            var realData = new RealData(count, c);
//            future.setRealData(realData);
//        }).start();
//
//        System.out.println("      request(" + count + ", " + c + ") END");
//
//        return future;
//    }

    public Data request(int count, char c) {
        System.out.println("      request(" + count + ", " + c + ") BEGIN");

        var future = new FutureData(
                new Callable<>() {
                    @Override
                    public RealData call() throws Exception {
                        return new RealData(count, c);
                    }
                }
        );

        new Thread(future).start();

        System.out.println("      request(" + count + ", " + c + ") END");

        return future;
    }
}
