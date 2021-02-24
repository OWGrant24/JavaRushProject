package JavaRush.Java_Core.Core7;

import java.util.Date;

public class Level17Task11_Person {
    private String name;
    private Level17Task11_Sex sex;
    private Date birthDate;

    private Level17Task11_Person(String name, Level17Task11_Sex sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public static Level17Task11_Person createMale(String name, Date birthDate) {
        return new Level17Task11_Person(name, Level17Task11_Sex.MALE, birthDate);
    }

    public static Level17Task11_Person createFemale(String name, Date birthDate) {
        return new Level17Task11_Person(name, Level17Task11_Sex.FEMALE, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level17Task11_Sex getSex() {
        return sex;
    }

    public void setSex(Level17Task11_Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}