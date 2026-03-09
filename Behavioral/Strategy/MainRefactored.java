package Strategy;

interface SortStrategy {
    void sort();
}

class Catalogue {
    private SortStrategy strategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sortProducts() {
        if (strategy == null) {
            System.out.println("Please set a sorting strategy first!");
            return;
        }
        strategy.sort();
    }
}

class QuickSort implements SortStrategy{

    @Override
    public void sort() {
       System.out.println("Sorting products using Quick Sort algorithm...");
    }

}

class MergeSort implements SortStrategy{

    @Override
    public void sort() {
       System.out.println("Sorting products using Merge Sort algorithm...");
    }
    
}

class InsertionSort implements SortStrategy{

    @Override
    public void sort() {
       System.out.println("Sorting products using Insertion Sort algorithm...");
    }
    
}

public class MainRefactored {
    public static void main(String[] args) {
        Catalogue catalogue = new Catalogue();

        SortStrategy quickSort = new QuickSort();

        SortStrategy mergeSort = new MergeSort();

        SortStrategy insertionSort = new InsertionSort();

        System.out.println("--- Testing Refactored Catalogue ---");
        
        catalogue.setSortStrategy(quickSort);
        catalogue.sortProducts(); // Output: Sorting products using Quick Sort algorithm...

        catalogue.setSortStrategy(mergeSort);
        catalogue.sortProducts(); // Output: Sorting products using Merge Sort algorithm...

        catalogue.setSortStrategy(insertionSort);
        catalogue.sortProducts(); // Output: Sorting products using Insertion Sort algorithm...

    }
}