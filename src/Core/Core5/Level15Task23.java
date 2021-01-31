package Core5;

/*
1. В классе Solution создай 4 конструктора с разными модификаторами доступа.
2. В отдельном файле создай класс SubSolution и сделай его потомком класса Solution.
3. Внутри класса SubSolution создай конструкторы командой Alt+Insert -> Constructors.
4. Исправь модификаторы доступа конструкторов в SubSolution так, чтобы получилось
3 конструктора с различными модификаторами доступа(все кроме private).
 */
public class Level15Task23 {
    String name;
    String ff;
    String xx;
    String vvv;

    public Level15Task23(String name) {
        this.name = name;
    }

    private Level15Task23(String name, String ff) {
        this.name = name;
        this.ff = ff;
    }

    protected Level15Task23(String name, String ff, String xx) {
        this.name = name;
        this.ff = ff;
        this.xx = xx;
    }

     Level15Task23(String name, String ff, String xx, String vvv) {
        this.name = name;
        this.ff = ff;
        this.xx = xx;
        this.vvv = vvv;
    }

    public static void main(String[] args) {



    }
}
