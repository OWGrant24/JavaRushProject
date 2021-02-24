package JavaRush.Java_Multithreading.Multithreading10;

public enum Level30Task01_NumberSystemType implements Level30Task01_NumberSystem {
    _16,
    _12,
    _10,
    _9,
    _8,
    _7,
    _6,
    _5,
    _4,
    _3,
    _2;

    @Override
    public int getNumberSystemIntValue() {
        return Integer.parseInt(this.name().substring(1));
    }
}
