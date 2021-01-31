package Core.Core7;

import java.util.*;
import java.io.*;
/*
Сделать метод joinData транзакционным, т.е. если произошел сбой,
 то данные не должны быть изменены.
1. Считать с консоли 2 имени файла.
2. Считать построчно данные из файлов. Из первого файла - в allLines,
из второго - в forRemoveLines.
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines,
то удалить из списка allLines все строки, которые есть в forRemoveLines.
4. Если условие из п.3 не выполнено, то:
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения
обработайте в методе main.
Не забудь закрыть потоки.
 */
public class Level17Task21 {
    public static List<String> allLines = new ArrayList<>(); // Arrays.asList("Привет"," Коробка", "Хлопок")
    public static List<String> forRemoveLines = new ArrayList<>(); //Arrays.asList("Привет"," Коробка","Хорома")


    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufferedFileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
            BufferedReader bufferedFileReader1 = new BufferedReader(new FileReader(bufferedReader.readLine()))) {
                while(bufferedFileReader.ready()){
                    allLines.add(bufferedFileReader.readLine());
                }
                while (bufferedFileReader1.ready()){
                    forRemoveLines.add(bufferedFileReader1.readLine());
                }
            } catch (Exception e){
            e.printStackTrace();
        }
        try{
            new Level17Task21().joinData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Проверка (перед отправкой в JR, закомментировать)
//        System.out.println(allLines);
    }

    public void joinData() throws Level17Task21_CorruptedDataException {
        boolean contain = allLines.containsAll(forRemoveLines);
        if(contain){
            allLines.removeAll(forRemoveLines); //3
        } else {
            allLines.clear(); // 4.1
            throw new Level17Task21_CorruptedDataException(); //4.2
        }

    }
}
// вместо containsAll )))
//        List<String> allLinesTemp = new ArrayList<>();
//        allLinesTemp.addAll(0,allLines);
//        List<String> forRemoveLinesTemp = new ArrayList<>();
//        forRemoveLinesTemp.addAll(0,forRemoveLines);
//        /*3. Если список allLines содержит все строки из forRemoveLines,
//            то удалить из списка allLines все строки, которые есть в forRemoveLines. */
//        for(int i = 0; i < forRemoveLinesTemp.size(); i++){
//            for(int j=0; j < allLinesTemp.size();){
//                if(forRemoveLinesTemp.get(i).equals(allLinesTemp.get(j))){
//                    forRemoveLinesTemp.remove(i);
//                } else{
//                    j++;
//                }
//            }
//        }