package Core.Core7;

import java.util.HashMap;
import java.util.Map;

public class Level17Task15_DrugsController {
    public static Map<Core.Core7.Level17Task15_Drug, Integer> allDrugs = new HashMap<Core.Core7.Level17Task15_Drug, Integer>();
    // <Лекарство, Количество>

    static {
        Core.Core7.Level17Task15_Drug panadol = new Core.Core7.Level17Task15_Drug();
        panadol.setName("Панадол");
        allDrugs.put(panadol, 5);

        Core.Core7.Level17Task15_Drug analgin = new Core.Core7.Level17Task15_Drug();
        analgin.setName("Анальгин");
        allDrugs.put(analgin, 18);

        Core.Core7.Level17Task15_Drug placebo = new Core.Core7.Level17Task15_Drug();
        placebo.setName("Плацебо");
        allDrugs.put(placebo, 1);
    }

    public synchronized void buy(Core.Core7.Level17Task15_Drug drug, int count) {
        String name = Thread.currentThread().getName();
        if (!allDrugs.containsKey(drug)) {
            System.out.println("Нет в наличии");
        }
        Integer currentCount = allDrugs.get(drug);
        if (currentCount < count) {
            System.out.println(String.format("%s хочет %s %d шт. В наличии - %d", name, drug.getName(), count, currentCount));
        } else {
            allDrugs.put(drug, (currentCount - count));
            System.out.println(String.format("%s купил(а) %s %d шт. Осталось - %d", name, drug.getName(), count, (currentCount - count)));
        }
    }

    public synchronized void sell(Core.Core7.Level17Task15_Drug drug, int count) {
        System.out.println(Thread.currentThread().getName() + " Закупка " + drug.getName() + " " + count);
        if (!allDrugs.containsKey(drug)) {
            allDrugs.put(drug, 0);
        }
        Integer currentCount = allDrugs.get(drug);
        allDrugs.put(drug, (currentCount + count));
    }
}
