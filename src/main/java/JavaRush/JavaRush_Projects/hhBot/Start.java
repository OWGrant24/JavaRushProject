package JavaRush.JavaRush_Projects.hhBot;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Start {
    public static Start hhBot;

    public static void main(String[] args) {
        // Запуск интерфейса
        startGUI();

        hhBot = new Start();
        File file = new File("Exp\\data.properties");
        Properties properties = new Properties();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);
        } catch (IOException e) {
            System.out.println("Файл не найден");
            return;
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String hhtoken = properties.getProperty("hhtoken");
        String hhuid = properties.getProperty("hhuid");
        String referrer_id = properties.getProperty("referrer_id");
        String idResume = properties.getProperty("idResume");

        Data data = new Data(hhtoken,hhuid,referrer_id,idResume);
        



    }
    public static void startGUI(){
        JFrame frame = new JFrame();
        frame.setSize(600,400);
        frame.add(new GUI_Main().getMainPanel());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Приложение завершит свою работу при закрытии GUI интерфейса
        frame.setLocationRelativeTo(null); // Отображение по центру
        frame.setVisible(true);  // Делаем фрейм видимым
        frame.setTitle("Панель управления hh");
    }
}
