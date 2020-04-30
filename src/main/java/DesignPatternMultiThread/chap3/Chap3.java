package DesignPatternMultiThread.chap3;

public class Chap3 {
    public static void main() {
        var requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 3141592L).start();
        new ServerThread(requestQueue, "Bobby", 6535897).start();
    }
}
