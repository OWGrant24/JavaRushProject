package JavaRush.Java_Multithreading.Multithreading4;

public class Level24Task07_Mouse implements Level24Task07_Pet, Level24Task07_Sayable {
    @Override
    public Level24Task07_Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}