package Core.Core7;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Level17Task12_Manager {
    private static Level17Task12_Manager ourInstance = new Level17Task12_Manager();

    private final List<Level17Task12_Table> restaurantTables = new ArrayList<>(10);
    private int currentIndex = 0;

    private final Queue<Level17Task12_Order> orderQueue = new ConcurrentLinkedQueue<>();        // очередь с заказами
    private final Queue<Level17Task12_Dishes> dishesQueue = new ConcurrentLinkedQueue<>();     // очередь с готовыми блюдами

    public synchronized static Level17Task12_Manager getInstance() {
        return ourInstance;
    }

    private Level17Task12_Manager() {               // создаем 10 столов
        for (int i = 0; i < 10; i++) {
            restaurantTables.add(new Level17Task12_Table());
        }
    }

    public synchronized Level17Task12_Table getNextTable() {           // официант ходит по кругу от 1 стола к 10
        Level17Task12_Table table = restaurantTables.get(currentIndex);
        currentIndex = (currentIndex + 1) % 10;
        return table;
    }

    public Queue<Level17Task12_Order> getOrderQueue() {
        return orderQueue;
    }

    public Queue<Level17Task12_Dishes> getDishesQueue() {
        return dishesQueue;
    }
}