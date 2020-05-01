package DesignPatternMultiThread.chap3;

public class Chap3 {
    public static void main() {
//        var requestQueue = new RequestQueue();
//        new ClientThread(requestQueue, "Alice", 3141592L).start();
//        new ServerThread(requestQueue, "Bobby", 6535897).start();

//        var requestQueue1 = new RequestQueue();
//        var requestQueue2 = new RequestQueue();
//        requestQueue1.putRequest(new Request("hey"));
//        new TalkThread(requestQueue1, requestQueue2, "Alice").start();
//        new TalkThread(requestQueue2, requestQueue1, "Bobby").start();

        var requestQueue = new RequestQueue();
        var alice = new ClientThread(requestQueue, "Alice", 314159L);
        var bobby = new ServerThread(requestQueue, "Bobby", 265358L);
        alice.start();
        bobby.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {}

        System.out.println("***** calling interrupt *****");
        alice.interrupt();
        bobby.interrupt();
    }
}
