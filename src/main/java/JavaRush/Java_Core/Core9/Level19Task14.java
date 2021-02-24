package JavaRush.Java_Core.Core9;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Level19Task14 {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);
        List<Integer> ls = new ArrayList<>();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(result);

        while (m.find()) {
             ls.add(Integer.parseInt(m.group()));
        }
        int a=ls.get(0);
        int b=ls.get(1);
        Pattern pzn = Pattern.compile("[+*-]");
        Matcher mz = pzn.matcher(result);
        String z= "";
        while (mz.find()) {
             z = mz.group();
        }

        if (z.equalsIgnoreCase("+")) {
            int c = a+b;
            System.out.println(a +" + " + b + " = " + c );
        } else if (z.equalsIgnoreCase("-")) {
            int c = a-b;
            System.out.println(a +" - " + b + " = " + c );
        } else if (z.equalsIgnoreCase("*")) {
            int c = a * b;
            System.out.println(a + " * " + b + " = " + c);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("37 + 67 = ");
        }
    }
}
