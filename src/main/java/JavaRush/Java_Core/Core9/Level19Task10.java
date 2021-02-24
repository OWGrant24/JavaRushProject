package JavaRush.Java_Core.Core9;


import java.io.*;

public class Level19Task10 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufFileReader = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter bufFileWriter = new BufferedWriter(new FileWriter(reader.readLine()))) {
            // "E:/Sandbox/9999.txt" "E:/Sandbox/0000.txt" // reader.readLine()
            String data;
            while(bufFileReader.ready()) {
                data = bufFileReader.readLine();
                System.out.println(data);
                String f = data.replaceAll("\\p{Punct}","");
                System.out.println(f);
                bufFileWriter.write(f);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
