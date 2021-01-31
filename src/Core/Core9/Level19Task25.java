package Core9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Level19Task25 { // Длинные слова
    public static void main(String[] args) {
        try(BufferedReader bufferedFileReader = new BufferedReader(new FileReader
                ("E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1925.txt"));
            BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter
                ("E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1925output.txt"))){
            List<String> ls = new ArrayList<>();
            while (bufferedFileReader.ready()){
                String strtemp = bufferedFileReader.readLine();
                String[] words = strtemp.split(" ");
                for (String lw : words) {
                    if(lw.length()>6){
                        ls.add(lw);
                    }

                }
            }
            for(int i=0; i<ls.size(); i++){
                bufferedFileWriter.write(ls.get(i));
                if(i!=ls.size()-1){
                    bufferedFileWriter.write(",");
                }

            }
        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }
}
