package DesignPatternMultiThread.chap1.practice;

public class Pair {
    private final Tool lefthand;
    private final Tool righthand;

    public Pair(Tool lefthand, Tool righthand) {
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    public String toString() {
        return "[ " + this.lefthand + " and " + this.righthand + " ]";
    }
}
