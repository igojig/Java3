package lesson_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5};
        String[] b = {"A", "B", "C", "D", "E"};

        swapElements(a, 1, 2);
        swapElements(b, 1, 2);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        //---------------------------------------

        System.out.println(toList(a));
        System.out.println(toList(b));
        //--------------------------------------

        System.out.println();
        System.out.println();



    }


    // не проверяем на корректность индексов и длину массива
    public static <T> void swapElements(T[] array, int firstIndex, int secondIndex) {
        T tempElement;
        tempElement = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = tempElement;
    }

    public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T t : array) {
            list.add(t);
        }
        return list;
    }
}
