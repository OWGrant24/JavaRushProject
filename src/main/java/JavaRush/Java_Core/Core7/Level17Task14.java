package JavaRush.Java_Core.Core7;
/*
Реализуйте интерфейс Comparable<Beach> в классе Beach. Пляжи(Beach) будут использоваться нитями,
поэтому позаботьтесь, чтобы все методы были синхронизированы.
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число,
которое показывает что первый пляж лучше (положительное число)
или второй пляж лучше (отрицательное число), и насколько он лучше.
 */
public class Level17Task14 implements Comparable<Level17Task14> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Level17Task14(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Level17Task14 o) {
        int qualDiff = this.getQuality() - o.getQuality();
        int disDiff = (int) (this.getDistance() - o.getDistance());
        return qualDiff-disDiff;
    }

    public static void main(String[] args) {
        Level17Task14 beach1 = new Level17Task14("Черногорский", 10, 8);
        Level17Task14 beach2 = new Level17Task14("Греческий", 7, 10);
        System.out.println(beach1.compareTo(beach2));

    }
}

