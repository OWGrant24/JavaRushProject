package Examples.Reflection;

@Author(name = "Grant",dateOfCreation = 2021)
public class Cat {
    private String name;
    private int age;

    public Cat() {
        this.name = "Бродяга";
    }

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private void eat(){
        System.out.println(name + " кушает");
    }



    @Override
    public String toString() {
        if(age != 0){
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        } else {
            return "Cat{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
