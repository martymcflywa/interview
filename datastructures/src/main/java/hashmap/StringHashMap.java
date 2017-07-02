package hashmap;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by marty on 1/07/2017.
 */
public class StringHashMap implements IStringHashMap {

    private int size;
    private IStringHashMapEntry[] array;
    private int initSize;

    private StringHashMap() {
        initSize = 512;
        array = new IStringHashMapEntry[initSize];
    }

    public StringHashMap(int initSize) {
        this.initSize = initSize;
        array = new IStringHashMapEntry[this.initSize];
    }

    @Override
    public boolean isEmpty() {
        if(size > 0) {
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int hash(String key) {
        return Math.abs(key.hashCode() % initSize);
    }

    @Override
    public String get(String key) {
        int index = hash(key);
        if(array[index] == null) {
            return null;
        } else {
            return array[index].getValue();
        }
    }

    @Override
    public String remove(String key) {
        String oldValue = null;
        int index = hash(key);
        if(array[index] != null) {
            oldValue = array[index].getValue();
            array[index] = null;
            size--;
        }
        return oldValue;
    }

    @Override
    public String put(String key, String value) {
        String oldValue = null;
        int index = hash(key);
        if(array[index] != null) {
            oldValue = array[index].getValue();
            array[index].setValue(value);
        } else {
            array[index] = new StringHashMapEntry(key, value);
            size++;
        }
        return oldValue;
    }

    @Override
    public void putAll(IStringHashMap that) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        Set<String> keySet = new TreeSet<>();
        for(IStringHashMapEntry entry : array) {
            keySet.add(entry.getKey());
        }
        return keySet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(IStringHashMapEntry entry : array) {
            sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
