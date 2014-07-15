/**
 * Implement a function to perform a binary search on a sorted array of integers
 * to find the index of a given integer.
 */

public class BinarySearch {

    public static int binarySearch(int[] array, int target) throws BSException {
        return binarySearch(array, target, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int target, int lower, int upper)
                                    throws BSException {
        int range = upper - lower;
        if (range < 0) {
            throw new BSException("Limits reversed.");
        } else if (range == 0 && array[lower] != target) {
            throw new BSException("Target element no found.");
        }
        if (array[lower] > array[upper]) {
            throw new BSException("Array not sorted.");
        }

        int center = range / 2 + lower;
        if (array[center] == target) {
            return center;
        } else if (array[center] > target) {
            return binarySearch(array, target, lower, center - 1);
        } else {  //(array[center] > target)
            return binarySearch(array, target, center + 1, upper);
        }
    }

    public static void main(String[] args) {
        int[] testArray = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        try {
            System.out.println(binarySearch(testArray, ));

        } catch (BSException e) {
            System.out.println("oops.");
        }
    }
}
