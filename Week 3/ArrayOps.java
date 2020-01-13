/**
 * A library of various array processing functions.
 */
public class ArrayOps {
    // Tests the functions of this class. 
    public static void main(String[] args) {
        test_all();
    }

    private static void test_all() {
        boolean testResult = test_equals() && test_sum() && test_maxSub();
        System.out.println("success: " + testResult);
    }

    private static boolean test_equals() {
        int[] a = {2, 1, 9};
        int[] b = {0, 8, 11};
        int[] c = {0, 8, 11};
        boolean testResult = !(equals(a, b)) && equals(b, c);
        return testResult;
    }

    /**
     * Returns true if the two arrays have the same elements, false otherwise.
     */
    public static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean test_sum() {
        int[] a = {2, 1, 9};
        int[] b = {-1, 11, 2};
        int[] c = {2, 2, 3, 4, -1};
        int sumArr_a = sum(a, 1, 3);
        int sumArr_b = sum(b, 0, 2);
        int sumArr_c = sum(c, 0, c.length);
        boolean testResult = (sumArr_a == sumArr_b) && (sumArr_b == sumArr_c);
        return testResult;
    }

    /**
     * Returns the sum of all the values in the given array, from index start to
     * index stop-1.
     */
    public static int sum(int[] arr, int start, int stop) {
        int arraySum = 0;

        for (int i = start; i < stop; i++) {
            arraySum += arr[i];
        }
        return arraySum;
    }

    private static boolean test_maxSub() {
        int[] a = {2, 1, 9, 3};
        int[] b = {10, -1, 1, 9, 3};
        int[] c = {2, 2, 3, 4, -1};
        int[] subA3 = maxSub(a, 3);
        int[] subB3 = maxSub(b, 3);
        int[] subC3 = maxSub(c, 3);
        boolean testResult = equals(subA3, subB3)
                && !(equals(subB3, subC3));
        return testResult;
    }

    /**
     * Goes through all the subarrays of length m in the given array,
     * and returns the subarray that has the largest sum of array values.
     */
    public static int[] maxSub(int[] arr, int m) {
        if (m > arr.length) {
            return null;
        }

        // Initializing variables
        int startIndex = 0;

        int maxSum = sum(arr, startIndex, m);

        for (int i = m + 1; i <= arr.length; i++) {
            startIndex++;
            int tempSum = sum(arr, startIndex, i);
            if (tempSum > maxSum) {
                startIndex = i - m;
                maxSum = tempSum;
            }
        }

        int[] subArray = new int[m];
        for (int j = 0; j < m; j++) {
            subArray[j] = arr[startIndex + j];
        }
        return subArray;
    }
}
