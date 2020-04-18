package DesignPatternMultiThread.Intro;

public class Bank {
    private int money;
    private String name;

    public Bank(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public synchronized void deposit(int m) {
        this.money += m;
    }

    public synchronized boolean withdraw(int m) {
        if (this.money >= m) {
            this.money -= m;
            check();
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    private void check() {
        if (this.money < 0) {
            System.out.println("預金残高がマイナスです money=" + this.money);
        }
    }

}
