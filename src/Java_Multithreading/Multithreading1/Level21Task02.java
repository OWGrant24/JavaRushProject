package Java_Multithreading.Multithreading1;
/*
Сравниваем модификаторы
Реализовать логику метода isModifierSet, который проверяет, содержит ли переданный
параметр allModifiers значение конкретного модификатора specificModifier.

P.S. Перед выполнением задания ознакомься с классом Modifier и реализацией методов
isPublic, isStatic и т.п.
*/

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Level21Task02 {
    public static void main(String[] args) {
        int classModifiers = Level21Task02.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
        return (allModifiers & specificModifier) > 0;
    }

    private static Method getMainMethod() {
        Method[] methods = Level21Task02.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main")) return method;
        }

        return null;
    }
}
