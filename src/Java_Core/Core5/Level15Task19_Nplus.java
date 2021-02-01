package Java_Core.Core5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. меньше либо равно нулю или больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
 */
public class Level15Task19_Nplus {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String str;
            while (!(str = bufferedReader.readLine()).equals("exit")){
                try{
                    if(str.matches("[0-9]+\\.[0-9]+")){
                        print(Double.parseDouble(str));
                    } else if(Integer.parseInt(str)>0 && Integer.parseInt(str)<128 ) {
                        print(Short.parseShort(str));
                    } else if(Integer.parseInt(str)<=0 || Integer.parseInt(str)>=128) {
                        print(Integer.parseInt(str));
                    } else
                        print(str);
                } catch (Exception e){
                    print(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}