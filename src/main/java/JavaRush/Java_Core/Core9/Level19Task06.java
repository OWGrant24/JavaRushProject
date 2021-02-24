package JavaRush.Java_Core.Core9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод
 */
public class Level19Task06 {
    public static void main(String[] args) throws IOException {
        List<Integer> ls = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        // "E:/Sandbox/55.txt" "E:/Sandbox/56.txt"
        int data;
        while ((data = fileReader.read()) != -1) {
            ls.add(data);
        }
        for (int i = 1; i < ls.size(); i = i + 2)
            fileWriter.write(ls.get(i));


        reader.close();

        fileReader.close();

        fileWriter.close();
    }
}

    /*
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        BufferedReader reader = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
            bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()));
            // "E:/Sandbox/55.txt" "E:/Sandbox/56.txt"
            int data;
            while ((data = bufferedReader.read()) != -1) {
                ls.add(data);
            }
            for (int i = 1; i < ls.size(); i = i + 2)
                bufferedWriter.write(ls.get(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                assert reader != null;
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bufferedReader != null;
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    */

    /*
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufferedReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
            // "E:/Sandbox/55.txt" "E:/Sandbox/56.txt"
            int data;
            while ((data = bufferedReader.read()) != -1) {
                ls.add(data);
            }
            for (int i = 1; i < ls.size(); i = i + 2)
                bufferedWriter.write(ls.get(i));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
     */

