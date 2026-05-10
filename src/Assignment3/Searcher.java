package Assignment3;

public class Searcher {

//Linear Search
    public int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; //at index i
            }
        }
        return -1; //not found
    }
}