package Collections4.Collections2.RandomAccessFileExp;

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

Считать текст с файла начиная с позиции number, длиной такой же как и длина переданного текста в третьем параметре.
Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
Используй RandomAccessFile и его методы seek(long pos), read(byte[] b, int off, int len), write(byte[] b).
Используй один из конструкторов класса String для конвертации считанной строчки в текст.
 */
public class Level32Task10 {
    public static void main(String[] args) throws IOException {
        //по условию задачи
//        String fileName = args[0];
//        int number = Integer.parseInt(args[1]);
//        String text = args[2];

        // Создание и запись исходного файла
        String fileName = "Exp\\3210.txt";
        int number = 6;
        String text = "the best";
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            Files.createFile(path);
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
                bw.write("Amigo the best");
            }
        }
        // Код осовной проги
        byte[] bytes = new byte[text.length()];
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            raf.seek(number);
            raf.read(bytes, 0, text.length());

            String textReadFile = new String(bytes);
            raf.seek(raf.length());
            if (text.equals(textReadFile)) {
                raf.write("true".getBytes(StandardCharsets.UTF_8));
                System.out.println("true");
            } else {
                raf.write("false".getBytes(StandardCharsets.UTF_8));
                System.out.println("false");
            }
            System.out.println(text.length());
            System.out.println(textReadFile.length());
        }
        // Проверка
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready())
                System.out.println("Записано в файл : " + bufferedReader.readLine());
        }

        Files.deleteIfExists(path); // Удаление файла
    }
}
