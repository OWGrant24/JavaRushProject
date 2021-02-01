package Java_Collections.Collections1;
/*
Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
Нужно обеспечить корректное чтение свойств.
При возникновении ошибок должен возвращаться пустой объект.
Метод main не участвует в тестировании.

Подсказка: возможно тебе понадобится File.separator.
 */
import java.io.FileInputStream;
import java.util.Properties;

public class Level31Task09 {
    public static void main(String[] args) {
        Level31Task09 solution = new Level31Task09();
//        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
//        properties.list(System.out);
//
//        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
//        properties.list(System.out);
//
//        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
//        properties.list(System.out);

        Properties properties = solution.getProperties("Exp/2003.properties");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try {
            if(fileName.endsWith(".xml")){
                properties.loadFromXML(new FileInputStream(fileName));
            } else {
                properties.load(new FileInputStream(fileName));
            }

        } catch (Exception ignored){
        }

        return properties;
    }
}
