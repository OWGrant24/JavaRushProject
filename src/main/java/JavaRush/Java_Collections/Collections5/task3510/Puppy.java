package JavaRush.Java_Collections.Collections5.task3510;

public class Puppy extends Dog {

    public Puppy(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Щенок " + name;
    }
}