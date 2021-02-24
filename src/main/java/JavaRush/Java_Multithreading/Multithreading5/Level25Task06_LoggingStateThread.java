package JavaRush.Java_Multithreading.Multithreading5;

public class Level25Task06_LoggingStateThread extends Thread {
    private Thread target;
    private boolean isAlive;

    public Level25Task06_LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        String state = target.getState().toString();
        System.out.println(state);
        while (true) {
            String str = target.getState().toString();
            if(!state.equals(str)){
                System.out.println(str);
                state = str;
            }
            if(str.equals("TERMINATED")){
                break;
            }
        }
    }
}
