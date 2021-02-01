package Java_Core.Core8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.
 */
public class Level18Task10 {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            FileInputStream inputStream = new FileInputStream(reader.readLine());
            if (inputStream.available() < 1000) {
                reader.close();
                inputStream.close();
                throw new DownloadException();

            }
        }



    }
    public static class DownloadException extends Exception {

    }
}
