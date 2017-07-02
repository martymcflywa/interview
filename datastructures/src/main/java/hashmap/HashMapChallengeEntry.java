package hashmap;

/**
 * Created by marty on 2/07/2017.
 */
public class HashMapChallengeEntry {

    private String key;
    private String value;

    public HashMapChallengeEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String setValue(String value) {
        String oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
