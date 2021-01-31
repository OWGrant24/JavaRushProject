package Multithreading.Multithreading9.Level29Task12Exp;

public class Level29Task12_PhoneLogger extends Level29Task12_AbstractLogger {

    public Level29Task12_PhoneLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Call to director: " + message);
    }
}