package DesignPatternMultiThread.chap9.practice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class AsyncContentImpl extends FutureTask<FetchingData> implements Content {
    public AsyncContentImpl(Callable<FetchingData> callable) {
        super(callable);
    }

    public byte[] getBytes() {
        byte[] content = null;
        try {
            content = get().getContent();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return content;
    }
}
