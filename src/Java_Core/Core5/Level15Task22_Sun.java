package Java_Core.Core5;

public class Level15Task22_Sun implements Level15Task22_Planet {
    private static Level15Task22_Sun instance;
    private Level15Task22_Sun() {
    }
    public static Level15Task22_Sun getInstance(){
        if(instance == null){
            instance = new Level15Task22_Sun();
        }
        return instance;
    }
}
