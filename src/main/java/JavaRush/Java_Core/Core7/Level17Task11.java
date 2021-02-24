package JavaRush.Java_Core.Core7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion.
Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u - обновляет соответствующие данные людей с заданными id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке.
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople.
Порядок вывода данных соответствует вводу данных.
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных).
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat.

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997
*/
/* Данны для проверки
-c Миронов м 19/04/1992 Хохлов м 19/02/2001
-u 0 Миронов м 19/04/1992 1 Хохлов м 19/02/2009
-d 0 1
-i 0 1

 */
public class Level17Task11 {
    public static volatile List<Level17Task11_Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Level17Task11_Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Level17Task11_Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        if(args[0].equals("-c") | args[0].equals("-u") | args[0].equals("-d") | args[0].equals("-i") ){
            // -с - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
            // -c name1 sex1 bd1 name2 sex2 bd2 ...
            switch (args[0]){
                case "-c" :
                    synchronized (allPeople){
                        int countPeople = (args.length-1)/3; // Число людей (проходов)
                        int save = 0;
                        for(int i = 0; i<countPeople; i++) {
                            if (args[2 + save].equals("м")) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                                Date date;
                                try {
                                    date = simpleDateFormat.parse(args[3 + save]);
                                    allPeople.add(Level17Task11_Person.createMale(args[1 + save], date));
                                    System.out.println(allPeople.size() - 1); // Если он последний в списке , его id = size-1
                                    save = save + 3;
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            } else if (args[2 + save].equals("ж")) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                                Date date;
                                try {
                                    date = simpleDateFormat.parse(args[3 + save]);
                                    allPeople.add(Level17Task11_Person.createFemale(args[1 + save], date));
                                    System.out.println(allPeople.size() - 1); // Если он последний в списке , его id = size-1
                                    save = save + 3;
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    break;
                // -u - обновляет соответствующие данные людей с заданными id
                // -u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                case "-u" :
                    synchronized (allPeople) {
                        int save2 = 0;
                        int countPeople2 = (args.length - 1) / 4; // Число людей (проходов)
                        for (int i = 0; i < countPeople2; i++) {
                            int id = Integer.parseInt(args[1 + save2]);
                            if (args[3].equals("м")) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                                Date date;
                                try {
                                    date = simpleDateFormat.parse(args[4 + save2]);
                                    allPeople.set(id, Level17Task11_Person.createMale(args[2 + save2], date));
                                    save2 = save2 + 4;
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                            } else if (args[3 + save2].equals("ж")) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                                Date date;
                                try {
                                    date = simpleDateFormat.parse(args[4 + save2]);
                                    allPeople.set(id, Level17Task11_Person.createFemale(args[2 + save2], date));
                                    save2 = save2 + 4;
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    break;
                // -d - производит логическое удаление человека с id, заменяет все его данные на null
                // -d id1 id2 id3 id4 ...
                case "-d" :
                    synchronized (allPeople) {
                        int countPeople3 = (args.length - 1); // Число людей (проходов)
                        int save3 = 0;
                        for (int i = 0; i < countPeople3; i++) {
                            int id = Integer.parseInt(args[1 + save3]);
                            allPeople.get(id).setName(null);
                            allPeople.get(id).setBirthDate(null);
                            allPeople.get(id).setSex(null);
                            save3++;
                        }
                    }
                    break;
                // -i - выводит на экран информацию о всех людях с заданными id: name sex bd
                // -i id1 id2 id3 id4 ...
                case "-i" :
                    synchronized (allPeople) {
                        int countPeople4 = (args.length - 1); // Число людей (проходов)
                        int save4 = 0;
                        for (int i = 0; i < countPeople4; i++) {
                            int id = Integer.parseInt(args[1 + save4]);
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                            String bd = simpleDateFormat.format(allPeople.get(id).getBirthDate());
                            String sex = String.valueOf(allPeople.get(id).getSex()).equals("MALE") ? "м" : "ж";
                            System.out.println(allPeople.get(id).getName() + " " + sex + " " + bd);
                            save4++;
                        }
                    }
                    break;
                }
            }
//        System.out.println("Кол-во людей в базе: " + allPeople.size()); // Проверка
    }
}