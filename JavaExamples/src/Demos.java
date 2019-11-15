import java.util.*;
/*
 *  Demo Code for the data structure tasks in the smart products lecture.
 *  The students are required to write tests for this class.
 *  There are four sections: CREATE, READ, UPDATE, DELETE for which tests are to be written
 *  In total, 16 tests are prepared, of which 4 are already finished as examples, one test per data structure per section.
 *  We tried to mix up different ways of fulfilling operations on each section to show multiple possible solutions.
 */
public class Demos {
    public static void main(String[] args) {

        // SETUP: Declaration and initialization of the four data structures
        char[] letterArray = new char[13];
        ArrayList<String> wordList = new ArrayList<>();
        HashMap<Integer, String> nameMap = new HashMap<>();
        TreeSet<Integer> sortedNumbers = new TreeSet<>();

        // CREATE: Filling of the data structures with initial data. This is done with method calls.
        fillArray(letterArray, "Filling array");
        fillList(wordList, "Lets fill this list with this exact string");
        fillMap(nameMap);
        fillSet(sortedNumbers);

        System.out.println("Values of collections before change");
        printAllValues(letterArray);
        printAllValues(wordList);
        printAllValues( nameMap);
        printAllValues(sortedNumbers);
        System.out.println(); // empty line for spacing

        // READ: Output of every value for each data structure. Also with method calls.
        System.out.println("Values after specific read operations");
        printAllValues(readArrayFromTo(letterArray, 2, 9));
        System.out.println(readFromList(wordList, 5));
        printAllValues(readHalfFromMap(nameMap));
        printAllValues(readSetReversedOrder(sortedNumbers));
        System.out.println(); // empty line for spacing

        // UPDATE: Change values in a collection. You guessed it: method calls. Displays change after operation
        System.out.println("Values of collections after change");
        changeArray(letterArray, 1, 'ü');
        printAllValues(letterArray);
        changeList(wordList, 3, 7);
        printAllValues(wordList);
        changeMap(nameMap, 5, "Eve", 3);
        printAllValues(nameMap);
        changeSet(sortedNumbers, 1337, 2);
        printAllValues(sortedNumbers);
        System.out.println(); // empty line for spacing

        // DELETE: Deletes all values in the collections, for example to prepare them for new filling
        // Disclaimer: to actually delete a collection, <collection> = null is enough, but we want to show different ways.
        System.out.println("Collections after deletion/clearing");
        clearArray(letterArray);
        printAllValues(letterArray);
        clearList(wordList);
        printAllValues(wordList);
        clearMap(nameMap);
        printAllValues(nameMap);
        clearSet(sortedNumbers);
        printAllValues(sortedNumbers);
    }

    /*
        Four methods to print values of the collections provided by the caller
     */
    private static void printAllValues(char[] inputArray){
        System.out.print("| ");
        for (char c : inputArray) {
            System.out.print(c + " | ");
        }
        System.out.println(); // empty line for spacing
    }

    private static void printAllValues(Map<Integer, String> inputMap){
        System.out.println(inputMap.values());
    }

    private static void printAllValues(List<String> inputList) {
        System.out.println(inputList);
    }

    private static void printAllValues(Set<Integer> inputSet){
        System.out.println(inputSet);
    }


    /*
        Method that takes a reference of the letterArray and a String.
        Fills the single letters of the String into the Array.
        Example "hello" becomes [h][e][l][l][o]
     */
    public static void fillArray(char[] charArray, String stringToFill) {
        for (int i = 0; i < stringToFill.length(); i++) {
            charArray[i] = stringToFill.charAt(i);
        }
    }

    /*
        Methods that fills an arrayList with the single words of a specified String
     */
    public static void fillList(List<String> theList, String stringToFill) {
        String[] singleWords = stringToFill.split(" ");
        theList.addAll(Arrays.asList(singleWords));
    }

