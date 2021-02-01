package Java_Core.Core8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Прайсы 2
public class Level18Task28 {

    public static void main(String[] args) {
        // 666777  Товар                         999     7777
        if(args[0].equals("-u") | args[0].equals("-d")) {
            String fileName = "";
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
//                fileName = "Exp\\1828output.txt"; для FW
//                "Exp\\1827output.txt" для FR
            } catch (Exception e) {
                e.printStackTrace();
            }
            try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
                 BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(fileName))) {

                List<String> ls = new ArrayList<>();
                // Чтение из файла данных в список ls
                String n = "\r" + "\n";
                while (bufferedFileReader.ready()) {
                    String str = bufferedFileReader.readLine();
                    ls.add(str);
                }

                String id = String.format("%-8.8s", args[1]);

                if (args[0].equals("-u")) {
                    String productName = String.format("%-30.30s", args[2]);
                    String price = String.format("%-8.8s", args[3]);
                    String quantity = String.format("%-4.4s", args[4]);
                    String concatStr = id + productName + price + quantity;
                    for (int i = 0; i < ls.size(); i++) {
                        int args1 = Integer.parseInt(args[1]);
                        String lsgetre = ls.get(i).substring(0,8).replaceAll("[^0-9]", "");
//                        System.out.println(lsgetre);
                        int lsget1 = Integer.parseInt(lsgetre);
                        System.out.println(lsget1);
                        if (args1 == lsget1) {
                            ls.set(i, concatStr);
                        }
                    }
                    System.out.println(ls);
                    for(String lsStr : ls) {
                        bufferedFileWriter.write(lsStr + n);
                    }
                }
                if (args[0].equals("-d") && !(args[1] == null)) {
                    for (int i = 0; i < ls.size(); i++) {
                        if (args[1].equals(ls.get(i).substring(0, 8).replaceAll("[^0-9]", ""))) {
                            ls.remove(ls.get(i));
                        }
                    }
                    for(String lsStr : ls) {
                        bufferedFileWriter.write(lsStr + n);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
