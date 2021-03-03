package JavaRush.Java_Collections.Collections5.task3702.female;

import JavaRush.Java_Collections.Collections5.task3702.AbstractFactory;
import JavaRush.Java_Collections.Collections5.task3702.Human;

public class FemaleFactory implements AbstractFactory {

    public Human getPerson(int age) {
        if (age <= KidGirl.MAX_AGE) {
            return new KidGirl();
        } else if (age <= TeenGirl.MAX_AGE) {
            return new TeenGirl();
        } else {
            return new Woman();
        }
    }
}
