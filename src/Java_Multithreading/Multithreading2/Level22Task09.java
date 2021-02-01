package Java_Multithreading.Multithreading2;
/* NOT
Составить цепочку слов
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова
совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Считай, что абсолютно все слова из исходного списка могут (и должны!) быть включены в результат (лишних слов нет).
Метод getLine должен возвращать любой правильный вариант при наличии нескольких таковых (см. пример).
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
или
Вена Амстердам Мельбурн Нью-Йорк Киев
или
Мельбурн Нью-Йорк Киев Вена Амстердам
и т.п.

*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Level22Task09 {
    public static void main(String[] args) {
        //
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader bufferedFileReader = new BufferedReader(new FileReader(
                     "Exp\\2209.txt"))) {//reader.readline()
            String[] str;
            while(bufferedFileReader.ready()){
                str = bufferedFileReader.readLine().split(" ");
                StringBuilder result = getLine(str);
                System.out.println(result.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        // Определение первого слова
        // Если первая буква не совпала с последней буквой любого слова, то это верняк первое слово!
        // Если совпала, то ищём слово в котором не совпаст
        // Если Если во всех словах совпадет то план б) берём последнее слово первым!

//        int oneWord;
//        for(int i = 0; i<words.length; i++){
//            int temp = 0;
//            for(int j = 1; j<words.length; j++){
//
//                if(!(words[0].substring(0,1).equalsIgnoreCase(words[j].substring(words[j].length()-1)))) {
//                    temp++;
//                }
//
//            } if(temp==words.length){
//                break;
//            } else if(temp <= words.length-1){
//                temp = 0;
//            }
//        }
//        // Первое слово - временное
//        for(int i = 0; i<words.length; i++){
//
//            stringBuilder.append(words[i] + " ");
//
//        }
        return stringBuilder;
    }
}
