package Multithreading.Multithreading10;

public class Level30Task06 {
    public static void main(String[] args) {
         /* expected output
        x=4, y=5
        x=5, y=4
         */

        Level30Task06_Pair pair = new Level30Task06_Pair(7, 6);
        System.out.println(pair);
        pair.swap();
        System.out.println(pair);
    }
}
