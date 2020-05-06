package DesignPatternMultiThread.chap12;

import DesignPatternMultiThread.chap12.activeobject.ActiveObjectFactory;

public class Chap12 {
    public static void main() {
        var activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread("Alice", activeObject).start();
        new MakerClientThread("Bobby", activeObject).start();
        new DisplayClientThread("Chris", activeObject).start();
    }
}