    /*
        Fills Map with names which are commonly used in cryptography do depict different users
        which interact with a cryptographic system.
     */
    public static void fillMap(HashMap<Integer, String> nameMap) {
        nameMap.put( 2,"Alice" );
        nameMap.put( 1, "Bob");
        nameMap.put( 5, "Charlie");
        nameMap.put( 3, "Chuck");
        nameMap.put( 4, "Erin");
        nameMap.put( 8, "Heidi");
        nameMap.put( 7, "Pat");
        nameMap.put( 6, "Trudy");
        nameMap.put( 9, "Walter"); //found him

    }

    /*
        Method that fills the set with arbitrary numbers from a predefined array filled with 'random' numbers
     */
    public static void fillSet(TreeSet<Integer> sortedNumbers) {
        int[] definedNumbers = {68 ,56, 46, 95, 30, 51 , 2, 82, 36, 42};
        for (Integer i: definedNumbers) {
            sortedNumbers.add(i);
        }
    }

    /*
       Returns an array with the values from the input array beginning at index 'from' and ending at index 'to'.
       The new array needs to be of length 1 + (to-from) since we want the value at index 'to' to be in the new array
       (This was actually found out by writing a test for this class)
     */
    public static char[] readArrayFromTo(char[] letterArray, int from, int to) {
        char[] returnArray = new char[1+to-from];
        for (int i = 0; i < returnArray.length; i++) {
            returnArray[i] = letterArray[from];
            from++;
        }
        return returnArray;
    }

    /*
        Reads a specific index from a list, including a check if the index is valid
     */
    public static String readFromList(ArrayList<String> wordList, int indexToRead) {
        if(indexToRead >= wordList.size()){
            return "This is not a valid index.";
        } else {
            return wordList.get(indexToRead);
        }
    }

    /*
        returns a map with the first half of the input map
     */
    public static HashMap<Integer, String> readHalfFromMap(HashMap<Integer, String> nameMap) {
        HashMap<Integer, String> returnMap = new HashMap<>();
        int newMapSize = nameMap.size() / 2;
        for (int i = 0; i < newMapSize; i++) {
            returnMap.put(i, nameMap.get(i));
        }
        return returnMap;
    }

    /*
        Returns a set with the values from the input set in reversed order.
     */
    public static TreeSet<Integer> readSetReversedOrder(TreeSet<Integer> sortedNumbers) {
        return (TreeSet<Integer>)sortedNumbers.descendingSet();
    }



    /*
        Change the value at index i with the char c
     */
    public static void changeArray(char[] letterArray, int indexToChange, char newChar) {
        letterArray[indexToChange] = newChar;
    }

    /*
        Switches string with list
     */
    public static void changeList(ArrayList<String> wordList, int first, int second) {
        String temporary = wordList.get(first);
        wordList.remove(first);
        wordList.add(first, wordList.get(second-1)); //would lead to Exception if index == second
        wordList.remove(second);
        wordList.add(second, temporary);
    }

    /*
        Replaces the value of key keyToReplace with stringToReplace and removes value of key keyToDelete
     */
    public static void changeMap(HashMap<Integer, String> nameMap,
                                  int keyToReplace,
                                  String stringToReplace,
                                  int keyToDelete) {
        nameMap.replace(keyToReplace, stringToReplace);
        nameMap.remove(keyToDelete);
    }

    /*
        Adds values firstNumberToAdd and SecondNumberToAdd to the sortedNumbers set
     */
    public static void changeSet(TreeSet<Integer> sortedNumbers, int firstNumberToAdd, int secondNumberToAdd){
        sortedNumbers.add(firstNumberToAdd);
        sortedNumbers.add(secondNumberToAdd);
    }

    /*
        Replaces all chars with empty chars
     */
    public static void clearArray(char[] arrayToClear){
        Arrays.fill(arrayToClear, ' ');
    }

    /*
        Clears all values of list
     */
    public static void clearList(ArrayList<String> listToClear){
        listToClear.removeAll(listToClear);
    }

    /*
        Clears the Map completely
     */
    public static void clearMap(HashMap<Integer, String> mapToClear) {
        mapToClear.clear();
    }

    /*
        Removes first value until set is empty
     */
    public static void clearSet(TreeSet<Integer> setToClear){
        while(setToClear.size() != 0){
            setToClear.remove(setToClear.first());
        }
    }
}
