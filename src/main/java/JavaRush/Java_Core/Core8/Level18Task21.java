package JavaRush.Java_Core.Core8;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361
 */
public class Level18Task21 {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("E:/Reader.txt"));  //"E:/Reader.txt" args[0]
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Character> ls = new ArrayList<>();

            try {
                assert bufferedInputStream != null;
                while (bufferedInputStream.available() > 0) {
                    ls.add((char)bufferedInputStream.read());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        Map<Character, Integer> map = new TreeMap<>();
        for (char str : ls) {
            map.put(str,null);
        }

        for (Map.Entry<Character, Integer> pair: map.entrySet())
        {
            int count = 0;
            for(int j = 0; j<ls.size(); j++)
            if(pair.getKey().equals(ls.get(j))){
                count++;
                map.put(pair.getKey(),count);
            }

        }

        for (Map.Entry<Character, Integer> pair: map.entrySet())
        {
            Character key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(key + " " + value);
        }
    }
}
