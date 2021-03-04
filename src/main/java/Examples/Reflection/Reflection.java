package Examples.Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static Examples.Color.ANSI_GREEN;
import static Examples.Color.ANSI_RESET;

// Сделано на примере из курса Продвинутая Java (alishev)
public class Reflection {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
    /*  3 способа получить доступ к обьекту класса Class
        Class a = Cat.class; // 1
        Cat obj = new Cat(); // obj - экземпляр класса Cat;
        Class b = obj.getClass(); // 2
        Class c = Class.forName("Examples.Other.Reflection.Cat"); //3
    */
        // Получение доступа к классу путём №1
        Class<? extends Cat> catClass = Cat.class;
        // Получение доступа к классу путём №2
//      Cat cat = new Cat();
//      Class<? extends Cat> catClass = cat.getClass();

        //*************************************
        // Создание нового обьекта класса
        //*************************************
        Cat catX = catClass.getDeclaredConstructor().newInstance(); // конструктор по умолчанию
        Cat catY = catClass.getDeclaredConstructor(String.class).newInstance("Фикс");

        //*******************************************
        // Получить все методы
        //*******************************************
        System.out.println(ANSI_GREEN + "Получение всех методов класса" + ANSI_RESET);
        Method[] methods = catClass.getDeclaredMethods(); // только public поля - getMethods()
        for (Method method : methods) {
            System.out.println("Имя метода - " + method.getName() +
                    "; Тип возвращаемого значения - " + method.getReturnType() +
                    "; Типы параметров, которые на вход принимаем метод - " + Arrays.toString(method.getParameterTypes()));
        }

        //*******************************************
        // Получить все поля класса
        //*******************************************
        System.out.println(ANSI_GREEN + "Получение всех полей класса" + ANSI_RESET);
        Field[] fields = catClass.getDeclaredFields(); //  только public поля - getFields()
        for (Field field : fields) {
            System.out.println("Имя переменной - " + field.getName() + "; Тип данных - " + field.getType());
        }

        //*******************************************
        // Получить определенное поле класса
        //*******************************************
        System.out.println(ANSI_GREEN + "Получение поля name класса" + ANSI_RESET);
        Field fieldNameCat = catClass.getDeclaredField("name");
        fieldNameCat.setAccessible(true);
        System.out.println("Имя catX: " + fieldNameCat.get(catX));
        //*******************************************
        // Подмена имение переменной
        //*******************************************
        fieldNameCat.set(catX, "Домашний кот");

        //*************************************
        // Получение всех аннотаций класса
        //*************************************
        Annotation[] annotations = catClass.getAnnotations();
        System.out.println(ANSI_GREEN + "Список всех аннотаций используемых в классе Cat" + ANSI_RESET);
        Arrays.stream(annotations).forEach(System.out::println);
        for (Annotation annotation : annotations) {
            System.out.println(ANSI_GREEN + "Проверка, аннотирован ли класс аннотацией @Author" + ANSI_RESET);
            if (annotation instanceof Author) { // Проверяем, что класс Cat аннотирован @Author
                System.out.println("Класс Cat аннотирован @Author");
            }
        }

        //*******************************************
        // Получение метода по сигнатуре и его запуск
        //*******************************************
        // Вызов приватного метода eat
        System.out.println(ANSI_GREEN + "Вызов метода по его сигнатуре" + ANSI_RESET);
        Method methodEatCat = catClass.getDeclaredMethod("eat");
        methodEatCat.setAccessible(true);
        methodEatCat.invoke(catX);
        methodEatCat.invoke(catY);
        // Вызов публичного метода toString
        Method methodToStringCat = catClass.getMethod("toString");
        System.out.println(methodToStringCat.invoke(catX));
    }
}