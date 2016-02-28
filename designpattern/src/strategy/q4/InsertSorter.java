package strategy.q4;

public class InsertSorter implements Sorter {
    @Override
    public void sort(Comparable[] data) {
        for (int i = 1; i < data.length; i++) {
            Comparable a = data[i];
            for (int j = 0; j < i; j++) {
                Comparable b = data[j];
                if (a.compareTo(b) < 0) {
                    // offset after j
                    for (int k = i; k > j; k--) {
                        data[k] = data[k - 1];
                    }
                    data[j] = a;
                    break;
                }
            }
        }
    }
}