package Java_Multithreading.Multithreading7;

import java.util.HashSet;
import java.util.Set;


public class Level27Task08_RealEstate {
    private final Set<Level27Task08_Apartment> allApartments;
    private final Set<Level27Task08_Apartment> activeApartments;

    public Level27Task08_RealEstate() {
        allApartments = new HashSet();
        activeApartments = new HashSet();

        //add some data
        allApartments.add(new Level27Task08_Apartment(this));
        allApartments.add(new Level27Task08_Apartment(this));
        allApartments.add(new Level27Task08_Apartment(this));
        allApartments.add(new Level27Task08_Apartment(this));
        allApartments.add(new Level27Task08_Apartment(this));
        allApartments.add(new Level27Task08_Apartment(this));
    }

    public Set<Level27Task08_Apartment> getAllApartments() {
        return allApartments;
    }

    public void up(Level27Task08_Apartment apartment) {
        synchronized (this) {
            activeApartments.add(apartment);
        }
    }

    public void revalidate() {
        activeApartments.clear();
        for (Level27Task08_Apartment apartment : allApartments) {
            boolean randomValue = Math.random() * 2 % 2 == 0;
            synchronized (this) {
                apartment.revalidate(randomValue);
            }
        }
    }
}