package Java_Multithreading.Multithreading7;

public class Level27Task09_TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public int get() {
        synchronized (this) {
            while(!isValuePresent){  // Пока false - нить ожидает
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isValuePresent = false;
            System.out.println("Got: " + value);
            notify();
            return value;
        }
    }

    public void put(int value) {
        synchronized (this) {
            while(isValuePresent){  // Пока false - нить ожидает
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.value = value;
            isValuePresent = true;
            System.out.println("Put: " + value);
            notify();
        }
    }
}

