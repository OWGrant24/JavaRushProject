package JavaRush.Java_Core.Core4;

import java.net.BindException;
import java.nio.BufferUnderflowException;
import java.nio.channels.AlreadyConnectedException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
*/

public class Level14Task19 {
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {
        //1
        try {
            float i = 99 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //2
        try{
            String[] arrStr = new String[5];
               arrStr[6] = "hello";
        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new DateTimeException("Ррр"));
        exceptions.add(new ArrayStoreException());
        exceptions.add(new BindException());
        exceptions.add(new ClassCastException());
        exceptions.add(new AlreadyConnectedException());
        exceptions.add(new BufferUnderflowException());
        exceptions.add(new ClassNotFoundException());
        exceptions.add(new IllegalArgumentException());


    }
}
