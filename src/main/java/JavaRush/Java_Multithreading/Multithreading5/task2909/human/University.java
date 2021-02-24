package JavaRush.Java_Multithreading.Multithreading5.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {  //4
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if(student.getAverageGrade() == averageGrade){
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() { // надо найти студента с самым максимальный баллом
        double tempMaxAverageGrade = 0;
        for (Student student : students) {
            if (student.getAverageGrade() > tempMaxAverageGrade) {
                tempMaxAverageGrade = student.getAverageGrade();
            }
        }
        for (Student student : students) {
            if(student.getAverageGrade() == tempMaxAverageGrade){
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMinAverageGrade() {
        if(students.size()>0){
            double tempMinAverageGrade = students.get(0).getAverageGrade();
            for (Student student : students) {
                if (student.getAverageGrade() < tempMinAverageGrade) {
                    tempMinAverageGrade = student.getAverageGrade();
                }
            }
            for (Student student : students) {
                if(student.getAverageGrade() == tempMinAverageGrade){
                    return student;
                }
            }
        }
        return null;
    }

    public void expel(Student student){
        students.remove(student);
    }
}