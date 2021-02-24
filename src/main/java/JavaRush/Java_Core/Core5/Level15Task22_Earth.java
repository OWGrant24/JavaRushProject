package JavaRush.Java_Core.Core5;

public class Level15Task22_Earth implements Level15Task22_Planet {
    private static Level15Task22_Earth instance;
    private Level15Task22_Earth() {
    }
    public static Level15Task22_Earth getInstance(){
        if(instance == null){
            instance = new Level15Task22_Earth();
        }
        return instance;
    }
}
