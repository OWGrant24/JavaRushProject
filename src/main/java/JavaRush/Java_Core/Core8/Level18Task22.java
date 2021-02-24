package JavaRush.Java_Core.Core8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id,
и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.
 */
public class Level18Task22 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedFileReader = null;
        try {
            bufferedFileReader = new BufferedReader(new FileReader("E:/Reader2.txt")); // "E:/Reader2.txt" reader.readLine()
        } catch (IOException e) {
            e.printStackTrace();
        }
        String id = null;
        while (true) {
            try {
                if (!bufferedFileReader.ready()) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                id = bufferedFileReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assert id != null;
            if(id.startsWith(24 + " ")) {
                System.out.println(id);
                break;
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedFileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
