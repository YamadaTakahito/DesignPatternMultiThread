package DesignPatternMultiThread.Intro.practice;

public class Bank {
    private int money;
    private String name;

    public Bank(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public void deposit(int m) {
        money += m;
    }

    public boolean withdraw(int m) {
        if (money >= m) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
            }
            money -= m;
            System.out.println("money " + money);
            check();
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    private void check() {
        if (this.money < 0) {
            System.out.println("預金残高がマイナスです money" + this.money);
        }
    }

    public int getMoney() {
        return this.money;
    }
}
