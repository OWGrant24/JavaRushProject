package Core.Core8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так,
чтобы получилось объединение файлов.
Закрыть потоки.
 */
public class Level18Task19 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = reader.readLine(); //"D:/data1.txt"
        String fileTwo = reader.readLine(); //"D:/data2.txt"
        FileInputStream fileInputStream1 = new FileInputStream(fileOne); //1
        FileInputStream fileInputStream2 = new FileInputStream(fileTwo);  //2

        List<Integer> ls = new ArrayList<>();
        while(fileInputStream2.available() > 0){
            ls.add(fileInputStream2.read());
        }

        while(fileInputStream1.available() > 0){
            ls.add(fileInputStream1.read());
        }
        FileOutputStream fileOutputStream = new FileOutputStream(fileOne); //1

        for (Integer l : ls) {
            fileOutputStream.write(l);
        }

        reader.close();
        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();

    }
}
