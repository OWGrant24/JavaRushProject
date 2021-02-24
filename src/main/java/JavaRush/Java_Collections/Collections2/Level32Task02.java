package JavaRush.Java_Collections.Collections2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/*
Реализуй логику метода getAllDataFromInputStream.
Он должен вернуть StringWriter, содержащий все данные из переданного потока.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.
 */
public class Level32Task02 {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("Exp\\estFile3202.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if(is == null){
            return new StringWriter();
        }
        StringWriter sw = new StringWriter();
        int i;
        while((i = is.read())!= -1){
            sw.append((char) i);
        }
        return sw;
    }
}
