package DesignPatternMultiThread.chap9;

//public class FutureData implements Data {
//    private RealData realData = null;
//    private boolean ready = false;
//
//    public synchronized void setRealData(RealData realdata) {
//        if (ready) {
//            return;
//        }
//        this.realData = realdata;
//        this.ready = true;
//        notifyAll();
//    }
//
//    public synchronized String getContent() {
//        while (!ready) {
//            try {
//                wait();
//            } catch (InterruptedException ignored) {
//
//            }
//        }
//
//        return this.realData.getContent();
//    }
//}

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureData extends FutureTask<RealData> implements Data {
    public FutureData(Callable<RealData> callable) {
        super(callable);
    }

    public String getContent() throws ExecutionException {
        String string = null;
        try {
            string = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return string;
    }
}
