package Core9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world",
которые встречаются в файле.
Закрыть потоки.
 */
public class Level19Task07 {
    public static void main(String[] args) {
        int check = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufFileReader = new BufferedReader(new FileReader("E:\\Sandbox\\world.txt"))) { //reader.readLine()
            // "E:\\Sandbox\\world.txt"
            String data;
            while(bufFileReader.ready()) {
                data = bufFileReader.readLine();
                // Разделение строки на слова
                for(String retval :data.split("\\W+")){
                    if (retval.equals("world")) {
                        check++;
                    }
                }
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(check);
        }

    }
}
