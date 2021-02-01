package Java_Multithreading.Multithreading7;

public class Level27Task08_Apartment {
    private String location;
    private final Level27Task08_RealEstate realEstate;

    public Level27Task08_Apartment(Level27Task08_RealEstate realEstate) {
        this.realEstate = realEstate;
        setLocation(String.valueOf(Math.random() * 10));
    }

    public synchronized String getLocation() {
        return location;
    }

    public synchronized void setLocation(String location) {
        this.location = location;
    }

    public void revalidate(boolean isEmpty) {
            if (isEmpty)
                realEstate.up(this);
    }
}
