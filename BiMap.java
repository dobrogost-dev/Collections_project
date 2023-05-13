package collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BiMap <K,V>{
    private HashMap<K,V> keyMap;
    private HashMap<V,K> valueMap;

    public BiMap() {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
    }
    public BiMap(HashMap<K,V> keyMap, HashMap<V,K> valueMap) {
        this.keyMap = keyMap;
        this.valueMap = valueMap;
    }
    public void put (K key, V value) {
        if (keyMap.containsKey(key) || keyMap.containsKey(value)) {
            throw new IllegalArgumentException();
        } else {
            keyMap.put(key, value);
            valueMap.put(value, key);
        }
    }
    public void putAll(Map<K,V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }
    public Set<V> values() {
        return new HashSet<>(keyMap.values());
    }
    public void forcePut(K key, V value) {
        if (keyMap.containsKey(key)) {
            keyMap.replace(key, value);
        }
        if (valueMap.containsKey(value)) {
            valueMap.replace(value, key);
        }
    }
    public BiMap<V, K> inverse() {
        return new BiMap<>(valueMap,keyMap);
    }

    @Override
    public String toString() {
        return keyMap.toString();
    }
}
