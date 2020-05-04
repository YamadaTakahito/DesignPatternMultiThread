package DesignPatternMultiThread.chap9.practice;

public class Retriever {
    public static Content retrieve(String urlstr) {
        return new SynContentImpl(urlstr);
    }

    public static Content asyncRetrieve(String urlstr) {
        var future = new AsyncContentImpl(() -> {
            return new FetchingData(urlstr);
        });
        new Thread(future).start();
        return future;
    }
}
