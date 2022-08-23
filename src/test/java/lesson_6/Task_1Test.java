package lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Task_1Test {

    private Task_1 task_1;


    @BeforeEach
    void beforeEach() {
        task_1 = new Task_1();
    }


    @Test
    @DisplayName("тест 1")
    void testGetArrayAfterLastConstant() {
        int[] source = {1, 2, 3, 5,4, 4, 7,8,9};
        int[] exp = {7, 8, 9};
        Assertions.assertArrayEquals(exp, task_1.getArrayAfterLastConstant(source));
    }

    @Test
    @DisplayName("тест 2")
    void testGetArrayAfterLastConstant_1() {
        int[] source = {1, 4, 3, 5, 4, 7, 4, 9};
        int[] exp = {9};
        Assertions.assertArrayEquals(exp, task_1.getArrayAfterLastConstant(source));
    }

    @Test
    @DisplayName("тест 3")
    void testGetArrayAfterLastConstant_2() {
        int[] source = {1, 2, 3, 5, 4, 7, 8, 9, 4};
        int[] exp = {};
        Assertions.assertArrayEquals(exp, task_1.getArrayAfterLastConstant(source));
    }


    @Test
    @DisplayName("тестируем исключение")
    void testGetArrayAfterLastConstant_3() {
        int[] source = {1, 2, 3, 7, 8, 9};

        Assertions.assertThrows(RuntimeException.class, () -> task_1.getArrayAfterLastConstant(source));
    }


    @DisplayName("параметрический тест")
    @MethodSource("dataForParamTest")
    @ParameterizedTest
    void paramTest(int[] exp, int[] source) {
        Assertions.assertArrayEquals(exp, task_1.getArrayAfterLastConstant(source));
    }

    static Stream<Arguments> dataForParamTest() {
        List<Arguments> out = new ArrayList<>();
        out.add(Arguments.arguments(new int[]{5, 6, 7},       new int[]{4, 2, 3, 4, 5, 6, 7}));
        out.add(Arguments.arguments(new int[]{5, 6, 7},       new int[]{1, 2, 3, 4, 5, 6, 7}));
        out.add(Arguments.arguments(new int[]{},              new int[]{1, 2, 3, 4, 5, 6, 4}));
        out.add(Arguments.arguments(new int[]{2, 3, 5, 6, 7}, new int[]{4, 2, 3, 5, 6, 7}));
        return out.stream();
    }

}