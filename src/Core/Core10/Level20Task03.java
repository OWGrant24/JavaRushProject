package Core.Core10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Метод main() считывает имя файла с консоли и заполняет runtimeStorage данными из файла.
В методах save() и load() реализуй логику записи в файл и чтения из файла для карты runtimeStorage.
Файл должен быть в формате .properties. Комментарии в файле можно игнорировать.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
 */
public class Level20Task03 {
    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream));
        Properties properties = new Properties(runtimeStorage.size());
        for(Map.Entry<String, String> pair : runtimeStorage.entrySet()){
            properties.setProperty(pair.getKey(),pair.getValue());
        }
        properties.store(printWriter,"");
        printWriter.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        for(String pair : properties.stringPropertyNames()) {
            runtimeStorage.put(pair,properties.getProperty(pair));
        }
        inputStream.close();
    }

    public static void main(String[] args) {
        // "E:\\shab\\Forms\\Sandbox\\JavaProject\\Exp\\2003.properties"      reader.readLine()
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream("Exp\\2003.properties")) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // для проверки записи
        try (FileOutputStream fileOutputStream = new FileOutputStream("Exp\\2003output.properties")){
            save(fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);
    }
}
