package DesignPatternMultiThread.chap1;

public class UserThread extends Thread {
    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate, String myname, String myaddress) {
        this.gate = gate;
        this.myname = myname;
        this.myaddress = myaddress;
    }

    public void run() {
        System.out.println(this.myname + " BEGIN");
        while (true) {
            this.gate.pass(this.myname, this.myaddress);
        }
    }
}
