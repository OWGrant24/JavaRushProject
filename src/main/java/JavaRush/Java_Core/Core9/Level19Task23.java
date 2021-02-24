package JavaRush.Java_Core.Core9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 // Слова с цифрами
// Исправить входные файлы на параметры args[0]; args[1];
public class Level19Task23 {

    public static void main(String[] args) {
        try(BufferedReader bufferedFileReader = new BufferedReader(new FileReader
                ("E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1923.txt"));
        BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter
                ("E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1923output.txt"))) {
            List<String> ls = new ArrayList<>();
            while (bufferedFileReader.ready()){
                String strtemp = bufferedFileReader.readLine();
                String[] words = strtemp.split(" ");
                for (String lw : words) {
                    ls.add(lw);
                }
            }
            for(String re : ls){
                if(isContain(re)) {
                    bufferedFileWriter.write(re+ " ");
                }
            }
//            System.out.println(ls);
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
