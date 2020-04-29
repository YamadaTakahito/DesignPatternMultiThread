package DesignPatternMultiThread.chap2.practice;

public final class UserInfo {
    private final StringBuffer info;

    public UserInfo(String name, String address) {
        this.info = new StringBuffer(name + address);
    }

    public StringBuffer getInfo() {
        return this.info;
    }

    public String toString() {
        return "[ UserInfo: " + info + "]";
    }
}
