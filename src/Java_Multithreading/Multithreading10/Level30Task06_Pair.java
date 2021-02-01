package Java_Multithreading.Multithreading10;
/*
В классе Pair реализуй метод swap, который должен для x, y менять местами их значения.
Можно использовать только операции:
1) Исключающее или.
2) Присваивание.
3) Исключающее или с присваиванием.
Не оставляй комментарии, не меняй остальной код.

Требования:
В классе Pair должен присутствовать метод swap().
В классе Pair в методе swap() используй только разрешенные операции.
Вызов метода swap() должен поменять значения полей x и y.
Не изменяй никакой код, кроме метода swap().
 */
public class Level30Task06_Pair {
    private int x;
    private int y;

    public Level30Task06_Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        System.out.println(Integer.toBinaryString(x) + " " + Integer.toBinaryString(y));
        x ^=  y;
        System.out.println(Integer.toBinaryString(x) + " Норм представление x"+ x + " " + Integer.toBinaryString(y) + " Норм представление y"+ y);
        y ^=x;
        System.out.println(Integer.toBinaryString(x) + " " + Integer.toBinaryString(y));
        x ^=  y;
    }
}
