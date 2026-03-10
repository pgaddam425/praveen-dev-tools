package com.dsa.practice.datastructures.hashtable;

import java.util.LinkedList;

/**
 * Hash Table implementation using chaining for collision resolution.
 * 
 * <p>A hash table is a data structure that maps keys to values using a hash
 * function. It provides average O(1) time complexity for insert, search, and
 * delete operations.</p>
 * 
 * <p><b>How It Works:</b></p>
 * <pre>
 * Key "apple" → hash("apple") = 3 → table[3] → ["apple":5]
 * Key "banana" → hash("banana") = 3 → table[3] → ["apple":5] → ["banana":7]
 *                                              (collision handled by chaining)
 * </pre>
 * 
 * <p><b>Collision Resolution - Chaining:</b></p>
 * <ul>
 *   <li>Each table slot contains a linked list</li>
 *   <li>Multiple keys with same hash go in same list</li>
 *   <li>Search within list to find exact key</li>
 * </ul>
 * 
 * <p><b>Key Operations:</b></p>
 * <ul>
 *   <li>Put: O(1) average, O(n) worst case</li>
 *   <li>Get: O(1) average, O(n) worst case</li>
 *   <li>Remove: O(1) average, O(n) worst case</li>
 * </ul>
 * 
 * <p><b>Applications:</b></p>
 * <ul>
 *   <li>Database indexing</li>
 *   <li>Caching (LRU cache)</li>
 *   <li>Symbol tables in compilers</li>
 *   <li>Counting frequencies</li>
 *   <li>Detecting duplicates</li>
 * </ul>
 * 
 * @author Praveen Gaddam
 * @version 1.0
 */
public class HashTable {

    /**
     * Entry class represents a key-value pair in the hash table.
     */
    private static class Entry {
        String key;
        int value;

        /**
         * Constructs a new entry with the given key-value pair.
         * 
         * @param key the key
         * @param value the value
         */
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;
    private int capacity;
    private int size;

    /**
     * Constructs a hash table with the specified capacity.
     * 
     * @param capacity the number of buckets in the hash table
     */
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;                // Number of buckets
        this.size = 0;                           // Initially empty
        table = new LinkedList[capacity];        // Create array of lists
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();       // Initialize each bucket
        }
    }

    /**
     * Computes the hash value for a given key.
     * 
     * <p>Uses Java's built-in hashCode() and modulo to map to bucket index.
     * Math.abs() ensures non-negative index.</p>
     * 
     * <p><b>Example:</b></p>
     * <pre>
     * key = "apple"
     * hashCode = -1234567
     * Math.abs(-1234567) = 1234567
     * 1234567 % 10 = 7 (bucket index)
     * </pre>
     * 
     * @param key the key to hash
     * @return the bucket index (0 to capacity-1)
     */
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;  // Map to valid bucket
    }

    /**
     * Inserts or updates a key-value pair in the hash table.
     * 
     * <p>If key already exists, updates its value. Otherwise, adds new entry.</p>
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Compute hash to find bucket index</li>
     *   <li>Search bucket for existing key</li>
     *   <li>If found, update value</li>
     *   <li>If not found, add new entry to bucket</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b></p>
     * <ul>
     *   <li>Average: O(1) - assuming good hash distribution</li>
     *   <li>Worst: O(n) - all keys hash to same bucket</li>
     * </ul>
     * 
     * @param key the key to insert or update
     * @param value the value to associate with the key
     */
    public void put(String key, int value) {
        int index = hash(key);                       // Find bucket
        LinkedList<Entry> bucket = table[index];     // Get bucket list

        // Check if key already exists
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;                 // Update existing value
                return;
            }
        }

        // Key not found, add new entry
        bucket.add(new Entry(key, value));
        size++;
    }

    /**
     * Retrieves the value associated with the given key.
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Compute hash to find bucket index</li>
     *   <li>Search bucket for matching key</li>
     *   <li>Return value if found, null otherwise</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b></p>
     * <ul>
     *   <li>Average: O(1)</li>
     *   <li>Worst: O(n) - all keys in same bucket</li>
     * </ul>
     * 
     * @param key the key to look up
     * @return the value associated with key, or null if not found
     */
    public Integer get(String key) {
        int index = hash(key);                       // Find bucket
        LinkedList<Entry> bucket = table[index];     // Get bucket list

        // Search for key in bucket
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;                  // Found!
            }
        }
        return null;                                 // Not found
    }

    /**
     * Removes the entry with the specified key from the hash table.
     * 
     * <p><b>Algorithm:</b></p>
     * <ol>
     *   <li>Compute hash to find bucket</li>
     *   <li>Search bucket for key</li>
     *   <li>If found, remove entry and decrement size</li>
     * </ol>
     * 
     * <p><b>Time Complexity:</b></p>
     * <ul>
     *   <li>Average: O(1)</li>
     *   <li>Worst: O(n)</li>
     * </ul>
     * 
     * @param key the key to remove
     * @return true if key was found and removed, false otherwise
     */
    public boolean remove(String key) {
        int index = hash(key);                       // Find bucket
        LinkedList<Entry> bucket = table[index];     // Get bucket list

        // Search for and remove key
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);                // Remove from bucket
                size--;                              // Decrement size
                return true;                         // Successfully removed
            }
        }
        return false;                                // Key not found
    }

    /**
     * Checks if the hash table contains the specified key.
     * 
     * <p><b>Time Complexity:</b> O(1) average, O(n) worst</p>
     * 
     * @param key the key to check
     * @return true if key exists, false otherwise
     */
    public boolean containsKey(String key) {
        return get(key) != null;  // Reuse get() method
    }

    /**
     * Returns the number of key-value pairs in the hash table.
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return the number of entries
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the hash table is empty.
     * 
     * <p><b>Time Complexity:</b> O(1)</p>
     * 
     * @return true if hash table contains no entries, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
