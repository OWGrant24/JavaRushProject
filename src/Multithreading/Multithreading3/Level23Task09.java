package Multithreading.Multithreading3;
import java.util.List;
import Multithreading.Multithreading3.Level23Task09_vo.Level23Task09_NamedItem;

public class Level23Task09 {
    public static void main(String[] args) {
        Level23Task09 solution = new Level23Task09();
//        print(solution.getUsers());
//        print(solution.getLocations());
    }

    public static void print(List list) {
        String format = "Id=%d, name='%s', description=%s";
        for (Object obj : list) {
            Level23Task09_NamedItem item = (Level23Task09_NamedItem) obj;
            System.out.println(String.format(format, item.getId(), item.getName(), item.getDescription()));
        }
    }
}