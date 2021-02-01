package Java_Core.Core9;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// Контекстная реклама
public class Level19Task27 {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        System.setOut(consoleStream);
        String[] bytearray = byteArrayOutputStream.toString().split("\\n");
        for(int i = 0; i<bytearray.length; i++) {
            System.out.println(bytearray[i]);
            if(i % 2 != 0){
                System.out.println("JavaRush - курсы Java онлайн");
            }
        }

    }

    public static class TestString {
        public void printSomething(){
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
