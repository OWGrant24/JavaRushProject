package Core.Core5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Для решения этой задачи тебе нужно:
Считать с консоли URL-ссылку.
Вывести на экран список всех параметров через пробел
(Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности,
в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert():
alert(double value) - для чисел (дробные числа разделяются точкой);
alert(String value) - для строк.
Обрати внимание на то, что метод alert() необходимо вызывать после
вывода списка всех параметров на экран.
Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14
 */
public class Level15Task27 {
    public static void main(String[] args) {
        //add your code here
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String url = reader.readLine();
//            String url = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
//            String url = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
            Map<String,String> map = new LinkedHashMap<>();
            String urlParam = url.substring(url.indexOf("?")+1);
            String[] str = urlParam.split("&");

            for(String arr : str){
                if(arr.matches("[^&=]+=[^&=]+")) {
                    String key = arr.split("=")[0];
                    String value = arr.split("=")[1];
                    map.put(key,value);
                } else {
                    map.put(arr,null);
                }
            }

            // Выводим все ключи:
            int check = 0;
            for(Map.Entry<String,String> pair : map.entrySet()) {
                check++;
                if (check != map.size()) {
                    System.out.print(pair.getKey() + " ");
                } else {
                    System.out.println(pair.getKey());
                }
            }
            // Проверка на obj
            for(Map.Entry<String,String> pair : map.entrySet()){
                String key = pair.getKey();
                if(key.equals("obj")) {
                    String value = pair.getValue();
                    try{
                        alert(Double.parseDouble(value));
                    } catch (Exception e) {
                        alert(value);
                    }
                }
            }
//            System.out.println(Arrays.toString(str));
//            System.out.println(map);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

}
