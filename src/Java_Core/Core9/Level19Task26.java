package Core9;

import java.io.*;
// Перевертыши
public class Level19Task26 {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            // reader.readLine();
            BufferedReader bufferedFileReader = new BufferedReader(new FileReader(new File
                    ("E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1925.txt")))) {
            while (bufferedFileReader.ready()) {
                String strtemp = bufferedFileReader.readLine();
                StringBuffer stringBuffer = new StringBuffer(strtemp);
                System.out.println(stringBuffer.reverse());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
