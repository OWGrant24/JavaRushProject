package JavaRush.Java_Collections.Collections5.task3501;

public class GenericStatic {
    public static <T> T someStaticMethod(Object genericObject) {
        System.out.println(genericObject);
        return (T) genericObject;
    }
}