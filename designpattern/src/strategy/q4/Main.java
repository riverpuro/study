package strategy.q4;

public class Main {
    public static void main(String... args) {
        String[] data1 = new String[] {
                "Dumpty", "Bowman", "Carroll", "Elfland", "Alice",
        };
        String[] data2 = new String[] {
                "Dumpty", "Bowman", "Carroll", "Elfland", "Alice",
        };

        SortAndPrint sap1 = new SortAndPrint(data1, new SelectionSorter());
        sap1.execute();

        SortAndPrint sap2 = new SortAndPrint(data2, new InsertSorter());
        sap2.execute();
    }
}