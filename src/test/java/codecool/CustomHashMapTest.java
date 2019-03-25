package codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomHashMapTest {

    private CustomHashMap<String, Integer> customHashMap;

    @BeforeEach
    void setUp() {
        customHashMap = new CustomHashMap<String, Integer>(5);
    }

    @Test
    void testSize() {
        assertEquals(0, customHashMap.size());
    }

    @Test
    void testAddMethodAddsElementToHashMap() {
        customHashMap.add("Key", 1);
        customHashMap.add("Key2", 2);
        customHashMap.add("Key3", 3);
        customHashMap.add("Key4", 4);

        assertEquals(4, customHashMap.size());
    }

    @Test
    void testGetValueMethodReturnsSpecifiedElement() {
        customHashMap.add("Key", 12);

        assertEquals("12", customHashMap.getValue("Key").toString());
    }

    @Test
    void testRemoveMethodRemovesElementFromHashMap() {
        customHashMap.add("Key", 21);
        customHashMap.add("Key2", 12);
        customHashMap.add("Key3", 5);
        customHashMap.add("Key4", 36);

        assertEquals(true, customHashMap.remove("Key3"));
    }

    @Test
    void testClearAllElementsInHashMap() {
        customHashMap.add("Key", 3);
        customHashMap.add("Key2", 11);
        customHashMap.add("Key3", 24);

        customHashMap.clearAll();

        assertEquals(0, customHashMap.size());
    }
}