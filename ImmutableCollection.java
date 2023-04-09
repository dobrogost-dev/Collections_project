package collections;


import java.util.ArrayList;
import java.util.Objects;

final public class ImmutableCollection<E> {
    private ArrayList<E> elements;
    private ImmutableCollection() {
        elements = new ArrayList<>();
    }
    private ImmutableCollection(ArrayList<E> elementsArray) {
        elements = elementsArray;
    }
    public static <E> ImmutableCollection of() {
        return new ImmutableCollection<E>();
    }
    public static <E> ImmutableCollection of(E... elements) {
        ArrayList<E> newArray = new ArrayList<E>();
        for (E element : elements) {
            if (!Objects.isNull(element)) {
                newArray.add(element);
            } else {
                throw new NullPointerException();
            }
        }
        return new ImmutableCollection(newArray);
    }
    public boolean contains(E element) {
        for (E elementOriginal : elements) {
            if (Objects.equals(elementOriginal,element)) {
                return true;
            }
        }
        return false;
    }
    public int size() {
        return elements.size();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    @Override
    public String toString() {
        return elements.toString();
    }
}
