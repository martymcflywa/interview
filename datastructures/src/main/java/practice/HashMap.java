package practice;

/**
 * Created by marty on 4/07/2017.
 */
public class HashMap {

    private Entry[] array;
    private int initSize;
    private int size;
    private final int DEFAULT_INIT_SIZE = 256;
    private final int STEP_SIZE = 13;

    public HashMap() {
        initSize = getPrime(DEFAULT_INIT_SIZE * 2);
        array = new Entry[initSize];
    }

    public HashMap(int initSize) {
        this.initSize = getPrime(initSize * 2);
        array = new Entry[this.initSize];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % initSize);
    }

    private int step(String key) {
        return STEP_SIZE - Math.abs(key.hashCode() % STEP_SIZE);
    }

    private int getPrime(int initSize) {
        for(int i = initSize; true; i++) {
            if(isPrime(i)) {
                return i;
            }
        }
    }

    private boolean isPrime(int initSize) {
        if(initSize % 2 == 0) {
            return false;
        }
        for(int i = 3; i * i <= initSize; i += 2) {
            if(initSize % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String put(String key, String value) {
        int index = hash(key);
        String output = null;
        for(int i = index; i < initSize; i += step(key)) {
            if(array[i] != null && array[i].key().equals(key)) {
                output = array[i].setValue(value);
                break;
            }
        }
        array[index] = new Entry(key, value);
        size++;
        return output;
    }

    public String get(String key) {
        int index = hash(key);
        String output = null;
        for(int i = index; i < initSize; i += step(key)) {
            if(array[i] != null && array[i].key().equals(key)) {
                output = array[i].value();
                break;
            }
        }
        return output;
    }

    public String remove(String key) {
        int index = hash(key);
        String output = null;
        for(int i = index; i < initSize; i += step(key)) {
            if(array[i] != null && array[i].key().equals(key)) {
                output = array[i].value();
                array[i] = null;
                size--;
                break;
            }
        }
        return output;
    }

    public int size() {
        return size;
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
            String output = null;
            if(this.value != null) {
                output = this.value;
            }
            this.value = value;
            return output;
        }
    }
}
