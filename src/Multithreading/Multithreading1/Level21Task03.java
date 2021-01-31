package Multithreading.Multithreading1;
/*
Упростить. Переменные не переименовывать, комментарии не оставлять.
Требования:
Метод calculate должен быть статическим.
Метод calculate должен возвращать значение типа boolean.
Метод calculate должен принимать четыре параметра типа boolean.
Метод calculate должен быть максимально упрощен(поведение должно остаться прежним).
 */
public class Level21Task03 {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static void main(String[] args) {

    }
}
