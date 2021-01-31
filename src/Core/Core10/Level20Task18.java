package Core.Core10;
import java.io.*;

/*
Найти ошибки \
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найди проблему и исправь ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
В сигнатуре класса В ошибки нет :).
В методе main ошибок нет.
*/

public class Level20Task18 {
    public static class A  {

        protected String nameA = "A";
        public A() {
        }

        public A(String nameA) {
            this.nameA += nameA;
        }


    }

    public class B extends A implements Serializable {

        private String nameB;

        public B(String nameA, String nameB) { // Тут все ОК
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }
        private void writeObject(ObjectOutputStream out) throws IOException {
            out.writeObject(nameA);
            out.writeObject(nameB);
        }
        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            nameA = (String) in.readObject();
            nameB = (String) in.readObject();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException { // Тут ошибок нет
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        Level20Task18 solution = new Level20Task18();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}