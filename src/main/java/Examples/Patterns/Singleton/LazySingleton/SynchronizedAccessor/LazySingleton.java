package Examples.Patterns.Singleton.LazySingleton.SynchronizedAccessor;

public class LazySingleton {
    private static LazySingleton instance;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}