package Multithreading.Multithreading2;

public class Level22Task01_Task implements Runnable {
    private String initialString;
    private Level22Task01 solution;

    public Level22Task01_Task(Level22Task01 solution, String initialString) {
        this.solution = solution;
        this.initialString = initialString;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        String str = this.initialString;
        do {
            System.out.println(name + str);
        } while ((str = solution.getPartOfString(str, name)) != null || !str.isEmpty());
    }
}