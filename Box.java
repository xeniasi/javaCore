import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    String comparison;

    private ArrayList<T> items;

    public Box(T... items) {
        this.items = new ArrayList<T>(Arrays.asList(items));
    }

    public ArrayList<T> getItems() {
        return new ArrayList<T>(items);
    }

    public float getWeight() {
        if (items.size() == 0) return 0;
        float weight = 0;
        for (T item: items) weight += item.getWeight();
        return weight;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void move(Box<? super T> box) {
        box.items.addAll(this.items);
        clear();
    }

    public void clear() {
        items.clear();
    }

    public void add(T... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void remove(T... items) {
        for (T item: items) this.items.remove(item);
    }

}
