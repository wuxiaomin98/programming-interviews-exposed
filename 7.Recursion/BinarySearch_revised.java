public class Test {
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int lower, int upper) {
        if (lower > upper) return -1;

        int mid = (upper + lower) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return binarySearch(array, target, mid + 1, upper);
        } else if (array[mid] > target) {
            return binarySearch(array, target, lower, mid - 1);
        }
        return -1;
    }

    public static int binarySearch_iteration(int[] array, int target) {
        int lower = 0;
        int upper = array.length - 1;
        while (lower <= upper) {
            int mid = (upper + lower) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                lower = mid + 1;
            } else if (array[mid] > target) {
                upper = mid - 1;
            }
        }
        return -1;
    }
}