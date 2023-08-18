import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Exception.InvalidIndexException;
import Exception.NullItemException;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private IntegerList list;

    @BeforeEach
    public void setUp() {
        list = new IntegerListImpl();
    }


    @Test
    public void testAddToEmptyList() {
        list.add(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    public void testAddToNonEmptyList() {
        list.add(5);
        list.add(7);
        assertEquals(2, list.size());
        assertEquals(5, list.get(0));
        assertEquals(7, list.get(1));
    }

    @Test
    public void testAddAtIndex() {
        list.add(5);
        list.add(7);
        list.add(1, 10);
        assertEquals(3, list.size());
        assertEquals(5, list.get(0));
        assertEquals(10, list.get(1));
        assertEquals(7, list.get(2));
    }

    @Test
    public void testRemoveFromStart() {
        list.add(5);
        list.add(7);
        int removed = list.remove(0);
        assertEquals(1, list.size());
        assertEquals(5, removed);
        assertFalse(list.contains(5));
    }

    @Test
    public void testRemoveFromMiddle() {
        list.add(5);
        list.add(7);
        int removed = list.remove(1);
        assertEquals(1, list.size());
        assertEquals(7, removed);
        assertFalse(list.contains(7));
    }

    @Test
    public void testRemoveFromEnd() {
        list.add(5);
        list.add(7);
        int removed = list.remove(1);
        assertEquals(1, list.size());
        assertEquals(7, removed);
        assertFalse(list.contains(7));
    }

    @Test
    public void testRemoveNonExistingElement() {
        list.add(9);
        list.add(11);
        assertThrows(IllegalArgumentException.class, () -> list.remove(10));
    }

    @Test
    public void testRemoveUntilClear() {
        list.add(5);
        list.add(7);
        list.remove(0);
        assertEquals(1, list.size());
        assertFalse(list.contains(5));
        list.remove(0);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testRemoveAfterClear() {
        list.add(5);
        list.add(7);
        list.clear();
        assertThrows(InvalidIndexException.class, () -> list.remove(0));
    }

    @Test
    public void testRemoveExistingElement() {
        list.add(5);
        list.add(7);
        int removed = list.remove(0);
        assertEquals(1, list.size());
        assertEquals(5, removed);
        assertFalse(list.contains(5));
    }

    @Test
    public void testGetFromEmptyList() {
        assertThrows(InvalidIndexException.class, () -> list.get(0));
    }

    @Test
    public void testGetValidIndex() {
        list.add(5);
        list.add(7);
        int value = list.get(1);
        assertEquals(7, value);
    }

    @Test
    public void testGetInvalidIndex() {
        list.add(5);
        list.add(7);
        assertThrows(InvalidIndexException.class, () -> list.get(-1));
        assertThrows(InvalidIndexException.class, () -> list.get(2));
    }

    @Test
    public void testChangeElementValidIndex() {
        list.add(5);
        list.add(7);
        Integer oldValue = list.set(1, 10);
        assertEquals(7, oldValue);
        assertEquals(10, list.get(1));
    }

    @Test
    public void testChangeElementInvalidIndex() {
        list.add(5);
        list.add(7);
        assertThrows(InvalidIndexException.class, () -> list.set(-1, 10));
        assertThrows(InvalidIndexException.class, () -> list.set(2, 10));
    }

    @Test
    public void testChangeElementToNull() {
        list.add(5);
        list.add(7);
        assertThrows(NullItemException.class, () -> list.set(1, null));
    }

    @Test
    public void testContainsExistingElement() {
        list.add(5);
        list.add(7);
        assertTrue(list.contains(5));
        assertTrue(list.contains(7));
    }

    @Test
    public void testContainsNonExistingElement() {
        list.add(5);
        list.add(7);
        assertFalse(list.contains(10));
    }

    @Test
    public void testEqualsWithItself() {
        list.add(5);
        list.add(7);
        assertTrue(list.equals(list));
    }

    @Test
    public void testEqualsWithDifferentLengthList() {
        list.add(5);
        list.add(7);
        IntegerList otherList = new IntegerListImpl();
        otherList.add(5);
        assertFalse(list.equals(otherList));
    }

    @Test
    public void testEqualsWithSameElements() {
        list.add(5);
        list.add(7);
        IntegerList otherList = new IntegerListImpl();
        otherList.add(5);
        otherList.add(7);
        assertTrue(list.equals(otherList));
    }

    @Test
    public void testIncreaseSizeByAddingElements() {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(5, list.size());
    }

    @Test
    public void testDecreaseSizeByRemovingElements() {
        list.add(5);
        list.add(7);
        list.remove(0);
        assertEquals(1, list.size());
    }

    @Test
    public void testAddNullElement() {
        assertThrows(NullItemException.class, () -> list.add(null));
    }

    @Test
    public void testSetNullElement() {
        list.add(5);
        list.add(7);
        assertThrows(NullItemException.class, () -> list.set(0, null));
    }

    @Test
    public void testRemoveInvalidIndex() {
        list.add(5);
        list.add(7);
        assertThrows(InvalidIndexException.class, () -> list.remove(-1));
        assertThrows(InvalidIndexException.class, () -> list.remove(2));
    }

    @Test
    public void testClearList() {
        list.add(5);
        list.add(7);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testEmptyListBeforeAndAfterOperations() {
        assertTrue(list.isEmpty());
        list.add(10);
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }


}