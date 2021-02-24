package JavaRush.Java_Multithreading.Multithreading4;

import java.lang.reflect.Method;
/*
В методе testClass класса Util: если параметр == null,
то выбросьте UnsupportedInterfaceMarkerException.
        */
public class Level24Task01_Util {
    // Пример того, как можно использовать интерфейс-маркер
    // Этот метод подходит только для классов, реализующих SelfInterfaceMarker
    public static void testClass(Level24Task01_SelfInterfaceMarker interfaceMarker) throws Level24Task01_UnsupportedInterfaceMarkerException {
        if(interfaceMarker == null){
            throw new Level24Task01_UnsupportedInterfaceMarkerException();
        } else {
            for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {
                System.out.println(method);
            }
        }
    }
}
