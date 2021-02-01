package Java_Multithreading.Multithreading9.Level29Task12Exp;

public interface Level29Task12_Logger {
    void inform(String message, int level);

    void setNext(Level29Task12_Logger next);

    void info(String message);
}
