package collections;

import java.util.HashMap;
import java.util.Set;

public class Multiset <E>{
    private HashMap<E, Integer> multiset;
    public Multiset() {
        multiset = new HashMap();
    }
    public void add(E element) {
        if (multiset.containsKey(element)) {
            multiset.replace(element, multiset.get(element) + 1);
        } else {
            multiset.put(element, 1);
        }
    }
    public void add(E element, int occurancies) {
        multiset.put(element, occurancies);
    }
    public boolean contains(E element) {
        if (multiset.containsKey(element)) {
            return multiset.get(element) > 0;
        }
        return false;
    }
    public int count (E element) {
        return multiset.get(element);
    }
    public Set<E> elementSet() {
        return multiset.keySet();
    }
    public void remove(E element) {
        if (multiset.containsKey(element)) {
            if (multiset.get(element) > 0) {
                multiset.replace(element, multiset.get(element) - 1);
            }
        }
    }
    public void remove(E element, int occurancies) {
        if (multiset.containsKey(element)) {
            multiset.replace(element, Math.max(multiset.get(element) - occurancies, 0));
        }
    }
    public void setCount(E element, int count) {
        if (multiset.containsKey(element)) {
            multiset.replace(element, count);
        }
    }
    public void setCount(E element, int oldCount, int newCount) {
        if (multiset.get(element) == oldCount) {
            setCount(element, newCount);
        }
    }
    @Override
    public String toString() {
        return multiset.toString();
    }
}
