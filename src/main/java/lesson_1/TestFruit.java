package lesson_1;

import lesson_1.box.Box;
import lesson_1.fruit.Apple;
import lesson_1.fruit.Fruit;
import lesson_1.fruit.Orange;

public class TestFruit {
    public static void main(String[] args) {
        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Apple a4 = new Apple();

        Orange o1 = new Orange();
        Orange o2 = new Orange();
        Orange o3 = new Orange();

        Box<Apple> appleBox_1 = new Box<>();
        Box<Apple> appleBox_2 = new Box<>();

        Box<Fruit> fruitBox_1 = new Box<>();
        Box<Fruit> fruitBox_2 = new Box<>();

        Box<Orange> orangeBox_1 = new Box<>();
        Box<Orange> orangeBox_2 = new Box<>();

        appleBox_1.add(a1, a2, a3, a4);
        orangeBox_1.add(o1, o2, o3);
        fruitBox_1.add(a1, a2, a3, a4, o1, o2, o3);

        System.out.println("Коробка с яблоками: " + appleBox_1);
        System.out.println("Коробка с апельсинами: " + orangeBox_1);
        System.out.println("Коробка с фруктами: " + fruitBox_1);

        System.out.println(appleBox_1.compare(fruitBox_1));

        System.out.println();


        // можем пересыпать в коробку с яблоками (но не с апельсинами)
        appleBox_1.transferTo(appleBox_2);
        System.out.println(appleBox_1);
        System.out.println(appleBox_2);

        System.out.println();

        // нельзя
//         appleBox_2.transferTo(orangeBox_1);

        //  можем пересыпать в коробку с фруктами (но не с апельсинами)
        appleBox_2.transferTo(fruitBox_1);
        System.out.println(appleBox_2);
        System.out.println(fruitBox_1);

        System.out.println();

        //фрукты пожем пересыпать в коробку с фруктами
        fruitBox_1.transferTo(fruitBox_2);
        System.out.println(fruitBox_1);
        System.out.println(fruitBox_2);




    }
}
