package JavaRush.Java_Collections.Collections5.task3702;

import JavaRush.Java_Collections.Collections5.task3702.female.FemaleFactory;
import JavaRush.Java_Collections.Collections5.task3702.male.MaleFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(HumanFactoryType type) {
        if (type == HumanFactoryType.MALE) {
            return new MaleFactory();
        } else if (type == HumanFactoryType.FEMALE) {
            return new FemaleFactory();
        }
        return null;
    }

    public static enum HumanFactoryType {
        MALE, FEMALE;
    }

}
