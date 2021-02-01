package Java_Core.Core5;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Закрепляем паттерн Singleton
Для решения этой задачи тебе нужно:
Найти пример паттерна Singleton с ленивой реализацией (lazy initialization).
По образу и подобию в отдельных файлах создать в отдельных файлах
три класса синглтона — Sun, Moon, Earth.
Реализовать интерфейс Planet в классах Sun, Moon, Earth.
В статическом блоке класса Solution вызвать метод readKeyFromConsoleAndInitPlanet().
Реализовать функционал метода readKeyFromConsoleAndInitPlanet():
для этого считай с консоли один параметр типа String.
если он равен одной из констант интерфейса Planet, создай соответствующий
объект и присвой его Planet thePlanet, иначе — обнули Planet thePlanet.
*/

public class Level15Task22 {
    public static void main(String[] args) { }
    public static Level15Task22_Planet thePlanet;

    static {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String string = reader.readLine();
            if(string.equals(Level15Task22_Planet.SUN)) {
                thePlanet = Level15Task22_Sun.getInstance();
            } else if(string.equals(Level15Task22_Planet.EARTH)) {
                thePlanet = Level15Task22_Earth.getInstance();
            } else if(string.equals(Level15Task22_Planet.MOON)) {
                thePlanet = Level15Task22_Moon.getInstance();
            } else {
                thePlanet = null;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
