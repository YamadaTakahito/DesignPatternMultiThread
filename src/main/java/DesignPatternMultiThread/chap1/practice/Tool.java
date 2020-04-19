package DesignPatternMultiThread.chap1.practice;

public class Tool {
    private final String name;

    public Tool(String name) {
        this.name = name;
    }

    public String toString() {
        return "[ " + this.name + " ]";
    }
}
