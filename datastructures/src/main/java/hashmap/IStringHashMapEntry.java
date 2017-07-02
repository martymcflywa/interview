package hashmap;

/**
 * Created by marty on 1/07/2017.
 */
public interface IStringHashMapEntry {

    /**
     * Returns the key of this entry.
     * @return the key of this entry
     */
    String getKey();

    /**
     * Returns the value of this entry.
     * @return the value of this entry
     */
    String getValue();

    /**
     * Update the value of this entry with a new value.
     * @param value the new value
     * @return the old value being replaced
     */
    String setValue(String value);
}
