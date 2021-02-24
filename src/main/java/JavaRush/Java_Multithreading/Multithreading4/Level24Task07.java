package JavaRush.Java_Multithreading.Multithreading4;

import java.util.List;

public class Level24Task07 {
    public static void main(String[] args) {
        List<Level24Task07_Pet> pet = Level24Task07_Util.getPets();
        List<Level24Task07_Sayable> pets = Level24Task07_Util.convertPetToSayable(pet);
        Level24Task07_Util.printDialog(pets);
    }
}
