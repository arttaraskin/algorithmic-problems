public class BinarySearch {

    // Method to perform binary search
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Calculate middle index to prevent overflow

            // Check if the target is present at mid
            if (arr[mid] == target) {
                return mid; // Target found, return its index
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                low = mid + 1;
            }
            // If target is smaller, ignore right half
            else {
                high = mid - 1;
            }
        }

        // Target not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target1 = 23;
        int target2 = 7;

        // Search for target1
        int result1 = binarySearch(sortedArray, target1);
        if (result1 != -1) {
            System.out.println("Element " + target1 + " found at index " + result1);
        } else {
            System.out.println("Element " + target1 + " not found in the array.");
        }

        // Search for target2
        int result2 = binarySearch(sortedArray, target2);
        if (result2 != -1) {
            System.out.println("Element " + target2 + " found at index " + result2);
        } else {
            System.out.println("Element " + target2 + " not found in the array.");
        }
    }
}
