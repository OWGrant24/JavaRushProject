package JavaRush.Java_Multithreading.Multithreading2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот
 */
public class Level22Task07 {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        List<String> list  = new ArrayList<>();

        // "Exp\\2207.txt"
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufferedFileReader = new BufferedReader(new FileReader(reader.readLine()))) {  // reader.readLine()
            while (bufferedFileReader.ready()){
                String[] strings = bufferedFileReader.readLine().split(" ");
                list.addAll(Arrays.asList(strings));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(list.size()>1){
            for(int i=0; i<list.size(); ){
                StringBuilder sb = new StringBuilder();
                String a = sb.append(list.get(i)).reverse().toString();  // Повернутое
                for(int j = i+1 ; j<list.size(); ) {
                    if(a.equals(list.get(j))){
                        Pair p = new Pair();
                        p.first = list.get(i);
                        p.second = sb.toString();
                        result.add(p);
                        list.remove(j);
                        break;
                    }
                    j++;
                }
                list.remove(i);
            }
        }
//        System.out.println(list);
//        System.out.println(result);
        for(Pair pair : result) {
            System.out.println(pair.toString());
        }
    }
    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}