/**
 * A library of various string processing functions.
 */

public class StringOps {

    // Tests the functions of this class.
    public static void main(String[] args) {
        test_all();
    }

    private static void test_all() {
        boolean testResult = test_alpha() && test_reverse() && test_lowercase()
                && test_is_palindrome() && test_find();
        System.out.println("success: " + testResult);
    }

    private static boolean test_alpha() {
        return alpha("Crickets talking back and forth in rhyme.").equals("Cricketstalkingbackandforthinrhyme");
    }

    /**
     * Returns a version of the given string in which all the non-alphabet characters are removed.
     */
    public static String alpha(String str) {
        // Initializing string to store characters

        String newAlphaString = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // Adds characters belonging to alphabetic range in ASCII to string

            if (c >= 65 && c <= 90 || c >= 97 && c <= 122) {
                newAlphaString += c;
            }
        }
        return newAlphaString;
    }

    private static boolean test_reverse() {
        return reverse("Blue river running slow and lazy").equals("yzal dna wols gninnur revir eulB");
    }

    /**
     * Returns a reversed version of the given string.
     */
    public static String reverse(String str) {

        // Initializing string for storage
        String reversedString = "";

        // Stores characters in reverse direction
        for (int i = (str.length() - 1); i >= 0; i--) {
            char c = str.charAt(i);
            reversedString += c;
        }
        return reversedString;
    }

    private static boolean test_lowercase() {
        return lowercase("San Francisco, Ashtabula").equals("san francisco, ashtabula");
    }

    /**
     * Returns a version of the given string in which all the uppercase alphabet characters
     * are changed to lowercase. Other characters are not changed.
     */
    public static String lowercase(String str) {

        // Initialize string for storage
        String lowercaseString = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 65 && c <= 90) {
                int difference = c - 'A';
                int location = 'a' + difference;

                lowercaseString += (char) location;
            } else {
                lowercaseString += c;
            }
        }
        return lowercaseString;
    }

    private static boolean test_is_palindrome() {
        String s = "A man, a plan, a canal, Panama.";
        String s2 = "A boy in a bucket";
        return (is_palindrome(s) && !is_palindrome(s2));
    }

    /**
     * Returns true if the given string is a palindrome, and false otherwise.
     * Non-alphabetic characters and casing are ignored.
     * For example, "Madam, in Eden, Im Adam." is a palindrome.
     */
    
    // Hint: This function can be implemented elegantly and simply by using other functions in this class.
    public static boolean is_palindrome(String str) {
        str = alpha(str);
        str = lowercase(str);
        return str.equals(reverse(str));
    }

    private static boolean test_find() {
        String str = "Flowers on the hillside blooming crazy";
        String s = "hillside";
        boolean testResult = find(str, s) == 15;
        String s2 = "flowers";
        testResult = testResult && (find(str, s2) == -1);
        String s3 = "lonesome";
        testResult = testResult && (find(str, s3) == -1);

        return testResult;
    }


    /**
     * Returns the index of the given substring in the given string, or -1 if there is no such substring.
     * If the substring occurs more than once, returns the index of the first occurence.
     * Casing matters, so "A" doesn't equal "a".
     */

    // Creating a substring function to call in find
    private static String substringFunction(String str, int start, int stop) {

        //Initializing string
        String substringVariable = "";

        for (int i = start; i < stop; i++) {
            char c = str.charAt(i);
            substringVariable += c;
        }
        return substringVariable;
    }


    public static int find(String str, String substr) {

        for (int i = 0; i < str.length() - substr.length(); i++) {
            String substring = substringFunction(str, i, substr.length() + i);

            // Return index where substr appears on str
            if (substring.equals(substr)) {
                return i;
            }
        }
        return -1;
    }
}
