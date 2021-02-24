package JavaRush.Java_Multithreading.Multithreading4;
/*
обратите внимание, как именно Mouse отличается от Dog
Этот класс - привычный для вас.  */
public class Level24Task08_Mouse implements Level24Task08_Pet, Level24Task08_Sayable {
    @Override
    public Level24Task08_Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}
