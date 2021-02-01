package Java_Core.Core10;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Читаем и пишем в файл: Human
*/

public class Level20Task01 {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу +
        try {
            File your_file_name = File.createTempFile("Exp\\2001.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", null); //new Level20Task01_Asset("home", 999_999.99), new Level20Task01_Asset("car", 2999.99)
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));
            System.out.println(ivanov.assets);
            System.out.println(somePerson.assets);

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Level20Task01_Asset> assets = new ArrayList<>(); // Список активов

        public Human() {
        }

        public Human(String name, Level20Task01_Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            if(name.length()>0) {
                printWriter.println(name);
            }
            if(assets.size()>0) {
                for (Level20Task01_Asset ls : assets) {
                    printWriter.println(ls.getName());
                    printWriter.println(ls.getPrice());
                }
            }
            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            name = bufferedReader.readLine();
            while (bufferedReader.ready()){
                assets.add(new Level20Task01_Asset(bufferedReader.readLine(),Double.parseDouble(bufferedReader.readLine())));
            }
            bufferedReader.close();
        }
    }
}