import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class DemosTestSolution {
    private char[] testArray = new char[10];
    private ArrayList<String> testList = new ArrayList<>();
    private HashMap<Integer, String> testMap = new HashMap<>();
    private TreeSet<Integer> testSet = new TreeSet<>();

    @Test
    void testArrayCreate(){
        char[] expectedArray = {'t', 'e', 's', 't', 'S', 't', 'r', 'i', 'n', 'g'};
        Demos.fillArray(testArray, "testString");
        assertArrayEquals(testArray, expectedArray);
    }

    @Test
    void testListCreate(){
        ArrayList<String> expectedList = new ArrayList<>();
        expectedList.add("Test");
        expectedList.add("sentence");
        Demos.fillList(testList, "Test sentence");
        assertEquals(testList, expectedList);
    }



    @Test
    void testMapCreate(){
        HashMap<Integer, String> expectedMap = new HashMap<>();
        expectedMap.put(3, "Chuck");
        Demos.fillMap(testMap);
        assert (testMap.get(3).equals(expectedMap.get(3)));
    }

    @Test
    void testSetCreate(){
       Demos.fillSet(testSet);
       assertTrue(testSet.contains(95));
    }

    @Test
    void testArrayRead(){
        Demos.fillArray(testArray, "Robot");
        char[] expected = {'b', 'o'};
        char[] actual = Demos.readArrayFromTo(testArray, 2, 3);
        assertArrayEquals(actual,expected);
    }

    @Test
    void testListRead(){
        Demos.fillList(testList, "Test String for testing");
        String actual = Demos.readFromList(testList,2);
        assertEquals("for", actual);
    }

    @Test
    void testMapRead(){
        Demos.fillMap(testMap);
        int initialSize = testMap.size();
        int actualSize = Demos.readHalfFromMap(testMap).size();
        assertEquals(initialSize/2, actualSize);

    }

    @Test
    void testSetRead(){
        Demos.fillSet(testSet);
        int initialLast = testSet.last();
        int actualFirst = Demos.readSetReversedOrder(testSet).first();
        assertEquals(initialLast, actualFirst);
    }

    @Test
    void testArrayUpdate(){
        char expected = 'A';
        Demos.changeArray(testArray, 0, expected);
        assertEquals(expected, testArray[0]);
    }

    @Test
    void testListUpdate(){
        String firstWord = "TestWordOne";
        String secondWord = "TestWordTwo";
        testList.add(firstWord);
        testList.add(secondWord);
        testList.add("someString");
        Demos.changeList(testList, 0, 1);
        assertEquals(firstWord, testList.get(1));
        assertEquals(secondWord, testList.get(0));
    }

    @Test
    void testMapUpdate(){
        String expected = "NewName";
        testMap.put(1, "FirstName");
        testMap.put(5, "SecondName");
        Demos.changeMap(testMap, 1, expected, 5);
        assertEquals(expected, testMap.get(1));
        assertFalse(testMap.containsKey(5));
    }

    @Test
    void testSetUpdate(){
        TreeSet<Integer> expected = new TreeSet<>();
        expected.add(42);
        expected.add(1337);
        Demos.changeSet(testSet, 42,1337);
        assertEquals(expected, testSet);
    }

    @Test
    void testArrayDelete(){
        Demos.fillArray(testArray, "To Delete");
        boolean hasNoValues = true;
        Demos.clearArray(testArray);
        for (int i = 0; i < testArray.length; i++) {
            if (testArray[i] != ' '){
                hasNoValues = false;
            }
        }
        assertTrue(hasNoValues);
    }

    @Test
    void testListDelete(){
        testList.add("TestWord");
        Demos.clearList(testList);
        assertTrue(testList.isEmpty());

    }

    @Test
    void testMapDelete(){
        testMap.put(5, "TestWord");
        Demos.clearMap(testMap);
        assertTrue(testMap.isEmpty());
    }

    @Test
    void testSetDelete(){
        testSet.add(229);
        Demos.clearSet(testSet);
        assertTrue(testSet.isEmpty());
    }


}