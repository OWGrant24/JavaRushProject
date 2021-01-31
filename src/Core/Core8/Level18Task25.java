package Core8;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую,
 ..., в конце - последнюю.
Закрыть потоки.
 */
public class Level18Task25 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));  //E:/Lion.txt.part1
        List<String> ls = new ArrayList<>();
        String fN;
        while(true) {
            fN = reader.readLine();
            if(fN.equals("end")){
                break;
            } else if (fN.lastIndexOf("part") != -1) {
                ls.add(fN);
            }
        }
        Collections.sort(ls);

        for (int i = 0; i<ls.size(); i++){
            BufferedInputStream bufferedInputStream  = new BufferedInputStream(new FileInputStream(ls.get(i)));

            String fileNameFinal = ls.get(0).substring(0,ls.get(0).lastIndexOf(".part"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileNameFinal,true));
            byte[] buffer = new byte[bufferedInputStream.available()];
            while (bufferedInputStream.available()>0) {
                bufferedInputStream.read(buffer);
                bufferedOutputStream.write(buffer);
            }
            bufferedInputStream.close();
            bufferedOutputStream.close();

        }
        reader.close();
    }
}
