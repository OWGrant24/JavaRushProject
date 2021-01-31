package Core9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1
 */
public class Level19Task08 {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufFileReader = new BufferedReader(new FileReader(reader.readLine()));
            BufferedWriter bufFileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
            // E:\\Sandbox\\reacr.txt //reader.readLine()
            String data;

            while(bufFileReader.ready()) {
                data = bufFileReader.readLine();
                // Разделение строки на слова
                for(String retval :data.split(" ")){
                    int z;
                    try {
                        z=Integer.parseInt(retval);
                        ls.add(z);
                    }
                    catch (Exception e){
                        //e.printStackTrace();
                    }
                }
            }
            for (int i=0; i<ls.size(); i++) {
                bufFileWriter.write(ls.get(i).toString()+ " ");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
