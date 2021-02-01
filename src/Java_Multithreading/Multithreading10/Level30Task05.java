package Java_Multithreading.Multithreading10;

import java.util.ArrayList;
import java.util.List;

/*
Исправь реализацию метода checkAFlag, чтобы во всех случаях он не приводил к бросанию исключений.
Сохрани логику вывода данных.
Метод main не участвует в тестировании.
Требования:
В методе checkAFlag должна быть проверка, что d, пришедший в качестве параметра не null. Иначе вывод "Oops!".
В методе checkAFlag должна быть проверка, что d.cs не null. Иначе вывод "Oops!".
В методе checkAFlag должна быть проверка, что d.cs содержит хотя бы один элемент. Иначе вывод "Oops!".
В методе checkAFlag должна быть проверка, что d.cs.get(0).bs не null. Иначе вывод "Oops!".
В методе checkAFlag должна быть проверка, что d.cs.get(0).bs содержит хотя бы один элемент. Иначе вывод "Oops!".
В методе checkAFlag должна быть проверка, что d.cs.get(0).bs.get(0).as не null. Иначе вывод "Oops!".
В методе checkAFlag должна быть проверка, что d.cs.get(0).bs.get(0).as содержит хотя бы один элемент. Иначе вывод "Oops!".
В методе checkAFlag должна быть проверка, что d.cs.get(0).bs.get(0).as.get(0).flag равен true. Иначе вывод "Oops!".
 */
public class Level30Task05 {
    public static void main(String[] args) {
        checkAFlag(new D());
        checkAFlag(null);
    }

    public static void checkAFlag(D d) {

        if (d != null && d.cs != null &&
                d.cs.get(0).bs != null  &&
                d.cs.get(0).bs.get(0) != null &&
                d.cs.get(0).bs.get(0).as.size() > 0 &&
                d.cs.get(0).bs.get(0).as.get(0).flag) {
            System.out.println("A's flag is true");
        } else { //all other cases
            System.out.println("Oops!");
        }
    }

    static class A {
        boolean flag = true;
    }

    static class B {
        List<A> as = new ArrayList<>();

        {
            as.add(new A());
        }
    }

    static class C {
        List<B> bs = new ArrayList<>();

        {
            bs.add(new B());
        }
    }

    static class D {
        List<C> cs = new ArrayList<>();

        {
            cs.add(new C());
        }
    }
}
