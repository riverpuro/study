package abstractfactory.tablefactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Page;

public class TablePage extends Page {
    public TablePage(String title, String author) {
        super(title, author);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("<!DOCTYPE html><meta charset=\"UTF-8\"><html><head><title>%s</title></head>", title));
        builder.append("<body>\n");
        builder.append(String.format("<h1>%s</h1>", title));
        builder.append("<table width='80%' border='3'>\n");
        for (Item item : content) {
            builder.append(String.format("<tr>%s</tr>", item.makeHTML()));
        }
        builder.append("</table>");
        builder.append(String.format("<hr><address>%s</address>", author));
        builder.append("</body></html>");
        return builder.toString();
    }
}
