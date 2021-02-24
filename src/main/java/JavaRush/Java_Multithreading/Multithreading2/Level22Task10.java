package JavaRush.Java_Multithreading.Multithreading2;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

возвращает массив строк
{"level22", "lesson13", "task01"}
 */
public class Level22Task10 {
    public static void main(String[] args) {
        String text = "JavaRush. The best. in World.";
        String[] textStr = getTokens(text,".");
        System.out.println(Arrays.toString(textStr));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query,delimiter);
        int count = stringTokenizer.countTokens();
        String[] strings = new String[count];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()){
            strings[i]=stringTokenizer.nextToken();
            i++;
        }
        return strings;
    }
}
