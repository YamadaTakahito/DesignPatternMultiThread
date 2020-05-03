package DesignPatternMultiThread.chap6;

public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();
//    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);
//    private final Lock readLock = lock.readLock();
//    private final Lock writeLock = lock.writeLock();

    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < this.buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        this.lock.readLock();
//        this.readLock.lock();
        try {
            return doRead();
        } finally {
            lock.readUnlock();
//            this.readLock.unlock();
        }
    }

//    public synchronized char[] read() throws InterruptedException {
//        return doRead();
//    }

    public void write(char c) throws InterruptedException {
        lock.writeLock();
//        this.writeLock.lock();
        try {
            doWrite(c);
        } finally {
            lock.writeUnlock();
//            this.writeLock.unlock();
        }
    }

//    public synchronized void write(char c) throws InterruptedException {
//        doWrite(c);
//    }

    private char[] doRead() {
        var newbuf = new char[this.buffer.length];
        for (int i = 0; i < this.buffer.length; i++) {
            newbuf[i] = this.buffer[i];
        }
        slowly();
        return newbuf;
    }

    private void doWrite(char c) {
        for (int i = 0; i < this.buffer.length; i++) {
            this.buffer[i] = c;
            slowly();
        }
    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ingored) {}
    }
}
