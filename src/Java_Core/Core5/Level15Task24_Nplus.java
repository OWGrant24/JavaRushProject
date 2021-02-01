package Java_Core.Core5;
/*
Разберись, что и в какой последовательности инициализируется. Поставь брейкпойнты и используй дебаггер.

Исправить порядок инициализации данных так, чтобы результат был следующим:
static void init()
Static block
public static void main
Non-static block
static void printAllFields
0
null
Solution constructor
static void printAllFields
6
First name
 */
public class Level15Task24_Nplus {
    static {
        init();
    }

    static {
        System.out.println("Static block");
    }

    {
        System.out.println("Non-static block");
        printAllFields(this);
    }

    public int i = 6;

    public String name = "First name";
    public static void init() {
        System.out.println("static void init()");
    }



    public Level15Task24_Nplus() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }



    public static void main(String[] args) {
        System.out.println("public static void main");
        Level15Task24_Nplus s = new Level15Task24_Nplus();
    }

    public static void printAllFields(Level15Task24_Nplus obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);
    }
}
