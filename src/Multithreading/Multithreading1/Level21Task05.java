package Multithreading.Multithreading1;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
Исправить ошибку. Сравнение объектов
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
Решил , через стандартную функцию идеи
*/

public class Level21Task05 {
    private final String first, last;

    public Level21Task05(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level21Task05 that = (Level21Task05) o;

        if (!Objects.equals(first, that.first)) return false;
        return Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Level21Task05> s = new HashSet<>();
        s.add(new Level21Task05("Mickey", "Mouse"));
        System.out.println(s.contains(new Level21Task05("Mickey", "Mouse")));
    }
}
