package Collections4.Collections2_;

import java.io.IOException;
import java.io.StringReader;

/*
Привет Амиго. Ты знаешь, за нами следят, просматривают нашу переписку. Поэтому нужно шифровать трафик.
Для тебя не составит труда реализовать шифр Цезаря, напомню что это просто сдвиг вправо по алфавиту на key букв.
В методе main есть хороший пример.

Реализуй логику метода String decode(StringReader reader, int key).
Метод получает данные в закодированном виде.
Он должен вернуть дешифрованную строку, что хранится в StringReader - е.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.

Требования:
Класс Solution должен содержать метод String decode(StringReader reader, int key).
Метод decode(StringReader reader, int key) должен вернуть дешифрованную строку что хранится в StringReader - е.
Возвращаемый объект ни при каких условиях не должен быть null.
 */
public class Level32Task13 {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if(reader == null) return "";
        int i;
        StringBuilder sb = new StringBuilder();
        while((i = reader.read())!= -1){
            sb.append((char)(i+key));
        }
        return sb.toString();
    }
}
