package Multithreading.Multithreading1;

import java.util.HashSet;
import java.util.Set;

/*
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами
реализации этих методов(детали уточни у своего любимого поисковика).
Обе строки first и last должны принимать участие в сравнении с помощью метода equals и
вычислении hashcode.
Метод main не участвует в тестировании.
 */
public class Level21Task04 {
    private final String first, last;

    public Level21Task04(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level21Task04 that = (Level21Task04) o;

        if (first != null ? !first.equals(that.first) : that.first != null) return false;
        return last != null ? last.equals(that.last) : that.last == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Set<Level21Task04> s = new HashSet<>();
        Level21Task04 d = new Level21Task04("Donald", "Duck");
        s.add(d);
        Level21Task04 v = new Level21Task04("Donald", "Duck");
        System.out.println(s.contains(v)); // true
        Level21Task04 mac = new Level21Task04("Donald", null);
        System.out.println(s.contains(mac)); // false
    }
}
