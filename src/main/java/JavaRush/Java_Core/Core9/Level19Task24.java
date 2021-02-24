package JavaRush.Java_Core.Core9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Замена чисел
//
public class Level19Task24 {
    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }

    public static void main(String[] args) {
        // reader.readLine(); 
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufferedFileReader = new BufferedReader(new FileReader
                ("E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1924.txt"))) {
                 while (bufferedFileReader.ready()){
                    String str = bufferedFileReader.readLine();
                    String[] splitter = str.split(" ");
                    for(int i = 0; i<splitter.length; i++) {
                        if(isContain(splitter[i])) {
                            for(Integer key : map.keySet()){
                                if(splitter[i].equals(key.toString())) {
                                    String value = map.get(key);
                                    splitter[i] = value;
                                }
                            }
                        }
                    }
                    String finalstr = String.join(" ", splitter);
                     System.out.println(finalstr);
                 }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Проверка на наличие в строке цифры
    public static boolean isContain (String s) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(s);
        return m.find();
    }
}
