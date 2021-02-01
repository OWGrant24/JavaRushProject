package Java_Multithreading.Multithreading4;

import java.util.LinkedList;
import java.util.List;

public class Level24Task08_Util {
    //Util отлично работает с классами Dog, Mouse.
    public static void printDialog(List<Level24Task08_Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Level24Task08_Pet> getPets() {
        List<Level24Task08_Pet> pets = new LinkedList<>();
        pets.add(new Level24Task08_Dog("Барбос"));
        pets.add(new Level24Task08_Dog("Тузик"));
        pets.add(new Level24Task08_Dog("Бобик"));
        pets.add(new Level24Task08_Mouse());
        pets.add(new Level24Task08_Dog("Шарик"));
        return pets;
    }

    public static List<Level24Task08_Sayable> convertPetToSayable(List<Level24Task08_Pet> pets) {
        List<Level24Task08_Sayable> result = new LinkedList<>();
        for (Level24Task08_Pet pet : pets) {
            int i = (int) (Math.random() * 7) - 2;
            result.add(pet.toSayable(i));
        }
        return result;
    }
}