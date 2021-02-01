package Java_Multithreading.Multithreading5.task2909.human;
import java.util.Date;

public class Student extends UniversityPerson {  //5
    private int course;  //3
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) { //2
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }

    public void incAverageGrade(double delta){  //9.1
        setAverageGrade(getAverageGrade()+delta);
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAverageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
        }

    public String getPosition(){
        return "Студент";
    }

    public void setBeginningOfSession(Date date) {  //7
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) { //7
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }
}