package Examples.Patterns.Singleton.LazySingleton.OnDemandHolder;

/**
 * Example LazySingleton
 * from BaseJava
 * ON Demand Holder Idiom
 * + Ленивая инициализация
 * + Высокая производительность
 * - Невозможно использовать для не статических полей класса
 */
public class LazySingleton {

    private LazySingleton() {
    }

    private static class LazySingletonHolder {
        private static final LazySingleton INSTANCE = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        return LazySingletonHolder.INSTANCE;
    }
}
