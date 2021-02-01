package Java_Multithreading.Multithreading5.task2909.car;

public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(1, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
