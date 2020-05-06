package DesignPatternMultiThread.chap12.activeobject;

public class FutureResult<T> extends Result<T> {
    private Result<T> result;
    private boolean ready = false;

    public synchronized void setResult(Result<T> result) {
        this.result = result;
        this.ready = true;
        notifyAll();
    }

    public synchronized T getResultValue() {
        while (!this.ready) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        return this.result.getResultValue();
    }
}
