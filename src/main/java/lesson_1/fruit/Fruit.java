package lesson_1.fruit;

abstract public class Fruit implements Comparable<Fruit> {
    private final String name;
    private final float weight;

    public Fruit(String name, float weight) {
        this.weight = weight;
        this.name = name;
    }

    public float getWeight(){
        return weight;
    }

    @Override
    public String toString() {
        return '{' + name + '\'' +
                ", вес=" + weight +
                '}';
    }

    @Override
    public int compareTo(Fruit o) {
        return (int)(this.weight-o.weight);
    }
}
