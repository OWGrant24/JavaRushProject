package JavaRush.Java_Collections.Collections2;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/*
Представь ситуацию, ты выкачал архив с интернета,
и в момент скачивания у тебя на несколько секунд пропало соединение.
Нужно убедиться, валидный ли архив ты скачал. Для этого сверим его MD5 хеш.
Прочитать о MD5 на wiki.
Прочитать о MessageDigest.

Реализуй логику метода compareMD5, который должен получать MD5 хеш из переданного
ByteArrayOutputStream и сравнивать с эталонным MD5 переданным вторым параметром.
Метод main не участвует в тестировании.

Требования:
Класс Solution должен содержать метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5).
Метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) должен использовать MessageDigest.
Метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) должен возвращать результат сравнения вычисленного MD5 хеша для byteArrayOutputStream с переданным параметром md5.
Класс Solution должен содержать метод main.
 */
public class Level32Task11 {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bytes = messageDigest.digest(byteArrayOutputStream.toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b); // Шестнадцатиречное число
            if (hex.length() <2) hex = "0" + hex;
            sb.append(hex);
        }
        //System.out.println(sb.toString());
        return sb.toString().equals(md5);
    }
}
