package Core8;

import java.io.*;

/*
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.
 */
public class Level18Task16 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("E:/Reader.txt");
        byte[] buffer = new byte[fileInputStream.available()];
        int count = 0;
        while (fileInputStream.available() > 0) {
            fileInputStream.read(buffer);

        }
        fileInputStream.close();
        for (int i=0; i<buffer.length; i++) {
            if (buffer[i] >= (int)'A' && buffer[i] <= (int)'Z')  {
                count++;
            } else if (buffer[i] >= (int)'a' && (int)buffer[i] <= (int)'z') {
                count++;
            }
        }
        System.out.println(count);

    }
}
