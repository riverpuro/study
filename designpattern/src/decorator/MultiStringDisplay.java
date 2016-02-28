package decorator;

import java.util.ArrayList;

public class MultiStringDisplay extends Display {
    private int maxColumns = 0;
    private ArrayList<String> strings = new ArrayList<String>();

    public MultiStringDisplay() {
    }

    public void add(String string) {
        strings.add(string);
        int length = string.getBytes().length;
        if (length > maxColumns) {
            maxColumns = length;
        }
    }

    @Override
    public int getColumns() {
        return maxColumns;
    }

    @Override
    public int getRows() {
        return strings.size();
    }

    @Override
    public String getRowText(int row) {
        String line = strings.get(row);

        int paddingSize = maxColumns - line.getBytes().length;
        StringBuilder padding = new StringBuilder();
        for (int i = 0; i < paddingSize; i++) {
            padding.append(' ');
        }

        return line + padding;
    }
}
