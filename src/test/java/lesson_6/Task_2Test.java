package lesson_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task_2Test {

    private Task_2 task_2;

    @BeforeEach
    void init(){
        task_2 = new Task_2();
    }

    @DisplayName("Полный набор")
    @Test
    void checkArrayForContainDigits_1() {
        int[] source={1,1,1,1,1,4};
        Assertions.assertTrue(task_2.checkArrayForContainDigits(source));
    }

    @DisplayName("Только единицы")
    @Test
    void checkArrayForContainDigits_2() {
        int[] source={1,1,1};
        Assertions.assertFalse(task_2.checkArrayForContainDigits(source));
    }

    @DisplayName("Только четверки")
    @Test
    void checkArrayForContainDigits_3() {
        int[] source={4,4,4,4};
        Assertions.assertFalse(task_2.checkArrayForContainDigits(source));
    }

    @DisplayName("Лишние цифры")
    @Test
    void checkArrayForContainDigits_4() {
        int[] source={1, 4,4,4,4,5};
        Assertions.assertFalse(task_2.checkArrayForContainDigits(source));
    }

    @DisplayName("Одна четверка")
    @Test
    void checkArrayForContainDigits_5() {
        int[] source={4};
        Assertions.assertFalse(task_2.checkArrayForContainDigits(source));
    }
}