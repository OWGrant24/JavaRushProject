package Java_Core.Core10;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуй объект в методе getOriginalObject так, чтобы в случае возникновения
исключения было выведено сообщение на экран и возвращен null.
Реализуй интерфейс Serializable где необходимо.
 */
public class Level20Task17 {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            A a = (A)objectStream.readObject();
            return a;
        } catch (Exception e) {
            return null;
        }
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
