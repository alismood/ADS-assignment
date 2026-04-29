package Assignment3;

public class Searcher {

    // Category C: Linear Search [cite: 19, 34]
    public int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Target found at index i
            }
        }
        return -1; // Target not found
    }
}