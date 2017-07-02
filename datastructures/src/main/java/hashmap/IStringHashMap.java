package hashmap;

import java.util.Set;

/**
 * Created by marty on 1/07/2017.
 */
public interface IStringHashMap {

    /**
     * Return true if map is empty.
     * @return true if map is empty
     */
    boolean isEmpty();

    /**
     * Return number of entries.
     * @return number of entries in map
     */
    int size();

    /**
     * Hashes the key and returns the array index.
     * @param key the key to hash
     * @return the int array index
     */
    int hash(String key);

    /**
     * Return value of key or null if no such entry exists. Throw ClassCastException if map cannot contain key with
     * class of key.
     * @param key the key to search for
     * @return the value of the key
     */
    String get(String key);

    /**
     * Remove the entry with key (if it exists) from the map. Return the value of the key or null if it doesn't exist.
     * @param key
     * @return the value of the key or null if it doesn't exist
     */
    String remove(String key);

    /**
     * Add the entry(key, value) to the map, replacing existing entry with key. Return the value in that entry if
     * replacement occurs, or null if no entries need to be replaced.
     * @param key
     * @param value
     * @return the value being replaced, or null if it doesn't exist
     */
    String put(String key, String value);

    /**
     * Overlay this map with that. Add all entries of that map to this map, replacing existing entries with identical keys.
     * @param that the map to be overlayed with this map.
     */
    void putAll(IStringHashMap that);

    /**
     * Clears all elements in the map.
     */
    void clear();

    /**
     * Returns the set of all keys in this map.
     * @return the set of all keys in this map
     */
    Set keySet();
}
