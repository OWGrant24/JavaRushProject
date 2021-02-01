package Java_Core.Core9;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner.
 Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей,
данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.
 */
public class Level19Task04 {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements Level19Task04_PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }


        @Override
        public Level19Task04_Person read() throws IOException {
            String str = fileScanner.nextLine();
            String[] data = str.split(" ");
            String birthday = data[3] + " " + data[4] + " " + data[5];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");
            Date date = null;
            try{
                 date = simpleDateFormat.parse(birthday);
            } catch (ParseException e){
                e.printStackTrace();
            }

            Level19Task04_Person person = new Level19Task04_Person(data[1],data[2],data[0],date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
