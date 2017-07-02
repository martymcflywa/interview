package hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marty on 2/07/2017.
 */
public class HashMap {

    private IStringHashMapEntry[] array;
    private int initSize;
    private int size;
    private static final int STEP_DISTANCE = 7;

    public HashMap() {
        initSize = 512;
        array = initArray(initSize);
    }

    public HashMap(int initSize) {
        this.initSize = initSize;
        array = initArray(this.initSize);
    }

    protected IStringHashMapEntry[] initArray(int initSize) {
        int prime = getPrime(initSize);
        if(array == null) {
            return new IStringHashMapEntry[prime];
        }
        return copyToResizedArray(prime);
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % initSize);
    }

    private int step(String key) {
        return STEP_DISTANCE - Math.abs(key.hashCode() % STEP_DISTANCE);
    }

    public void put(String key, String value) {
        int index = hash(key);
        while(array[index] != null) {
            if(array[index].getKey().equals(key)) {
                String oldKey = array[index].getKey();
                String oldValue = array[index].getValue();
                System.out.println("replacing old " + oldKey + " : " + oldValue + " with " + key + " : " + value);
                array[index].setValue(value);
                return;
            }
            System.out.println("collision at index" + index + " for " + key + " : " + value);
            index += step(key);
            index %= initSize;
        }
        array[index] = new StringHashMapEntry(key, value);
        size++;
        System.out.println("index" + index + " has " + key + " : " + value);
    }

    public String get(String key) {
        int index = hash(key);
        while(array[index] != null) {
            if(array[index].getKey().equals(key)) {
                String value = array[index].getValue();
                System.out.println(key + " : " + value + " found at index" + index);
                return value;
            }
            index += step(key);
            index %= initSize;
        }
        System.out.println(key + " not found, returning null");
        return null;
    }

    public String remove(String key) {
        String value = null;
        for(int i = hash(key); i < array.length; i++) {
            if (array[i] != null) {
                if (array[i].getKey().equals(key)) {
                    value = array[i].getValue();
                    System.out.println("removing " + key + " : " + value + " at index" + i);
                    array[i] = null;
                    break;
                }
            } else {
                System.out.println(key + " not found, entry not deleted");
                break;
            }
        }
        return value;
    }

    public IStringHashMapEntry[] copyToResizedArray(int newSize) {
        IStringHashMapEntry[] oldArray = removeNulls(array);
        IStringHashMapEntry[] newArray = new IStringHashMapEntry[newSize];
        this.initSize = newSize;
        for(IStringHashMapEntry entry : oldArray) {
            int index = hash(entry.getKey());
            newArray[index] = entry;
        }
        return newArray;
    }

    protected IStringHashMapEntry[] removeNulls(IStringHashMapEntry[] array) {
        List<IStringHashMapEntry> entries = new ArrayList<>();
        for(IStringHashMapEntry entry : array) {
            if(entry != null) {
                entries.add(entry);
            }
        }
        return entries.toArray(new IStringHashMapEntry[entries.size()]);
    }

    protected boolean isPrime(int number) {
        if(number % 2 == 0) {
            return false;
        }
        for(int i = 3; i * i <= number; i += 2) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    protected int getPrime(int number) {
        for(int i = number; true; i++) {
            if(isPrime(i)) {
                System.out.println("\ninitial size: " + number + ", next prime: " + i);
                return i;
            }
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nHASHMAP:\n");
        for(int i = 0; i < array.length; i++) {
            if(array[i] != null) {
                sb.append("index" + i + " = " + array[i].getKey() + " : " + array[i].getValue() + "\n");
            }
        }
        return sb.toString();
    }
}
