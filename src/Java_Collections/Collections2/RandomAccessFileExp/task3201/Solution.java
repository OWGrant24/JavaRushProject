package Java_Collections.Collections2.RandomAccessFileExp.task3201;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
В метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.
Записать text в файл fileName начиная с позиции number.
Запись должна производиться поверх старых данных, содержащихся в файле.
Если файл слишком короткий, то записать в конец файла.
Используй RandomAccessFile и его методы seek и write.

Требования:
В методе main класса Solution необходимо использовать RandomAccessFile.
В методе main класса Solution программа должна записывать данные в файл при помощи метода write класса RandomAccessFile.
Запись в файл должна происходить с указанной позиции с заменой содержимого.
Если файл слишком короткий, то запись text должна происходить в конец файла.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        //по условию задачи
//        String fileName = args[0];
//        int number = Integer.parseInt(args[1]);
//        String text = args[2];

        // Создание и запись исходного файла
        String fileName = "Exp\\3201.txt";
        int number = 1;
        String text = "Amigo the best";
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            Files.createFile(path);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                bw.write("Liverpool");
            }
        }
        // Код осовной проги
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            if (number > raf.length()) {
                raf.seek(raf.length());
            } else {
                raf.seek(number);
            }
            raf.write(text.getBytes(StandardCharsets.UTF_8));

        }
        // Проверка
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready())
                System.out.println(bufferedReader.readLine());
        }

        Files.deleteIfExists(path);
    }
}
