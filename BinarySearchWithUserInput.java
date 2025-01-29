import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWithUserInput {
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return mid; 
            } else if (arr[mid] < target) {
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {2, 3, 4, 10, 40};
        Arrays.sort(arr); 
        System.out.println("Array elements: " + Arrays.toString(arr));
        System.out.print("Enter target value: ");
        int target = scanner.nextInt();
        long startTime = System.nanoTime();
        int result = binarySearch(arr, target);
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000.0;
        if (result != -1) {
            System.out.println("Target found at index: " + result);
        } else {
            System.out.println("Target not found.");
        }
        System.out.println("Execution time: " + executionTime + " milliseconds");
        scanner.close();
    }
}
