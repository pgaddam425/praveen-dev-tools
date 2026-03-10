package com.dsa.practice.datastructures.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    private HashTable hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable(10);
    }

    @Test
    void testPut() {
        hashTable.put("key1", 100);
        hashTable.put("key2", 200);
        assertEquals(2, hashTable.size());
    }

    @Test
    void testGet() {
        hashTable.put("key1", 100);
        hashTable.put("key2", 200);
        assertEquals(100, hashTable.get("key1"));
        assertEquals(200, hashTable.get("key2"));
    }

    @Test
    void testGetNonExistent() {
        assertNull(hashTable.get("nonexistent"));
    }

    @Test
    void testUpdateValue() {
        hashTable.put("key1", 100);
        hashTable.put("key1", 200);
        assertEquals(200, hashTable.get("key1"));
        assertEquals(1, hashTable.size());
    }

    @Test
    void testRemove() {
        hashTable.put("key1", 100);
        hashTable.put("key2", 200);
        assertTrue(hashTable.remove("key1"));
        assertNull(hashTable.get("key1"));
        assertEquals(1, hashTable.size());
    }

    @Test
    void testRemoveNonExistent() {
        assertFalse(hashTable.remove("nonexistent"));
    }

    @Test
    void testContainsKey() {
        hashTable.put("key1", 100);
        assertTrue(hashTable.containsKey("key1"));
        assertFalse(hashTable.containsKey("key2"));
    }

    @Test
    void testIsEmpty() {
        assertTrue(hashTable.isEmpty());
        hashTable.put("key1", 100);
        assertFalse(hashTable.isEmpty());
    }
}
