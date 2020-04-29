package DesignPatternMultiThread.chap2.practice.person;

public class CrackerThread extends Thread {
    private final MutablePerson mutable;

    public CrackerThread(MutablePerson mutable) {
        this.mutable = mutable;
    }

    public void run() {
        while (true) {
            var immutable = new ImmutablePerson(this.mutable);
            if (!immutable.getName().equals(immutable.getAddress())) {
                System.out.println(currentThread().getName() + "*********BROKEN ***********");
            }
        }
    }
}
