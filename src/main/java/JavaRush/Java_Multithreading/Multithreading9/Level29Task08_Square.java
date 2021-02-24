package JavaRush.Java_Multithreading.Multithreading9;

public class Level29Task08_Square implements Level29Task08_Computable<Integer, Integer> {
    @Override
    public Integer compute(Integer integer) throws InterruptedException {
        int val = integer.intValue();
        return val * val;
    }
}
