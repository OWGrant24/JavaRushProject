package Core8;

import java.io.*;
/*
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4
 */
public class Level18Task20 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dataR = reader.readLine();
        String dataF = reader.readLine();
        BufferedReader fR = null;
        BufferedWriter fW = null;
        try {
            fR = new BufferedReader(new FileReader(dataR));  //"D:/DATA6.txt"
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fW = new BufferedWriter(new FileWriter(dataF));  //"D:/DATA8.txt"
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] chars = new char[80];
        while (true){
            try {
                assert fR != null;
                if (fR.read(chars) == -1) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String s = new String(chars);
        for (String retVal : s.split(" ")) {
            long dv = Math.round(Double.parseDouble(retVal));
            try {
                assert fW != null;
                fW.write(String.valueOf(dv) + " ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert fW != null;
            fW.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
