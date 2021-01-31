package Core8;

import java.io.*;
import java.util.Arrays;

/*  Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
 */
public class Level18Task08 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //FileInputStream inputStream = new FileInputStream(reader.readLine());
        //FileOutputStream outputStream1 = new FileOutputStream(reader.readLine());
        //FileOutputStream outputStream2 = new FileOutputStream(reader.readLine());
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        FileOutputStream outputStream1 = new FileOutputStream("d:/data1.txt");
        FileOutputStream outputStream2 = new FileOutputStream("d:/data2.txt");
        byte[] buffer = new byte[inputStream.available()];
        int b = 0;
        while (inputStream.available() > 0) {
            int count = inputStream.read(buffer);
            System.out.println(count);

            if (count % 2 == 0) {
                b = count / 2;
            } else
                b = (count / 2) + 1 ;
             outputStream1.write(buffer,0,b);
             outputStream2.write(buffer, b, count-b);
        }
        //System.out.println(Arrays.toString(buffer));
        reader.close();
        inputStream.close();
        outputStream1.close();
        outputStream2.close();
    }

}
