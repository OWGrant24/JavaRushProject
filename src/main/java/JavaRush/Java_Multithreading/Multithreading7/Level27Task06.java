package JavaRush.Java_Multithreading.Multithreading7;
/*
Используя стратегию избегания deadlock-а сделай так, чтобы он не возник.
Метод main не участвует в тестировании.
Действуй аналогично примеру из лекций.
Изменения вноси только в safeMethod.

Требования:
Метод safeMethod не должен вызывать deadlock при использовании из разных потоков.
В методе safeMethod должен содержаться вызов метода unsafeMethod, с теми же аргументами.
В методе safeMethod должен содержаться вызов метода longTimeMethod.
В методе safeMethod должно содержаться два блока synchronized.
 */
public class Level27Task06 {
    public void safeMethod(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
            longTimeMethod();
            unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Level27Task06 solution = new Level27Task06();

        new Thread(() -> solution.safeMethod(o1, o2)).start();

        new Thread(() -> solution.safeMethod(o2, o1)).start();
    }
}
