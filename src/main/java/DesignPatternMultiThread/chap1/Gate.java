package DesignPatternMultiThread.chap1;

public class Gate {
    private int count = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

//    public void pass(String name, String address) {
//        this.count++;
//        this.name = name;
//        this.address = address;
//        this.check();
//    }

    public synchronized void pass(String name, String address) {
        this.count++;
        this.name = name;
        this.address = address;
        this.check();
    }

    public String toString() {
        return "No." + this.count + ": " + "," + this.address;
    }

    private void check() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("******* BROKEN **********" + this.toString());
        }
    }
}
