package DesignPatternMultiThread.chap9;

public class Chap9 {
    public static void main() {
        System.out.println("main BEGIN");
        var host = new Host();
        var data1 = host.request(10, 'A');
        var data2 = host.request(-1, 'B');
        var data3 = host.request(30, 'C');

        System.out.println("main otherJob BEGIN");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        System.out.println("main otherJob END");

        try {
            System.out.println("data1 = " + data1.getContent());
            System.out.println("data2 = " + data2.getContent());
            System.out.println("data3 = " + data3.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main END");
//
//        var start = System.currentTimeMillis();
//
//        var content1 = Retriever.retrieve("https://www.yahoo.com/");
//        var content2 = Retriever.retrieve("https://www.google.com/");
//        var content3 = Retriever.retrieve("https://www.hyuki.com/");
////        var content1 = Retriever.asyncRetrieve("https://www.yahoo.com/");
////        var content2 = Retriever.asyncRetrieve("https://www.google.com/");
////        var content3 = Retriever.asyncRetrieve("https://www.hyuki.com/");
//
//        saveToFile("yahoo.html", content1);
//        saveToFile("google.html", content2);
//        saveToFile("hyuki.html", content3);
//
//        var end = System.currentTimeMillis();
//        System.out.println("Elapsed time  = " + (end - start) + "msec.");
//    }
//
//    private static void saveToFile(String filename, Content content) {
//        var bytes = content.getBytes();
//        try {
//            System.out.println(Thread.currentThread().getName() + ": Saving to " + filename);
//            var out = new FileOutputStream(filename);
//            for (int i = 0; i < bytes.length; i++) {
//                out.write(bytes[i]);
//            }
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
