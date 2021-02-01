package Java_Multithreading.Multithreading5.task2909.human;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/** 1
Пришло время немного порефакторить.

Википедия говорит: "Рефакторинг (англ. refactoring) или реорганизация кода -
процесс изменения внутренней структуры программы, не затрагивающий её внешнего
поведения и имеющий целью облегчить понимание её работы. В основе рефакторинга
лежит последовательность небольших эквивалентных (то есть сохраняющих поведение)
преобразований. Поскольку каждое преобразование маленькое, программисту легче проследить
за его правильностью, и в то же время вся последовательность может привести к существенной
перестройке программы и улучшению её согласованности и четкости." Такими маленькими
преобразованиями мы и будем заниматься. После каждого изменения следи за сохранностью
работоспособности кода. Многие методы рефакторинга не однократно применены и проверены
сообществом программистов. Получили свои названия. Каждое задание будет сопровождено
названием рефакторинга. Ты всегда можешь прочитать более подробно о нем в книге Мартина Фаулера
 "Рефакторинг: Улучшение существующего кода".

Начнем. Внимательно ознакомься с кодом пакета human (человек).

Задания:
1.1. Подъем поля. Подними поле children в базовый класс.
1.2. Подъем метода. Подними сеттер и геттер для children в базовый класс.
1.3. Инкапсуляция коллекции.
1.3.1. Метод getChildren должен возвращать не модифицируемое представление списка children.
1.3.2. Убери сеттер для children.
1.3.3. Добавь методы addChild(Human) и removeChild(Human). Реализуй их логику.

1)Требования:
Поле children должно быть расположено в классе Human, и не должно быть расположено
в классах Teacher и Student.                                                                 +
Сеттер и геттер для поля children должны быть расположены в классе Human,
и не должны быть расположены в классах Teacher и Student.                                   +
Метод getChildren в классе Human должен возвращать Collections.unmodifiableList(children).  +
Необходимо удалить метод setChildren из класса Human.
Необходимо добавить методы addChild (Human) и removeChild (Human)
в класс Human, и реализовать их.
*/
/** 2
2.1. Извлечение подкласса.
2.1.1. Добавь класс Soldier в пакет human. +
2.1.2. Избавься от поля isSoldier.         +
2.1.3. Перенеси в Soldier необходимые методы из Human.  +
2.1.4. Обнови сигнатуру конструктора Human.   +
2.2. Подъем тела конструктора.
2.2.1. Перенеси инициализацию полей name и age в подходящее место, добавь необходимые параметры в конструктор Human. +
2.2.2. Добавь конструктор в класс Soldier. +

Требования:
Класс Soldier должен существовать в пакете human в отдельном файле.  //солдат
Класс Soldier должен наследоваться от класса Human.
В классе Human не должно быть поля isSoldier.
В класс Soldier из класса Human требуется перенести необходимые методы.
Конструктор класса Human должен принимать два параметра: String name и int age,
и инициализировать соответствующие поля.
В классе Soldier должен быть конструктор, который принимает два параметра:
String name и int age, и вызывает соответствующий конструктор суперкласса.
 */
public class Human implements Alive {  //5
    private List<Human> children = new ArrayList<>(); //1+
    private static int nextId = 0;  //8
    private int id;
    protected int age;
    protected String name;


    protected Size size;

    private BloodGroup bloodGroup;  //9

    public class Size {
        public int weight;
        public int height;

    }

    public BloodGroup getBloodGroup() {  //9
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) { //9
        this.bloodGroup = bloodGroup;
    }

    public Human(String name, int age) { //2
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public void live() {  //2
    }

    public List<Human> getChildren() { //1+
        return Collections.unmodifiableList(children);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getPosition(){
        return "Человек";
    }
    public void printData() {
        System.out.println(getPosition() + ": " + name);
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }  //9
}

//    public static final int FIRST = 1;
//    public static final int SECOND = 2;
//    public static final int THIRD = 3;
//    public static final int FOURTH = 4;
//    private int bloodGroup;

//    public void setBloodGroup(int code) {
//        bloodGroup = code;
//    }
//
//    public int getBloodGroup() {
//        return bloodGroup;
//    }