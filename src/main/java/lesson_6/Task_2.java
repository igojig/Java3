package lesson_6;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;

public class Task_2 {

    public static final int CONSTANT_1 = 1;
    public static final int CONSTANT_2 = 4;

    public boolean checkArrayForContainDigits(int[] arr) {
        boolean hasOne = false;
        boolean hasFour = false;


//        решение на стримах, но оно мне не нравиться
//        -------------------------------------------

//        boolean a = Arrays.stream(arr).noneMatch(value -> value != 4 && value != 1);
//        if (!a) {
//            return false;
//        }
//        boolean b = Arrays.stream(arr).anyMatch(value -> value == 1);
//        if(!b)
//            return false;
//        boolean c = Arrays.stream(arr).anyMatch(value -> value == 4);
//        return c;


// оптимизированное решение,
// когда флаги не перезаписываются снова и снова
        for (int j : arr) {
            if (!hasOne) {
                if (j == CONSTANT_1) {
                    hasOne = true;
                    continue;
                }
            }
            if (!hasFour) {
                if (j == CONSTANT_2) {
                    hasFour = true;
                    continue;
                }
            }
            if (j != CONSTANT_1 && j != CONSTANT_2) {
                return false;
            }

        }
        return hasOne && hasFour;


//              решение "в лоб"
//            -------------------

//        for (int k : arr) {
//            switch (k) {
//                case CONSTANT_1 -> hasOne = true;
//                case CONSTANT_2 -> hasFour = true;
//                default -> {
//                    return false;
//                }
//            }
//        }
//        return hasOne && hasFour;
    }
}


