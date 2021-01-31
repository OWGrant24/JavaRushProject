package Test;

import java.util.Arrays;
import java.util.Comparator;

public class Comparator_ {  //Level26Task02
    public static void main(String[] args) {
        Integer[] arr = {13, 8, 16, 5, 17, 155, 1, 21 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static Integer[] sort(Integer[] array) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 > o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
        Arrays.sort(array,comparator);
        return array;
    } //[155, 21, 17, 16, 13, 8, 5, 1]
}
