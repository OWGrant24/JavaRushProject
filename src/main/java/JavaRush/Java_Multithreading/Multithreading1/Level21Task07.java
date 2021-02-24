package JavaRush.Java_Multithreading.Multithreading1;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
/*
Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.

Требования:
Класс Solution должен поддерживать интерфейс Cloneable.
Класс User должен поддерживать интерфейс Cloneable.
В классе User должен быть корректно реализован метод clone.
В классе Solution должен быть корректно реализован метод clone.
 */

public class Level21Task07 implements Cloneable { // Добавил implements Cloneable

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level21Task07 that = (Level21Task07) o;

        return users != null ? users.equals(that.users) : that.users == null;
    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }

    @Override
    public Object clone() {
        Level21Task07 solution = new Level21Task07();
        Map<String, User> usersClone = new LinkedHashMap<>();
        usersClone = Collections.synchronizedMap(users);
        solution.users = usersClone;
        return solution;
    }

    public static void main(String[] args) {
        Level21Task07 solution = new Level21Task07();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Level21Task07 clone = (Level21Task07) solution.clone();
        System.out.println(solution);
        System.out.println(clone);

        System.out.println("Solution users: "+ solution.users);
        System.out.println("Клонированные пользователи : " + clone.users);

    }

    protected Map<String, User> users = new LinkedHashMap<>();

    public static class User implements Cloneable { // Добавил implements Cloneable
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public Object clone()  {

            User user = new User(age,name);
            user.age = this.age;
            user.name = this.name;
            return user;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            User user = (User) o;

            if (age != user.age) return false;
            return name != null ? name.equals(user.name) : user.name == null;
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }
    }
}