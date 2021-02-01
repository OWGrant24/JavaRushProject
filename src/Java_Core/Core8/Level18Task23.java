package Java_Core.Core8;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.  и т.д
 */
public class Level18Task23 {
    public static Map<String, Integer> resultMap = new HashMap<>();
    public static void main(String[] args) {
        try  (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while(true) {
                String fileName = reader.readLine();
                // "E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1823.txt"
                // "E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1922.txt"
                // "E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1924.txt"
                if(fileName.equals("exit")){
                    break;
                }
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resultMap);
    }
    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            // тело конструктора
            this.fileName = fileName;
        }
        public void run() {
            List<Integer> ls = new ArrayList<>();
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName))) {
                while (bufferedInputStream.available()>0) {
                    int f = bufferedInputStream.read();
                    ls.add(f);
                }
            } catch ( Exception e) {
                e.printStackTrace();
            }
            Map<Integer,Integer> mtemp = new TreeMap<>();
            int check=0;
            for(Integer ch : ls) {
                int count = Collections.frequency(ls, ch); //Определяет сколько раз элемент ch встречается в коллекции ls
                mtemp.put(ch,count); //
                if(count>check) {
                    check=count;
                }

            }
            for (Integer key : mtemp.keySet()) {
                Integer value = mtemp.get(key);
                if(value==check){
                    resultMap.put(fileName,key);
                }
            }
        }
    }
}
