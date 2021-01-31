package Core.Core7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CrUD - Create, Update, Delete.

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке.
Все люди должны храниться в allPeople.
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990
 */
public class Level17Task10 {
    public static List<Level17Task10_Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Level17Task10_Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Level17Task10_Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if(args[0].equals("-c") | args[0].equals("-u") | args[0].equals("-d") | args[0].equals("-i") ){
            if(args[0].equals("-c")) {
                if(args[2].equals("м")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date date = null;
                    try {
                        date = simpleDateFormat.parse(args[3]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    allPeople.add(Level17Task10_Person.createMale(args[1],date));
                    System.out.println(allPeople.size()-1); // Если он последний в списке , его id = size-1

                }
                else if(args[2].equals("ж")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date date = null;
                    try {
                        date = simpleDateFormat.parse(args[3]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    allPeople.add(Level17Task10_Person.createFemale(args[1],date));
                    System.out.println(allPeople.size()-1); // Если он последний в списке , его id = size-1
                }

            }
            if(args[0].equals("-u") && (!(args[1]==null))) {
                int id = Integer.parseInt(args[1]);
                if(args[3].equals("м")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date date = null;
                    try {
                        date = simpleDateFormat.parse(args[4]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    allPeople.set(id,Level17Task10_Person.createMale(args[2],date));
                }
                if(args[3].equals("ж")){
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    Date date = null;
                    try {
                        date = simpleDateFormat.parse(args[4]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    allPeople.set(id,Level17Task10_Person.createFemale(args[2],date));
                }
            }
            // -d - производит логическое удаление человека с id, заменяет все его данные на null
            if(args[0].equals("-d") && (!(args[1]==null))) { //  данные
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setBirthDate(null);
                allPeople.get(id).setSex(null);
            }
            // -i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
            if(args[0].equals("-i") && (!(args[1]==null))) { // Вывод сделать даты
                int id = Integer.parseInt(args[1]);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                String bd = simpleDateFormat.format(allPeople.get(id).getBirthDate());
                String sex = String.valueOf(allPeople.get(id).getSex()).equals("MALE") ? "м" : "ж";
                System.out.println(allPeople.get(id).getName() + " " + sex + " "+ bd);
            }
        }
        System.out.println(allPeople);  // проверка
    }
}