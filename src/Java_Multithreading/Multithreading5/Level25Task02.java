package Java_Multithreading.Multithreading5;

import java.util.ArrayList;
import java.util.List;

/*
Машину на СТО не повезем!
Инициализируй поле wheels используя данные из loadWheelNamesFromDB.
Выкинь исключение в случае некорректных данных.

Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/

public class Level25Task02 {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            //init wheels here
            wheels = new ArrayList<>();
                String[] wheelsArr = loadWheelNamesFromDB();
                if(wheelsArr.length == 4) {
                    for (String wh : wheelsArr) {
                        wheels.add(Wheel.valueOf(wh));
                    }
                } else {
                    throw new IllegalArgumentException();
                }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.wheels.toString());
    }
}