package DesignPatternMultiThread.chap7.practice;

import DesignPatternMultiThread.chap7.Helper;
import DesignPatternMultiThread.chap7.Host;

public class NonAnonymousClassHost extends Host {
    private final Helper helper = new Helper();

    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        new HelperThread(helper, count, c).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}

class HelperThread extends Thread {
    private final Helper helper;
    private final int c;
    private final char ch;

    public HelperThread(Helper helper, int c, char ch) {
        this.helper = helper;
        this.c = c;
        this.ch = ch;
    }

    @Override
    public void run() {
        helper.handle(this.c, this.ch);
    }
}
