package JavaRush.Java_Core.Core8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать
в первый файл содержимое третьего файла.
Закрыть потоки.
 */
public class Level18Task18 {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine(),true); // 1 D:/data44.txt
        //FileInputStream fileInputStream = new FileInputStream(reader.readLine());    // 2   C:/data44.txt
        //FileInputStream fileInputStream2 = new FileInputStream(reader.readLine());  // 3    C:/data45.txt

        FileOutputStream fileOutputStream = new FileOutputStream("D:/data44.txt", true);
        FileInputStream fileInputStream = new FileInputStream("C:/data44.txt");    // 2
        FileInputStream fileInputStream2 = new FileInputStream("C:/data45.txt");  // 3
        byte[] buffer = new byte[fileInputStream.available()];
        while (fileInputStream.available() > 0) {
            fileInputStream.read(buffer);
            fileOutputStream.write(buffer);
        }
        byte[] buffer2 = new byte[fileInputStream2.available()];
        while (fileInputStream2.available() > 0) {
            fileInputStream2.read(buffer2);
            fileOutputStream.write(buffer2);
        }

        //reader.close();
        fileInputStream.close();
        fileInputStream2.close();
        fileOutputStream.close();
    }


}
