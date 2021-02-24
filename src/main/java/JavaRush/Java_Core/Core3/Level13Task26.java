package JavaRush.Java_Core.Core3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
 */
public class Level13Task26 {
    public static void main(String[] args)  {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // C:/data45.txt
        List<Integer> ls = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))) {
            while (bufferedReader.ready()) {
                ls.add(Integer.parseInt(bufferedReader.readLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(ls);
        for (int i=0; i<ls.size(); i++) {
            if(ls.get(i) %2 !=0) {
               ls.remove(ls.get(i));
               i--;
            }
         }
        for (Integer str : ls) {
           System.out.println(str);
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
