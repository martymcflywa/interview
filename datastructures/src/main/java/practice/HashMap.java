package practice;

/**
 * Created by marty on 6/07/2017.
 */
public class HashMap {

    private Entry[] array;
    private int initSize;
    private int size;
    private int collisions;
    private final int DEFAULT_INIT_SIZE = 32;
    private final int STEP_SIZE = 5;

    public HashMap() {
        initSize = getPrime(DEFAULT_INIT_SIZE * 2);
        array = new Entry[initSize];
    }

    public HashMap(int initSize) {
        this.initSize = getPrime(initSize * 2);
        array = new Entry[this.initSize];
    }

    public String put(String key, String value) {
        int index = hash(key);
        int step = step(key);
        while(array[index] != null) {
            if(array[index].key().equals(key)) {
                return array[index].setValue(value);
            }
            collisions++;
            index += step;
            index %= initSize;
        }
        array[index] = new Entry(key, value);
        size++;
        return null;
    }

    public String get(String key) {
        int index = hash(key);
        int step = step(key);
        while(array[index] != null) {
            if(array[index].key().equals(key)) {
                return array[index].value();
            }
            index += step;
            index %= initSize;
        }
        return null;
    }

    public String remove(String key) {
        int index = hash(key);
        int step = step(key);
        String output = null;
        while(array[index] != null) {
            if(array[index].key().equals(key)) {
                output = array[index].value();
                array[index] = null;
                size--;
                break;
            }
            index += step;
            index %= initSize;
        }
        return output;
    }

    private int getPrime(int initSize) {
        for(int i = initSize; true; i++) {
            if(isPrime(i)) {
                return i;
            }
        }
    }

    private boolean isPrime(int number) {
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

    private int hash(String key) {
        return Math.abs(key.hashCode() % initSize);
    }

    private int step(String key) {
        return Math.abs(STEP_SIZE - (key.hashCode() % initSize));
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nentries=" + size)
                .append("\narray size=" + initSize)
                .append("\ncollisions=" + collisions)
                .append("\n\nENTRIES");

        for(Entry e : array) {
            if(e == null) {
                sb.append("\nnull : null");
            } else {
                sb.append("\n" + e.key() + " : " + e.value());
            }
        }
        return sb.toString();
    }

    class Entry {
        private String key;
        private String value;

        public Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String key() {
            return key;
        }

        public String value() {
            return value;
        }

        public String setValue(String value) {
            String oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
