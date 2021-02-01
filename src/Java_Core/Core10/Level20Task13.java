package Java_Core.Core10;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

/*
Externalizable Person
Класс Person должен сериализовываться с помощью интерфейса Externalizable.
Исправь ошибку сериализации.
Сигнатуры методов менять нельзя.
 */
public class Level20Task13 {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Имя : " + firstName + " Фамилия : " + lastName + " Возвраст : " + age ;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(mother);
            out.writeObject(father);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            age = in.readInt();
            children = (List<Person>) in.readObject();
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Alex","Volkoff",28);
        Person mother = new Person("Мама", "Volk", 52);
        Person father = new Person("Папа", "Volk", 51);
        List<Person> childperson = new ArrayList<>();
        Person childVolk = new Person();
        childperson.add(childVolk);
        person.setChildren(childperson);
        person.setMother(mother);
        person.setFather(father);
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(
                "Exp\\2013.dat"))){
            person.writeExternal(objectOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Person person2 = new Person("Misha","Shvak",21);
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(
                "Exp\\2013.dat"))) {
            person2.readExternal(objectInputStream);
        } catch (FileNotFoundException | ClassNotFoundException e) {
            System.out.println("не найден");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Крэш");
            e.printStackTrace();
        }
        System.out.println(person2.toString());
    }
}
