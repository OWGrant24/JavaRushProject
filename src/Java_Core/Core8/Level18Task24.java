package Java_Core.Core8;

import java.io.*;

/*
Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение
FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();
 */
public class Level18Task24 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream bufferedInputStream = null;
        while(true) {

            String rr = null;
            try {
                rr = reader.readLine();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(rr)); // "E:/Reader2.txt"
            } catch (FileNotFoundException e) {
                System.out.println(rr);
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }

            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
