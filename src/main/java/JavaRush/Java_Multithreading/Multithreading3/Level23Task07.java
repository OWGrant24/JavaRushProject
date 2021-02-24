package JavaRush.Java_Multithreading.Multithreading3;
/*
Как выбрать нужное?
В методе main присвой объекту Object obj 
экземпляр класса TEST.
Не изменяй ничего кроме метода main.
*/
public class Level23Task07 {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {

        obj = new Level23Task07.TEST();
        System.out.println(obj);
    }
}