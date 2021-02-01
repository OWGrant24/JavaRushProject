package Java_Multithreading.Multithreading7;
import java.io.*;
/*
Избавьтесь от меток в методе isSubstringPresent сохранив логику.
Метод возвращает true, в случае если строка substring является подстрокой строки string, иначе false.
В коде должны отсутствовать операторы break и continue.

Требования:
Метод isSubstringPresent должен возвращать true,
если строка substring является подстрокой строки string.
Метод isSubstringPresent должен возвращать false,
если строка substring НЕ является подстрокой строки string.
В методе isSubstringPresent должны отсутствовать операторы break.
В методе isSubstringPresent должны отсутствовать операторы continue.
 */
public class Level27Task01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String substring = reader.readLine();

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

//    static boolean isSubstringPresent(String substring, String string) {
//        int max = string.length() - substring.length(); //1
//        int check = 0;
//        for(int i = 0; i<= max; i++) {
//            int j = i;
//            int k = 0;
//            if (string.charAt(j) == substring.charAt(k)) {
//                System.out.println(string.charAt(j) + " = " + string.charAt(k));
//                check++;
//                System.out.println("check = " + check);
//                k++;
//            } else {
//                check = 0;
//            }
//
//            if(check==substring.length()){
//                return true;
//            }
//        }
//        return false;
//    }

    static boolean isSubstringPresent(String substring, String string) {
        return string.contains(substring);
    }
}
