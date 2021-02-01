package Core8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

/*
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44
Пример вывода:
44 83
 */
public class Level18Task05  {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c = reader.readLine(); //  C:/data.txt
        // Создаю поток чтения байт из файла
        FileInputStream inputStream = new FileInputStream(c);
        Set<Integer> ts = new TreeSet<>();
        while (inputStream.available() > 0) { //пока есть еще непрочитанные байты
            ts.add(inputStream.read());
        }
        reader.close();
        inputStream.close();
        for (Integer str: ts) {
            System.out.print(str+ " ");
        }
    }
}
