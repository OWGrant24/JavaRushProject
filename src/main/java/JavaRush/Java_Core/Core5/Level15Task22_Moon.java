package JavaRush.Java_Core.Core5;

public class Level15Task22_Moon implements Level15Task22_Planet {
    private static Level15Task22_Moon instance;
    private Level15Task22_Moon() {
    }
    public static Level15Task22_Moon getInstance(){
        if(instance == null){
            instance = new Level15Task22_Moon();
        }
        return instance;
    }
}
