package Core.Core9;

// Хуан Хуанович
/*
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Level19Task21 {
    public static final List<Level19Task21_Person> PEOPLE = new ArrayList<>(); // в оригинале Person

    public static void main(String[] args) {
        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(
                "E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1921.txt"))) {
            while (bufferedFileReader.ready()){
                String str = bufferedFileReader.readLine();
                // https://regexr.com
                String name = str.split("[ \\d]{0,11}$")[0];
                String date = str.split("^\\D+")[1];   // ^ начало строки
                SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
                Date date2 = formatter.parse(date);
                PEOPLE.add(new Level19Task21_Person(name,date2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
