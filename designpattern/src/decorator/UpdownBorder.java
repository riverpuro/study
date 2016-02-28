package decorator;

public class UpdownBorder extends Border {
    private char borderChar;

    public UpdownBorder(Display display, char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return makeLine();
        } else if (row == getRows() - 1) {
            return makeLine();
        } else {
            return display.getRowText(row - 1);
        }
    }

    private String makeLine() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getColumns(); i++) {
            builder.append(borderChar);
        }
        return builder.toString();
    }
}
