package Java_Core.Core7;

import java.util.Date;

public class Level17Task10_Person {
    private String name;
    private Level17Task10_Sex sex;
    private Date birthDate;

    private Level17Task10_Person(String name, Level17Task10_Sex sex, Date birthDate) {
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
    }

    public static Level17Task10_Person createMale(String name, Date birthDate) {
        return new Level17Task10_Person(name, Level17Task10_Sex.MALE, birthDate);
    }

    public static Level17Task10_Person createFemale(String name, Date birthDate) {
        return new Level17Task10_Person(name, Level17Task10_Sex.FEMALE, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level17Task10_Sex getSex() {
        return sex;
    }

    public void setSex(Level17Task10_Sex sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}