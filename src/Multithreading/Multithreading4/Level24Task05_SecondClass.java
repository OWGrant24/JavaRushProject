package Multithreading.Multithreading4;

public class Level24Task05_SecondClass implements Level24Task05_Action {   //second implementation
    public static String SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM = "\nSpecific action for anonymous SecondClass, param = ";

    private static String SECOND_CLASS_METHOD_STRING = "class SecondClass, method someAction";

    public Level24Task05_SecondClass() {
        Level24Task05.countActionObjects++;
    }

    protected StringBuilder sb = new StringBuilder(SECOND_CLASS_METHOD_STRING);

    public void someAction() {
        System.out.println(sb.toString());
    }
}