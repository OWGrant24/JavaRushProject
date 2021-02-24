package JavaRush.Java_Core.Core8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Исправить ошибки
Исправить функциональность в соответствии с требованиями.

Программа должна:
1. Переписать все байты одного файла в другой одним куском.
2. Закрывать потоки ввода-вывода.

Подсказка:
4 ошибки.
*/
public class Level18Task06 {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("d:/result.txt");

        if (inputStream.available() > 0) { // 1 read 2 >=
            byte[] buffer = new byte[inputStream.available()];
            //читаем весь файл одним куском
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        inputStream.close(); // 3  inputStream.reset();
        outputStream.close(); // 4  outputStream.flush();
    }
}
