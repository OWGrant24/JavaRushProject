package Java_Multithreading.Multithreading5.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();
        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

    public int calculateAverageAge() {    //13
        User userUra = new User("Юра", "Карп", 28);
        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        AtomicInteger atomicInteger = new AtomicInteger(base.intValue());
        atomicInteger.set(base.get() + age / 100);
        atomicInteger.set((int) (atomicInteger.get() * (hasWork ? 1.1 : 0.9)));
        atomicInteger.set((int) (atomicInteger.get() * (hasHouse ? 1.1 : 0.9)));
        return atomicInteger.intValue();
    }

    public String getBossName(User user) {
        return user.getBoss();
    }
}

//    public String getBossName(User user) {
//        Work work = user.getWork();
//        return work.getBoss();
//    }