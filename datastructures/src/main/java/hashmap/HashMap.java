package hashmap;

/**
 * Created by marty on 5/07/2017.
 */
public class HashMap {

    private Entry[] array;
    private int initSize;
    private int size;
    private int collisions;
    private final int DEFAULT_INIT_SIZE = 128;
    private final int STEP_SIZE = 7;

    public HashMap() {
        this.initSize = getPrime(DEFAULT_INIT_SIZE * 2);
        array = new Entry[initSize];
    }

    public HashMap(int initSize) {
        this.initSize = getPrime(initSize * 2);
        array = new Entry[this.initSize];
    }

    public String put(String key, String value) {
        int index = hash(key);
        int step = step(key);
        String output = null;
        while(array[index] != null) {
            if(array[index].key().equals(key)) {
                output = array[index].setValue(value);
                break;
            }
            collisions++;
            index += step;
            index %= initSize;
        }
        array[index] = new Entry(key, value);
        size++;
        return output;
    }

    public String get(String key) {
        int index = hash(key);
        int step = step(key);
        String output = null;
        while(array[index] != null) {
            if(array[index].key().equals(key)) {
                output = array[index].value();
                break;
            }
            index += step;
            index %= initSize;
        }
        return output;
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

    public int initSize() {
        return initSize;
    }

    public int size() {
        return size;
    }

    public int collisions() {
        return collisions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nHASHMAP:\n");
        for(int i = 0; i < initSize; i++) {
            if(array[i] != null) {
                sb.append(array[i].key())
                        .append(" : ")
                        .append(array[i].value())
                        .append(" : ")
                        .append(i)
                        .append("\n");
            } else {
                sb.append("null : null")
                        .append(" : ")
                        .append(i)
                        .append("\n");
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

        public String toString() {
            return key + " : " + value;
        }
    }
}
