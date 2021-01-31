package Core8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
 */
public class Level18Task04 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String c = reader.readLine(); //  C:/data.txt
        // Создаю поток чтения байт из файла
        FileInputStream inputStream = new FileInputStream(c);
        List<Integer> ls = new ArrayList<>();
        int count = 0;

        while (inputStream.available() > 0) { //пока есть еще непрочитанные байты
        ls.add(inputStream.read());
        }
        int save = Integer.MAX_VALUE;
        Collections.sort(ls);

        for (int i=0; i<ls.size(); i++) {
            int data = Collections.frequency(ls, ls.get(i));
            if(data<save) {
                save = data;
            }
        }
        for (int i=0; i<ls.size(); i++) {
            if (save == Collections.frequency(ls, ls.get(i))) {
                System.out.print(ls.get(i) + " ");
            }
        }
        reader.close();
        inputStream.close();
    }
}
