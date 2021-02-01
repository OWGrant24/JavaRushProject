package Java_Core.Core7;

public class Level17Task12_Table {
    private static byte tableNumber;
    private byte number = ++tableNumber;

    public Level17Task12_Order getOrder() {
        return new Level17Task12_Order(number);
    }
}
