package Multithreading.Multithreading1;
import java.util.Date;

/*
Ошибка в equals/hashCode

*/

public class Level21Task06 {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Level21Task06 solution;

    public Level21Task06(int anInt, String string, double aDouble, Date date, Level21Task06 solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Level21Task06 that = (Level21Task06) o;

        if (anInt != that.anInt) return false;
        if (Double.compare(that.aDouble, aDouble) != 0) return false;
        if (string != null ? !string.equals(that.string) : that.string != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return solution != null ? solution.equals(that.solution) : that.solution == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        result = 31 * result + (string != null ? string.hashCode() : 0);
        temp = Double.doubleToLongBits(aDouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }
    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Level21Task06)) return false;
//
//        Level21Task06 solution1 = (Level21Task06) o;
//
//        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
//        if (anInt != solution1.anInt) return false;
//        if (date != null ? !date.equals(solution1.date) : solution1.date == null) return false;
//        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution == null) return false;
//        if (string != null ? !string.equals(solution1.string) : solution1.string == null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = anInt;
//        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (solution != null ? solution.hashCode() : 0);
//        return result;
//    }

    public static void main(String[] args) {
        Level21Task06 svinoryl = new Level21Task06(66, "Дон",23, null, null);
        Level21Task06 kozlorog = new Level21Task06(66, "Дон",23, null, null);
        System.out.println(svinoryl.equals(kozlorog));
    }
}