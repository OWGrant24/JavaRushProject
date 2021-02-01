package Java_Core.Core8;

// Прайсы
// Crud
// Решена
import java.io.*;

public class Level18Task27 {
    public static void main(String[] args) {
        String fileName = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
 //           fileName = reader.readLine();
            fileName = "E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\1827output.txt";
        } catch (Exception e) {
            e.printStackTrace();
        }
        try( BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
            BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(fileName,true))) {
                if(args.length!=0 && args[0].equals("-c")){
                    //Поиск максимального ID
                    int idmax = 0;
                    while(bufferedFileReader.ready()){
                        String str = bufferedFileReader.readLine().substring(0,8);
                        String idmod = str.replaceAll("[^0-9]", "");
                        int id = Integer.parseInt(idmod);
                        if(id>idmax){
                            idmax=id;
                        }
                    }
                    // Добавляем новый товар
                    int idNew = ++idmax; // новый id
                    String n = "\r" + "\n";
                    // Символ возврата каретки – \r
                    //Этот символ переносит курсор в начало текущей строки, не меняя текста.
                    // Следующий выводимый текст будет перетирать существующий.
                    String id = String.format("%-8s",idNew);
                    String productName = String.format("%-30.30s", args[1]);
                    String price = String.format("%-8.8s",args[2]);
                    String quantity = String.format("%-4.4s",args[3]);
                    String strNew = id + productName + price + quantity;
                    // Запись в файл
                    bufferedFileWriter.write(n);
                    bufferedFileWriter.write(strNew);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
