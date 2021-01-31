package Core.Core10;

import java.io.*;

/*
Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправь ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution +
2) записать в него данные - writeObject +
3) сериализовать класс Solution - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Level20Task22 implements Serializable, AutoCloseable {
    private transient FileOutputStream  stream;
    private String fileName;
    public Level20Task22(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;

    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        String fileName = "Exp\\2022.txt";
        Level20Task22 solution = new Level20Task22(fileName);
        solution.writeObject("Привет от JavaRush");
        solution.close();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Exp\\2022_o.txt"));
        oos.writeObject(solution);
        oos.close();
        System.out.println(solution);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Exp\\2022_o.txt"));
        Level20Task22 solution2 = (Level20Task22) ois.readObject();
        solution2.writeObject("Привет всем");
        solution2.close();
        System.out.println(solution2);





    }
}
