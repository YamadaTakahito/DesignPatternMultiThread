package DesignPatternMultiThread.chap7.practice;

import DesignPatternMultiThread.chap7.Helper;
import DesignPatternMultiThread.chap7.Host;

public class NonThreadPerMessageHost extends Host {
    final Helper helper = new Helper();

    public void request(int count, char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        helper.handle(count, c);
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
