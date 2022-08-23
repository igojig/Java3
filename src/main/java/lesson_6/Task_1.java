package lesson_6;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Task_1 {
    public static final int CONSTANT = 4;

    public int[] getArrayAfterLastConstant(int[] source) {

        for (int lastIndex = source.length - 1; lastIndex >= 0; lastIndex--) {
            if (source[lastIndex] == CONSTANT) {
                return Arrays.copyOfRange(source, lastIndex + 1, source.length);
            }
        }
        throw new RuntimeException("Отсутствует опорное число: " + CONSTANT);
    }

}
