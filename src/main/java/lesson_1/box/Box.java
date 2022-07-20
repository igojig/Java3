package lesson_1.box;

import lesson_1.fruit.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    List<T> storage=new ArrayList<>();

    public Box() {
    }

    public void add(T element) {
        storage.add(element);
    }

    @SafeVarargs
    public final void add(T... elements) {
        for (T element : elements) {
            storage.add(element);
        }
    }
    public void add(List<? extends T> elements){
        storage.addAll(elements);
    }

    public float getWeight() {
        float sum = 0.f;
        for (T t : storage) {
            sum += t.getWeight();
        }
        return sum;
    }

    public boolean compare(Box<?> anotherBox) {
        System.out.println("Наш вес: " + this.getWeight());
        System.out.println("Сравниваемый вес: " + anotherBox.getWeight());
        return this.getWeight() == anotherBox.getWeight();
    }

    public void transferTo(Box<? super T> anotherBox){
        for (T t : storage) {
            anotherBox.add(t);
        }
        storage.clear();
    }

    @Override
    public String toString() {
        return String.format("Коробка: вес: %s, кол-во: %s", getWeight(), storage.size());
    }
}
