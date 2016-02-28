package abstractfactory.listfactory;

import abstractfactory.factory.Item;
import abstractfactory.factory.Page;

public class ListPage extends Page {
    public ListPage(String title, String author) {
        super(author, title);
    }

    @Override
    public String makeHTML() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("<!DOCTYPE html><html><meta charset=\"UTF-8\"><head><title>%s</title></head>\n", title));
        builder.append("<body>\n");
        builder.append(String.format("<h1>%s</h1>\n", title));
        builder.append("<ul>\n");
        for (Item item : content) {
            builder.append(item.makeHTML());
        }
        builder.append("</ul>\n");
        builder.append(String.format("<hr><address>%s</address>\n", author));
        builder.append("</body></html>\n");
        return builder.toString();
    }
}
