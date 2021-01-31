package Multithreading.Multithreading4;
import java.util.LinkedList;
import java.util.List;

/*   ЗАНЕСТИ В конспект!!!!!!
Рефакторинг, анонимные классы
Сделайте так, чтобы метод getIterator возвращал анонимный класс.
Перенесите логику LocalIterator в анонимный класс.
Меняйте только тело метода getIterator.
*/

public class Level24Task10 {
    public static List<Level24Task10_Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Level24Task10_Iterator getIterator(final String name) {
            return new Level24Task10_Iterator() {
                {
                    countItems++;
                    System.out.println(name + " item " + countItems);
                }

                public Level24Task10_Iterator next() {
                    return getIterator(name);
                }
            };
        }

    public static void main(String[] args) {
        Level24Task10 solution = new Level24Task10();

        Level24Task10_Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}