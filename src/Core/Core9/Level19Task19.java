package Core9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Level19Task19 {
    public static void main(String[] args) {
        Map<String,Double> tm = new TreeMap<>();
        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(args[0]))) {
            while (bufferedFileReader.ready()){
                String bf = bufferedFileReader.readLine();
                String[] f = bf.split(" ");

                tm.merge(f[0],Double.parseDouble(f[1]),(o1,o2)->o1+o2);
            }
            for (String key : tm.keySet())
            {
                Double value = tm.get(key);
                System.out.println(key + " " + value);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
