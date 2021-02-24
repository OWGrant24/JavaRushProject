package JavaRush.Java_Multithreading.Multithreading5.task2909.human;

public class Worker extends Human { //5
    private double salary;
    private String company;  //9

    public String getCompany() {  //9
        return company;
    }

    public void setCompany(String company) {  //9
        this.company = company;
    }

    public Worker(String name, int age) {  //2
        super(name, age);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary (double salary) {
        this.salary = salary;
    }
}