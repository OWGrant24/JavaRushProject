package JavaRush.Java_Collections.Collections5.task3512;

public class Generator<T> {
    private Class<T> aClass;

    public Generator(Class<T> aClass) {
        this.aClass = aClass;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return aClass.newInstance();
    }
}


