package JavaRush.Java_Core.Core8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
С консоли считать имя файла.
Посчитать в файле количество символов ',', количество вывести на консоль.
Закрыть потоки.

Подсказка:
нужно сравнивать с ascii-кодом символа ','.
 */
public class Level18Task07 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());  // C:/data44.txt
        int count44 = 0;
        while (inputStream.available()>0) {
            int data = inputStream.read();
            if (data == 44) {
                count44++;
            }
        }
        System.out.println(count44);
        reader.close();
        inputStream.close();
    }


}
