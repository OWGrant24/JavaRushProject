package JavaRush.Java_Core.Core9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
// Ищём нужные строки
public class Level19Task22 {

        public static List<String> words = new ArrayList<>();
        static {
            words.add("файл");
            words.add("вид");
            words.add("В");
        }

    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader bufferedFileReader = new BufferedReader(new FileReader(new File
                ("E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1922.txt")))) {
            String a = "";
            while (bufferedFileReader.ready()){
                List<String> tempWords = new ArrayList<>();
                a = bufferedFileReader.readLine();
                for (String retval : a.split(" ")){
                    tempWords.add(retval);
                }
                int check = 0;
                for (String wr : words){
                    for(String twr : tempWords){
                        if(wr.equals(twr)){
                            check++;
                        }
                    }
                }
                if(check == 2){
                    for(String str : tempWords){
                        System.out.print(str+" ");
                    }
                    System.out.println("");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
