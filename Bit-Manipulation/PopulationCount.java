/**
 * Write a function that determines the number of 1 bits in the binary representation
 * of a given number.
 */

public class PopulationCount {
    // Time complexity: O(n)
    public static int populationCount(int num) {
        int result = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                result++;
            }
            num >>>= 1;
        }

        return result;
    }

    // Time complexity: O(m), m is the number of 1 bits in the given number.
    public static int populationCount_better(int num) {
        int result = 0;
        while (num != 0) {
            num &= num - 1;
            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(populationCount(-1));
        System.out.println(populationCount_better(3));
    }
}