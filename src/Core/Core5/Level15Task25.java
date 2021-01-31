package Core.Core5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
Файл в статическом блоке
1. Инициализируй переменную Statics.FILE_NAME
полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все
строки и добавь их по отдельности в List lines.
*/

public class Level15Task25 {
    public static List<String> lines = new ArrayList<>();
    static{
        try(BufferedReader bufferedFileReader = new BufferedReader(new FileReader(Level15Task25_Statics.FILE_NAME))){
            while(bufferedFileReader.ready()){
                lines.add(bufferedFileReader.readLine());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(lines);
    }
}
