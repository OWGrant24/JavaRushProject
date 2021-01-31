package Core.Core7;

public class Level17Task12_Cook implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) {
            try {
                synchronized (this) {
                    needToWait = !needToCookOrders();
                    if (!needToWait) {
                        cook();
                    }
                }
                if (continueWorking && needToWait) {
                    System.out.println("Повар отдыхает");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Level17Task12_Manager.getInstance().getOrderQueue().isEmpty();
    }

    private void cook() throws InterruptedException {
        Level17Task12_Manager manager = Level17Task12_Manager.getInstance();
        Level17Task12_Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
        System.out.println(String.format("Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber()));
        Thread.sleep(order.getTime());     // готовим блюдо
        Level17Task12_Dishes dishes = new Level17Task12_Dishes(order.getTableNumber());       //  это готовое блюдо
        manager.getDishesQueue().add(dishes);
        System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));
    }
}
