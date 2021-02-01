package Java_Multithreading.Multithreading9.Level29Task12Exp;

public abstract class Level29Task12_AbstractLogger implements Level29Task12_Logger {
    int level;
    Level29Task12_Logger next;

    public Level29Task12_AbstractLogger(int level) {
        this.level = level;
    }

    @Override
    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }

    public void setNext(Level29Task12_Logger next) {
        this.next = next;
    }

}
