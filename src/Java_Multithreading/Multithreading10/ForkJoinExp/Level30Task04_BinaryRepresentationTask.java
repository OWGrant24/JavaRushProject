package Java_Multithreading.Multithreading10.ForkJoinExp;

import java.util.concurrent.RecursiveTask;

public class Level30Task04_BinaryRepresentationTask extends RecursiveTask<String> {
    private int x;
    public Level30Task04_BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        String z = "Загляшка";
        int a = x % 2;
        int b = x / 2;

        String result = String.valueOf(a);
        if (b > 0) {
            Level30Task04_BinaryRepresentationTask brt = new Level30Task04_BinaryRepresentationTask(b);
            brt.fork();
            return brt.join() + a;
        }
        return String.valueOf(a);
    }
}

//private String binaryRepresentationMethod(int x) {
//        int a = x % 2;
//        int b = x / 2;
//        String result = String.valueOf(a);
//        if (b > 0) {
//            return binaryRepresentationMethod(b) + result;
//        }
//        return result;
//    }