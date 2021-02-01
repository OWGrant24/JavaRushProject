package Java_Core.Core9;

import java.io.*;
import java.util.*;

/*
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2         строка3            REMOVED строка2
строка3                            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2         строка2            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.

 */
public class Level19Task16 {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        try(BufferedReader bufferedFileReader = new BufferedReader(new FileReader("Exp\\1916_1.txt"));
            BufferedReader bufferedFileReader1 = new BufferedReader(new FileReader("Exp\\1916_2.txt"))){
//        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader bufferedFileReader = new BufferedReader(new FileReader(reader.readLine()));
//            BufferedReader bufferedFileReader1 = new BufferedReader(new FileReader(reader.readLine()))){
            while(bufferedFileReader.ready()){
                list.add(bufferedFileReader.readLine());
            }
            while(bufferedFileReader1.ready()){
                list1.add(bufferedFileReader1.readLine());
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        while (list.size() != 0 && list1.size() != 0) {
            if (list.get(0).equals(list1.get(0))) {
                lines.add(new LineItem(Type.SAME, list.get(0)));
                list.remove(0);
                list1.remove(0);
            } else if (list.get(1).equals(list1.get(0))){
                lines.add(new LineItem(Type.REMOVED, list.get(0)));
                list.remove(0);
            } else if(list.get(0).equals(list1.get(1))){
                lines.add(new LineItem(Type.ADDED, list.get(0)));
                list1.remove(0);
            }
            if (list.size() == 0 && !(list1.size()==0)) {
                lines.add(new LineItem(Type.ADDED, list1.get(0)));
                list1.remove(0);
            }
            if (list1.size() == 0 && !(list.size()==0)) {
                lines.add(new LineItem(Type.REMOVED, list.get(0)));
                list.remove(0);
            }
        }
        System.out.println("Объедененный список :");
        // Вывод финальной коллекции
        for (LineItem line : lines) {
            System.out.println(line.type + " " + line.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
