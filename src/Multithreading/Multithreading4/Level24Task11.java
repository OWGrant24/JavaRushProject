package Multithreading.Multithreading4;
/*
Вспомним наследование
Исправить наследование во всех классах,
чтобы вывод метода main был CCBAYS.
*/

public class Level24Task11 extends Level24Task11_C  {
    private class A {
        protected String value = "A";
        public A() {
            System.out.print(value);
        }
    }

    private A a = new A()  {
        { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса

            value = "Y";
            if (super.getClass().getName().contains(".Level24Task11$")) {
                System.out.print(value);
            }
        }
    };

    public Level24Task11() {
        System.out.print("S");
    }

    public static void main(String[] args) {
        new Level24Task11();
    }
}