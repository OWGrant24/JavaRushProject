package JavaRush.Java_Core.Core8;

import java.io.FileInputStream;
import java.io.IOException;

/*
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.
 */
public class Level18Task17 {
    public static void main(String[] args) throws IOException {
        int probel = 0;

        //FileInputStream fileInputStream = new FileInputStream(args[0]);
        FileInputStream fileInputStream = new FileInputStream("E:/Reader.txt");
        byte[] bf = new byte[fileInputStream.available()];
        while (fileInputStream.available() > 0) {
            fileInputStream.read(bf);
        }
        fileInputStream.close();
        int allSymbols = bf.length;
        for(int i=0; i<bf.length; i++) {
            if(bf[i] == ' ') {
                probel++;
            }
        }

        double res = (double)probel/allSymbols*100;
        System.out.println(probel);
        System.out.println(allSymbols);
        System.out.printf("%.2f",res);
    }
}
