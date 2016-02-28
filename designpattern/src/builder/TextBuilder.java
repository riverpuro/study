package builder;

public class TextBuilder implements Builder {
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        buffer.append("==============================\n");
        buffer.append("『");
        buffer.append(title);
        buffer.append("』\n");
        buffer.append("\n");
    }

    @Override
    public void makeString(String str) {
        buffer.append("■");
        buffer.append(str);
        buffer.append("\n\n");
    }

    @Override
    public void makeItems(String[] items) {
        for (String item : items) {
            buffer.append("  ・");
            buffer.append(item);
            buffer.append("\n");
        }
        buffer.append("\n");
    }

    @Override
    public void close() {
        buffer.append("==============================\n");
    }

    public String getResult() {
        return buffer.toString();
    }
}
