package JavaRush.Java_Core.Core8;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.
 */
public class Level18Task09 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        //FileInputStream inputStream = new FileInputStream("c:/data.txt");
        //FileOutputStream outputStream = new FileOutputStream("d:/result.txt");
        ArrayList<Integer> aL = new ArrayList<>();
        while (inputStream.available() > 0) {
            aL.add(inputStream.read());
        }
        System.out.println(aL);
        Collections.reverse(aL);
        System.out.println(aL);
        for (int i=0; i<aL.size();i++) {
            outputStream.write(aL.get(i));
        }

        reader.close();
        inputStream.close();
        outputStream.close();
    }

}
