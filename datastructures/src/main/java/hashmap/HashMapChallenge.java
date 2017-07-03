package hashmap;

/**
 * Created by marty on 2/07/2017.
 */
public class HashMapChallenge {

    private HashMapChallengeEntry[] array;
    private int initSize;
    private int size;
    private static final int STEP_SIZE = 7;

    public HashMapChallenge() {
        initSize = getPrime(32);
        array = new HashMapChallengeEntry[initSize];
    }

    public HashMapChallenge(int initSize) {
        this.initSize = getPrime(initSize);
        array = new HashMapChallengeEntry[this.initSize];
    }

    private int hash(String key) {
        return Math.abs(key.hashCode() % initSize);
    }

    private int step(String key) {
        return STEP_SIZE - Math.abs(key.hashCode() % STEP_SIZE);
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

    private int getPrime(int initSize) {
        int newSize = initSize * 2;
        for(int i = newSize; true; i++) {
            if(isPrime(i)) {
                return i;
            }
        }
    }

    public String put(String key, String value) {
        int index = hash(key);
        String output = null;
        for(int i = index; i < initSize; i += step(key)) {
            if(array[i] != null && array[i].getKey().equals(key)) {
                output = array[i].setValue(value);
                break;
            }
        }
        array[index] = new HashMapChallengeEntry(key, value);
        size++;
        return output;
    }

    public String get(String key) {
        int index = hash(key);
        String output = null;
        for(int i = index; i < initSize; i += step(key)) {
            if(array[i] != null && array[i].getKey().equals(key)) {
                output = array[i].getValue();
            }
        }
        return output;
    }

    public String remove(String key) {
        int index = hash(key);
        String output = null;
        for(int i = index; i < initSize; i += step(key)) {
            if(array[i] != null && array[i].getKey().equals(key)) {
                output = array[i].getValue();
                array[i] = null;
                size--;
            }
        }
        return output;
    }

    public int size() {
        return size;
    }
}
