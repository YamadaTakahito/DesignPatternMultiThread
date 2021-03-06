package DesignPatternMultiThread.chap4;

import java.io.FileWriter;
import java.io.IOException;

public class Data {
    private final String filename;
    private String content;
    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        this.content = newContent;
        this.changed = true;
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            System.out.println(Thread.currentThread().getName() + " balked");
            return;
        }
        this.doSave();
        changed = false;
    }

    private synchronized void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + this.content);

//        var oldContent = new BufferedReader(new FileReader(this.filename)).readLine();
//        if (oldContent.equals(this.content)) {
//            System.out.println("unnecessary save");
//        }

        var writer = new FileWriter(this.filename);
        writer.write(this.content);
        writer.close();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ignored) {}
    }

}
