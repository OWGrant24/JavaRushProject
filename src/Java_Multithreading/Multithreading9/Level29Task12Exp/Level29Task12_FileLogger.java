package Java_Multithreading.Multithreading9.Level29Task12Exp;

public class Level29Task12_FileLogger extends Level29Task12_AbstractLogger {

    public Level29Task12_FileLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to file: " + message);
    }
}