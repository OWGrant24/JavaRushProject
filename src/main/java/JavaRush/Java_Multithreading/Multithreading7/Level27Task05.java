package JavaRush.Java_Multithreading.Multithreading7;
/*
Расставь модификаторы так, чтобы при работе с этим кодом появился deadlock.
Метод main порождает deadlock, поэтому не участвует в тестировании.

Требования:
Поле field должно быть приватным.
Метод getField НЕ должен быть приватным.
Метод sout должен быть объявлен с модификатором synchronized.
Метод sout2 должен быть объявлен с модификатором synchronized.
 */
public class Level27Task05 {
    private final String field;

    public Level27Task05(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public synchronized void sout(Level27Task05 solution) {
        System.out.format("111:  %s: %s %n", this.field, solution.getField());
        solution.sout2(this);
    }

    public synchronized void sout2(Level27Task05 solution) {
        System.out.format("222:  %s: %s %n", this.field, solution.getField());
        solution.sout(this);
    }

    public static void main(String[] args) {
        final Level27Task05 solution = new Level27Task05("first");
        final Level27Task05 solution2 = new Level27Task05("second");
        new Thread(() -> solution.sout(solution2)).start();
        new Thread(() -> solution2.sout(solution)).start();

    }
}
