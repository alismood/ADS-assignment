package Assignment3;

public class Experiment {
    private Sorter sorter = new Sorter();
    private Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        long startTime = System.nanoTime();
        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }
        return System.nanoTime() - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {
        long startTime = System.nanoTime();
        searcher.search(arr, target);
        return System.nanoTime() - startTime;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000}; // Small, Medium, Big

        for (int size : sizes) {
            System.out.println("\n--- Testing Array Size: " + size + " ---");
            int[] randomArray = sorter.generateRandomArray(size);

            //(Bubble)
            int[] bubbleArr = randomArray.clone();
            long bubbleTime = measureSortTime(bubbleArr, "basic");
            System.out.println("Bubble Sort Time: " + bubbleTime + " ns");

            //(Quick)
            int[] quickArr = randomArray.clone();
            long quickTime = measureSortTime(quickArr, "advanced");
            System.out.println("Quick Sort Time: " + quickTime + " ns");

            //(Linear)
            long searchTime = measureSearchTime(randomArray, -1); //bad case search
            System.out.println("Linear Search Time: " + searchTime + " ns");
        }
    }
}
