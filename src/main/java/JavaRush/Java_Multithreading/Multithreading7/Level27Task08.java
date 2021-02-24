package JavaRush.Java_Multithreading.Multithreading7;

import java.util.Set;
/*
Синхронизированные методы, которые вызывают внутри себя синхронизированные методы других классов,
 приводят к dead-lock-у.
1. Перенесите синхронизацию с метода в синхронизированный блок, куда поместите лишь необходимые части кода.
2. Уберите избыточную синхронизацию методов.
3. В стеке вызова методов не должно быть перекрестной синхронизации,
т.е. такого synchronizedMethodAClass().synchronizedMethodBClass().synchronizedMethodAClass()

Этот способ избавления от дэдлока называется "открытые вызовы", о нем читайте в дополнительном материале к лекции.
Метод main не участвует в тестировании.

Требования:
Должна быть обеспечена возможность корректного взаимодействия объектов типа Apartment
и RealEstate без возникновения взаимных блокировок.
Метод up класса RealEstate должен быть объявлен без модификатора synchronized.
Метод revalidate класса RealEstate должен быть объявлен без модификатора synchronized.
Метод revalidate класса Apartment должен быть объявлен без модификатора synchronized.
Метод revalidate класса RealEstate должен содержать один synchronized блок.
В synchronized блоке метода revalidate класса RealEstate должен содержаться вызов метода revalidate
 на объекте apartment с параметром randomValue.
 */
public class Level27Task08 {
    public static void main(String[] args) {
        final long deadline = System.currentTimeMillis() + 5000; //waiting for 5 sec

        final Level27Task08_RealEstate realEstate = new Level27Task08_RealEstate();
        Set<Level27Task08_Apartment> allApartments = realEstate.getAllApartments();

        final Level27Task08_Apartment[] apartments = allApartments.toArray(new Level27Task08_Apartment[allApartments.size()]);

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        realEstate.revalidate();
                    }
                }
            }, "RealEstateThread" + i).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < apartments.length; i++) {
                        apartments[i].revalidate(true);
                    }
                }
            }, "ApartmentThread" + i).start();
        }

        Thread deamonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (System.currentTimeMillis() < deadline)
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ignored) {
                    }
                System.out.println("Deadlock occurred");
            }
        });
        deamonThread.setDaemon(true);
        deamonThread.start();
    }
}

