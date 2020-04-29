package DesignPatternMultiThread.chap2.practice;

public class ComparePerformance {
    private static final long CALL_COUNT = 1000000000L;

    public static void main() {
        trial("NotSync", CALL_COUNT, new NotSync());
        trial("Sync", CALL_COUNT, new Sync());
    }

    private static void trial(String msg, long count, Object obj) {
        System.out.println(msg + ": BEGIN");
        long start_time = System.currentTimeMillis();

        for (long i = 0; i < count; i++) {
            obj.toString();
        }

        System.out.println(msg + ": END");
        System.out.println("Elapsed time = " + (System.currentTimeMillis() - start_time) + "msec.");
    }
}

class NotSync {
    private final String name = "NotSync";

    public String toString() {
        return "[" + name + "]";
    }
}

class Sync {
    private final String name = "Sync";

    public synchronized String toString() {
        return "[" + name + "]";
    }
}
