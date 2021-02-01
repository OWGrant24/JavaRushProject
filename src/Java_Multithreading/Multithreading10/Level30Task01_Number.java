package Java_Multithreading.Multithreading10;

public class Level30Task01_Number {
    private Level30Task01_NumberSystem numberSystem;
    private String digit;

    public Level30Task01_Number(Level30Task01_NumberSystem numberSystem, String digit) {
        this.numberSystem = numberSystem;
        this.digit = digit;
    }

    public Level30Task01_NumberSystem getNumberSystem() {
        return numberSystem;
    }

    public String getDigit() {
        return digit;
    }

    @Override
    public String toString() {
        return "Number{" +
                "numberSystem=" + numberSystem +
                ", digit='" + digit + '\'' +
                '}';
    }
}
