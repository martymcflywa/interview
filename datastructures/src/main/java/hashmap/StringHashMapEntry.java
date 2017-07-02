package hashmap;

/**
 * Created by marty on 2/07/2017.
 */
public class StringHashMapEntry implements IStringHashMapEntry {

    private String key;
    private String value;

    public StringHashMapEntry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String setValue(String value) {
        String oldValue = this.value;
        this.value = value;
        return oldValue;
    }
}
