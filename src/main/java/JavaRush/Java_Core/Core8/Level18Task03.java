package JavaRush.Java_Core.Core8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
 */
public class Level18Task03 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String c = reader.readLine(); //  C:/data.txt
        // Создаю поток чтения байт из файла
        BufferedReader bFR = new BufferedReader(new FileReader("C:/data.txt"));
        char[] chars = new char[70];
        List<Integer> ls = new ArrayList<>();
        while (bFR.read(chars) == -1);

        for (char S : chars ) {
            ls.add(Character.getNumericValue(chars[S]));
        }
        int save = 0;
        Collections.sort(ls);

        for (int i=0; i<ls.size(); i++) {
            int data = Collections.frequency(ls, ls.get(i));
            if(data>save) {
                save = data;
            }
        }
        for (int i=0; i<ls.size(); i++) {
            if (save == Collections.frequency(ls, ls.get(i)) && !ls.get(i).equals(ls.get(i-1)) ) {

                System.out.print(ls.get(i) + " ");
            }
        }
        reader.close();
        bFR.close();
    }
}
