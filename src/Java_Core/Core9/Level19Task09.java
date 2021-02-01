package Java_Core.Core9;

import java.io.*;


public class Level19Task09 {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufFileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter bufFileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
                // "E:/Sandbox/9999.txt" "E:/Sandbox/0000.txt" // reader.readLine()
                String data;
                while(bufFileReader.ready()) {
                    data = bufFileReader.readLine();
                    String f = data.replace('.','!');
                    bufFileWriter.write(f);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
