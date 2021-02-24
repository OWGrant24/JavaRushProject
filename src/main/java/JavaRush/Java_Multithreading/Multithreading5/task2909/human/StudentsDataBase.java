package JavaRush.Java_Multithreading.Multithreading5.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {   //7
        students.add(student);
        printInfoAboutStudent(student);
    }

    public static void printInfoAboutStudent(Student student) {  //7
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    public static void removeStudent(int index) {   //8
        if(students.size()>index && index>=0){
            students.remove(index);
        }
    }

    public static void findDimaOrSasha() {  //8
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals("Dima")) {
                System.out.println("Студент Dima есть в базе.");
                break;
            }
            if (students.get(i).getName().equals("Sasha")) {
                System.out.println("Студент Sasha есть в базе.");
                break;
            }
        }
    }
}