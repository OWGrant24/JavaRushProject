package Java_Collections.Collections2;

import java.io.PrintWriter;
import java.io.StringWriter;

/*
Реализуй логику метода getStackTrace, который в виде одной строки (одного объекта типа String)
должен возвращать весь стек-трейс переданного исключения.
Используй подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.
Метод main не участвует в тестировании.
 */
public class Level32Task03 {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter printWriter = new PrintWriter(sw);
        throwable.printStackTrace(printWriter);
        return sw.toString();
    }
}
