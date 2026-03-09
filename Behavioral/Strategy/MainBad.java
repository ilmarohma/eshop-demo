package Strategy;

// The Bad Catalogue
class BadCatalogue {
    private String sortType;

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public void sortProducts() {
        if (sortType.equals("QuickSort")) {
            System.out.println("Sorting products using Quick Sort... (massive logic here)");
        } else if (sortType.equals("MergeSort")) {
            System.out.println("Sorting products using Merge Sort... (massive logic here)");
        } else if (sortType.equals("InsertionSort")) {
            System.out.println("Sorting products using Insertion Sort... (massive logic here)");
        }
    }
}

public class MainBad {
    public static void main(String[] args) {
        BadCatalogue catalogue = new BadCatalogue();

        System.out.println("--- Testing Bad Catalogue ---");
        
        catalogue.setSortType("QuickSort");
        catalogue.sortProducts();

        catalogue.setSortType("MergeSort");
        catalogue.sortProducts();
    }
}
