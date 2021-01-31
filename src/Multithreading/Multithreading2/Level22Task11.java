package Multithreading.Multithreading2;

import java.io.*;

/*
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое
первого файла в кодировке UTF-8.
 */
public class Level22Task11 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedFileReader  = new BufferedReader(new InputStreamReader(new FileInputStream("Exp\\2211_1.txt"),"Windows-1251"));
//        BufferedWriter bufferedFileWriter  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Exp\\2211_2.txt"), "UTF-8"));
        BufferedReader bufferedFileReader  = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]),"Windows-1251"));
        BufferedWriter bufferedFileWriter  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), "UTF-8"));
        while (bufferedFileReader.ready()){
            String a = bufferedFileReader.readLine();
            bufferedFileWriter.write(a);
        }
        bufferedFileReader.close();
        bufferedFileWriter.close();
    }
}
