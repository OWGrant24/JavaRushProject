package JavaRush.Java_Multithreading.Multithreading4;
import java.util.LinkedList;
import java.util.List;

public class Level24Task07_Util {
    //Util отлично работает со всеми классами Cat, Mouse. А ведь Mouse отличается от Cat.
    public static void printDialog(List<Level24Task07_Sayable> pets) {
        for (int i = 0; i < pets.size(); i++) {
            System.out.println(pets.get(i).say());
        }
    }

    public static List<Level24Task07_Pet> getPets() {
        List<Level24Task07_Pet> pets = new LinkedList<>();
        pets.add(new Level24Task07_Cat("Мурзик"));
        pets.add(new Level24Task07_Cat("Васька"));
        pets.add(new Level24Task07_Cat("Кошка"));
        pets.add(new Level24Task07_Mouse());
        pets.add(new Level24Task07_Cat("Томас"));
        return pets;
    }

    public static List<Level24Task07_Sayable> convertPetToSayable(List<Level24Task07_Pet> pets) {
        List<Level24Task07_Sayable> result = new LinkedList<>();
        for (Level24Task07_Pet pet : pets) {
            int i = (int) (Math.random() * 7) - 2;
            result.add(pet.toSayable(i));
        }
        return result;
    }
}
