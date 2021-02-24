package JavaRush.Java_Core.Core8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*   Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.
 */
public class Level18Task02 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c = reader.readLine(); //  C:/data.txt
        // Создаю поток чтения байт из файла
        FileInputStream inputStream = new FileInputStream(c);
        long minByte = inputStream.read();
        while (inputStream.available() > 0) { //пока есть еще непрочитанные байты
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            if (data < minByte ) {
                minByte = data;
            }

        }
        reader.close();
        inputStream.close();
        System.out.println(minByte);
    }
}
