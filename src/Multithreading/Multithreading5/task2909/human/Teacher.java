package Multithreading.Multithreading5.task2909.human;

public class Teacher extends UniversityPerson {  //5
    private int numberOfStudents;

    public Teacher(String name, int age, int numberOfStudents) {  //2
        super(name, age);
        this.numberOfStudents = numberOfStudents;
    }

    public void live() {
        teach();
    }

    public void teach() {
    }
    public String getPosition(){
        return "Преподаватель";
    }
}