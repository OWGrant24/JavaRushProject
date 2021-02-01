package Java_Multithreading.Multithreading4;

import java.util.List;

public class Level24Task08 {
    public static void main(String[] args) {
        List<Level24Task08_Pet> pet = Level24Task08_Util.getPets();
        List<Level24Task08_Sayable> pets = Level24Task08_Util.convertPetToSayable(pet);
        Level24Task08_Util.printDialog(pets);
    }
}
