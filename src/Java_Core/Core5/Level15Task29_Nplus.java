package Java_Core.Core5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. В отдельных файлах создать классы Plane и Helicopter, реализующие интерфейс CanFly.  +
2. Класс Plane должен иметь конструктор с параметром int - количество перевозимых пассажиров. +
3. В статическом методе reset класса Solution:
3.1. Считать с консоли параметр типа String. +
3.2. Если параметр равен "helicopter", то статическому объекту CanFly result
присвоить объект класса Helicopter. +
3.3. Если параметр равен "plane", то считать второй параметр типа int(количество пассажиров),
статическому объекту CanFly result присвоить объект класса Plane. +
4. В статическом блоке инициализировать CanFly result вызвав метод reset. +
5. Закрыть поток ввода методом close(). +
 */
public class Level15Task29_Nplus {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static  Level15Task29_CanFly result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        if(str.equals("helicopter")){
            result = new Level15Task29_Helicopter();
        } else if(str.equals("plane")){
            result = new Level15Task29_Plane(Integer.parseInt(reader.readLine()));
        }
        reader.close();
    }
}
