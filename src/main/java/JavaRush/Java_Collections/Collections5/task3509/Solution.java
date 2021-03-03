package JavaRush.Java_Collections.Collections5.task3509;
import java.util.*;

/*
Collections & Generics
Реализуй вспомогательныe методы в классе Solution, которые должны создавать
соответствующую коллекцию и помещать туда переданные объекты.
Методы newArrayList, newHashSet параметризируй типом T.
Метод newHashMap параметризируй типами К(ключ) и V(значение). Аргументы метода newHashMap
должны принимать списки, в которых содержатся наследники типов K и V.
Возвращаемые коллекции должны быть такого же типа, что и переданные в метод объекты.

Подсказка: в методе newHashMap нужно проверить чтобы списки ключей и значений совпадали по
размерам, в противном случае кинь IllegalArgumentException.

Требования:
Метод newArrayList должен быть параметризован типом Т.
Метод newArrayList должен возвращать ArrayList, который содержит переданные в метод объекты.
Метод newHashSet должен быть параметризован типом Т.
Метод newHashSet должен возвращать HashSet, который содержит переданные в метод объекты.
Метод newHashMap должен быть параметризован типом K и V.
Метод newHashMap должен возвращать HashMap, который содержит переданные в метод ключи и значения.
Метод newHashMap должен кидать IllegalArgumentException, если списки ключей и значений не совпадают по размеру.
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static ArrayList newArrayList(Object... elements) {
        //напишите тут ваш код
        return null;
    }

    public static HashSet newHashSet(Object... elements) {
        //напишите тут ваш код
        return null;
    }

    public static HashMap newHashMap(List keys, List values) {
        //напишите тут ваш код
        return null;
    }
}
