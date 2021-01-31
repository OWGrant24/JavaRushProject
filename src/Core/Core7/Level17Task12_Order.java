package Core.Core7;

public class Level17Task12_Order {
    private long time;
    private byte tableNumber;

    public Level17Task12_Order(byte tableNumber) {
        time = (long) (Math.random() * 200);
        this.tableNumber = tableNumber;
    }

    public long getTime() {
        return time;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}
