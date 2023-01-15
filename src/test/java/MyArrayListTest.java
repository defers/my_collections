import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class MyArrayListTest {

    List<String> myArr;

    @Before
    public void setup() {
        myArr = new MyArrayList<>();
    }

    @Test
    public void shouldReturnSize0WhenArrayIsEmpty() {
        int size = myArr.size();

        int expected = 0;

        assertEquals(expected, size);
    }

    @Test
    public void shouldReturnSizeNotZeroWhenArrayIsNotEmpty() {
        myArr.add("Element1");
        myArr.add("Element2");

        int size = myArr.size();
        int expected = 2;

        assertEquals(expected, size);
    }

    @Test
    public void shouldReturnTrueWhenisEmpty() {
        boolean result = myArr.isEmpty();
        boolean expected = true;
        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnFalseWhenNotIsEmpty() {
        myArr.add("Element1");
        boolean result = myArr.isEmpty();

        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnTrueIfContainsElement() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        boolean result = myArr.contains("Element2");
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnFalseIfNotContainsElement() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        boolean result = myArr.contains("Element4");
        boolean expected = false;

        assertEquals(expected, result);
    }


    @Test
    public void shouldReturnEmptyArray() {
        String[] expected = {};
        assertArrayEquals(expected, myArr.toArray());
    }

    @Test
    public void shouldReturnArrayWithTwoElements() {
        String e1 = "Element1";
        String e2 = "Element2";
        myArr.add(e1);
        myArr.add(e2);

        String[] expected = {e1, e2};

        assertArrayEquals(expected, myArr.toArray());
    }

    @Test
    public void shouldFillArrayWithTwoElements() {
        String e1 = "Element1";
        String e2 = "Element2";
        myArr.add(e1);
        myArr.add(e2);

        String[] expected = {e1, e2};
        String[] resultArr = myArr.toArray(new String[2]);

        assertArrayEquals(expected, resultArr);
    }

    @Test
    public void shouldReturnSize3WhenAdded3Elements() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        int expectedSize = 3;

        assertEquals(expectedSize, myArr.size());
    }

    @Test
    public void shouldReturnSize100WhenAdded100Elements() {
        for (int i = 0; i < 100; i++) {
            myArr.add("Element" + i);
        }

        int expectedSize = 100;

        assertEquals(expectedSize, myArr.size());
    }

    @Test
    public void shouldReturnSize2WhenRemoved1Element() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        myArr.remove("Element2");

        int expectedSize = 2;

        assertEquals(expectedSize, myArr.size());
    }

    @Test
    public void shouldReturnSize0WhenCleared() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        myArr.clear();

        int expectedSize = 0;

        assertEquals(expectedSize, myArr.size());
    }

    @Test
    public void get() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        String expected = "Element2";
        String res = myArr.get(1);

        assertEquals(expected, res);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOutOfBoundsException() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        String res = myArr.get(3);
    }

    @Test
    public void set() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        String expected = "NewElement2";
        myArr.set(1, expected);

        assertEquals(expected, myArr.get(1));
        assertEquals(3, myArr.size());
    }

    @Test
    public void shouldAddElementInSecondPosition() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        String expected = "NewElement2";
        myArr.add(1, expected);

        assertEquals(expected, myArr.get(1));
        assertEquals("Element1", myArr.get(0));
        assertEquals("Element2", myArr.get(2));
        assertEquals("Element3", myArr.get(3));
        assertEquals(4, myArr.size());
    }

    @Test
    public void shouldReturnSize2WhenRemoved1ElementByIndex() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");

        myArr.remove(1);

        int expectedSize = 2;

        assertEquals("Element3", myArr.get(1));
        assertEquals(expectedSize, myArr.size());
    }

    @Test
    public void shouldReturnIndexOfElement() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");
        myArr.add("Element4");
        myArr.add("Element5");

        int expected = 3;

        assertEquals(expected, myArr.indexOf("Element4"));
    }

    @Test
    public void shouldReturnMinusOneWhenObjectIsNotInList() {
        myArr.add("Element1");
        myArr.add("Element2");
        myArr.add("Element3");
        myArr.add("Element4");
        myArr.add("Element5");

        int expected = -1;

        assertEquals(expected, myArr.indexOf("Element100"));
    }
}