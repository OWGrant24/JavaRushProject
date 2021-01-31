package Core.Core10;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.
*/
public class Level20Task02 {
    public static void main(String[] args) {
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            Level20Task02_User userX = new Level20Task02_User();
            userX.setFirstName("Хрен");
            userX.setLastName("Хренович");
            userX.setCountry(Level20Task02_User.Country.RUSSIA);
            userX.setMale(true);
            userX.setBirthDate(new Date());
            javaRush.users.add(userX);
//            javaRush.users.add(new Level20Task02_User());
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if(javaRush.equals(loadedObject)){
                System.out.println("equals true");
            } else {
                System.out.println("equals false");
            }
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<Level20Task02_User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if(users.size()>0) {
                for (Level20Task02_User user : users) {
                    printWriter.println(user.getFirstName());
                    printWriter.println(user.getLastName());
                    printWriter.println(user.getCountry() == null ? null : user.getCountry().getDisplayName());
                    printWriter.println(user.getBirthDate() == null ? null : user.getBirthDate().getTime());
                    printWriter.println(user.isMale());
                }
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while(reader.ready()){
                Level20Task02_User user = new Level20Task02_User();
                user.setFirstName(reader.readLine());
                user.setLastName(reader.readLine());
                String country = reader.readLine();
                if(country.equals("Russia")){
                    user.setCountry(Level20Task02_User.Country.RUSSIA);
                } else if(country.equals("Ukraine")){
                    user.setCountry(Level20Task02_User.Country.UKRAINE);
                } else if (country.equals("Other")) {
                    user.setCountry(Level20Task02_User.Country.OTHER);
                } else {
                    user.setCountry(null);
                }
                String date = reader.readLine();
                if(date.equals("null") ){
                    user.setBirthDate(null);
                } else {
                    user.setBirthDate(new Date((Long.parseLong(date))));
                }
                user.setMale(Boolean.parseBoolean(reader.readLine()));
//                System.out.println(user.getFirstName());
//                System.out.println(user.getLastName());
//                System.out.println(user.getBirthDate());
//                System.out.println(user.getCountry());
//                System.out.println(user.isMale());
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
